 
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;
public class MyPlayer implements Player{
    private Circle ball;
    private Map map;
    private Position position;
    public MyPlayer(Map map){
        this.map = map;
        this.position = new Position(map.getStartPosition().getX(), map.getStartPosition().getY());  // start Position for ball
        ball = new Circle(position.getX()*map.getUnit()+map.getUnit()/2, position.getY()*map.getUnit()+map.getUnit()/2, map.getUnit()/2); // +getUnit()/2 in order to place circle in center of square
        ball.setStroke(Color.RED);
        ball.setFill(Color.RED);
        map.getChildren().addAll(ball);
        map.setOnKeyPressed(e->{
            try {
                if (e.getCode() == KeyCode.RIGHT) {
                    moveRight();
                } else if (e.getCode() == KeyCode.UP) {
                    moveUp();
                } else if (e.getCode() == KeyCode.LEFT) {
                    moveLeft();
                } else if (e.getCode() == KeyCode.DOWN) {
                    moveDown();
                } else {
                    System.out.println("Use arrow");  // if player pressed the wrong button
                }
            } catch (Exception ex){  // catch array out of bounds exception
                ;  // in order to there no errors in cmd
            }
        });
        map.requestFocus(); // so that pane accepts applications
    }

    @Override
    public void moveRight() {
        if (map.getMap()[position.getX() + 1][position.getY()] != 1){  // check is it white square
            if (ball.getCenterX() + map.getUnit() <= map.getWidth()){  //check does the ball overstep the map bounds
                position.setX(position.getX() + 1);  // sum the initial position to 1
                ball.setCenterX(ball.getCenterX() + map.getUnit()); // move circle to 50 pixels
            }
        }
    }

    @Override
    public void moveDown() {
        if (map.getMap()[position.getX()][position.getY()+1] != 1) {
            if (ball.getCenterY() + map.getUnit() <= map.getHeight()) {
                position.setY(position.getY() + 1);
                ball.setCenterY(ball.getCenterY() + map.getUnit());
            }
        }
    }
    @Override
    public void moveUp(){
        if (map.getMap()[position.getX()][position.getY()-1] != 1) {
            if (ball.getCenterY() - map.getUnit() >= 0) {  // check does the ball overstep the map bounds
                position.setY(position.getY() - 1);
                ball.setCenterY(ball.getCenterY() - map.getUnit());
            }
        }
    }
    @Override
    public void moveLeft() {
        if (map.getMap()[position.getX()-1][position.getY()] != 1) {
            if (ball.getCenterX() - map.getUnit() >= 0) {
                position.setX(position.getX() - 1);
                ball.setCenterX(ball.getCenterX() - map.getUnit());
            }
        }
    }
    @Override
    public Position getPosition(){  // return position of circle at this time (use in food class)
        return position;
    }
}
