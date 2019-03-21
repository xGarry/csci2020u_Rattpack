package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TicTacToe extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        pane.setPadding(new Insets(5, 5, 5, 5));
        Image x = new Image("file:///C:/Users/Garry/Downloads/image/x.gif");
        Image o = new Image("file:///C:/Users/Garry/Downloads/image/o.gif");

        pane.add(new ImageView(x),0,0);
        pane.add(new ImageView(x),1,0);
        pane.add(new ImageView(x),2,0);
        pane.add(new ImageView(x),0,1);
        pane.add(new ImageView(x),1,1);
        pane.add(new ImageView(o),2,1);
        pane.add(new ImageView(x),1,2);
        pane.add(new ImageView(o),2,2);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane,200,200);
        primaryStage.setTitle("ShowGridPane"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
