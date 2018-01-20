/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingball;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jennifer
 */
public class MovingBall extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 300, 300);
        Circle ball = new Circle (10, Color.RED);
        ball.relocate(0, 10);
        canvas.getChildren().add(ball);
        stage.setTitle("Moving Ball");
        stage.setScene(scene);
        stage.show();
        
        Bounds bounds = canvas.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3),
           new KeyValue(ball.layoutXProperty(), bounds.getMaxX()-ball.getRadius())));
        timeline.setCycleCount(2);
        timeline.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
