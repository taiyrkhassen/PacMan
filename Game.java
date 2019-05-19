
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game extends Application {
    @Override
    public void start(Stage primaryStage){
        Map map = new Map(mapName); //creating map
        MyPlayer myPlayer = new MyPlayer(map); // add ball to the map
        Food food = new Food(map,myPlayer); // add food to the map
        Scene scene = new Scene(map);

        primaryStage.setTitle("Project-1");
        primaryStage.setScene(scene);
        primaryStage.show();
        map.requestFocus();
    }
    static String mapName;
    public static void main(String[] args) {
        mapName = args[0];
        launch(args); // Map.txt is the path 
    }
}