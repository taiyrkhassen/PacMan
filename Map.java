
import javafx.scene.layout.Pane;
import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
public class Map extends Pane {
    private int unit = 50;  //size of one square (in pixels)
    private int size;     //size of map (number of columns/rows)
    private int[][] map;
    private Position start;
    public Map(String path){
        try {
            File file = new File(path);
            Scanner input = new Scanner(file);
            size = input.nextInt();  //size of map (number of columns/rows)(8), return 1st symbol in txt
            map = new int[size][size];
            while (input.hasNext()) {   // going through txt
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        map[j][i] = input.nextInt(); //fill the map array from txt, from up to down
                    }
                }
            }
            input.close();
        } catch (IOException ex) {
            System.out.println("Exception!");
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {  //going through map array
                if (map[i][j] == 0) {  // if 0 make white square with size = Unit
                    Rectangle rectangle = new Rectangle(i * getUnit(), j * getUnit(), getUnit(), getUnit());
                    rectangle.setStroke(Color.BLACK);
                    rectangle.setFill(Color.WHITE);
                    getChildren().add(rectangle);  // map class extends Pane
                } else if (map[i][j] == 1) {  // if value map[i][j] == 1 make black rectangle
                    Rectangle rectangle = new Rectangle(i * getUnit(), j * getUnit(), getUnit(), getUnit());
                    rectangle.setStroke(Color.BLACK);
                    rectangle.setFill(Color.BLACK);
                    getChildren().add(rectangle);
                } else if (map[i][j] == 2) {  // set start position to make ball in MyPlayer class  and also make white square
                    Rectangle rectangle = new Rectangle(i * getUnit(), j * getUnit(), getUnit(), getUnit());
                    rectangle.setStroke(Color.BLACK);
                    rectangle.setFill(Color.WHITE);
                    start = new Position();  // object of position class
                    start.setX(i);
                    start.setY(j);
                    getChildren().addAll(rectangle);

                }
            }
        }
    }

    public int getUnit(){  // return  variable unit
        return this.unit;
    }

    public int getSize() {  // return size of map
        return this.size;
    }

    public int[][] getMap() {  // return map array
        return this.map;
    }

    public Position getStartPosition() {  // return start position of ball
        return start;
    }
}
