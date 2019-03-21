package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("lab04 solution");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 400, 300);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new grid pane
        GridPane gridPane = new GridPane();

       gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Set the horizontal gap between columns
        gridPane.setHgap(5);

        // Set the vertical gap between rows
        gridPane.setVgap(5);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add username Label
        Label userLabel = new Label("Username: ");
        gridPane.add(userLabel, 0,1);

        // Add username Text Field
        TextField userField = new TextField();
        userField.setPrefHeight(20);
        userField.setPrefWidth(20);
        gridPane.add(userField, 1,1);

        // Add password Label
        Label passwordLabel = new Label("Password: ");
        gridPane.add(passwordLabel, 0, 2);

        // Add password Text Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(20);
        gridPane.add(passwordField, 1, 2);

        // Add full name Label
        Label fullnameLabel = new Label("Full Name: ");
        gridPane.add(fullnameLabel, 0, 3);

        // Add full name Field
        TextField fullnameField = new TextField();
        fullnameField.setPrefHeight(20);
        gridPane.add(fullnameField, 1, 3);

        // Add email Label
        Label emailLabel = new Label("Email: ");
        gridPane.add(emailLabel, 0, 4);

        // Add email Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(20);
        gridPane.add(emailField, 1, 4);

        // Add phone Label
        Label phoneLabel = new Label("Phone #: ");
        gridPane.add(phoneLabel, 0, 5);

        // Add phone Field
        TextField phoneField = new TextField();
        phoneField.setPrefHeight(20);
        gridPane.add(phoneField, 1, 5);

        // Add date Label
        Label dateLabel = new Label("Date of Birth: ");
        gridPane.add(dateLabel, 0, 6);

        // Add date Field
        DatePicker datePicker = new DatePicker();
        datePicker.setPrefHeight(20);
        gridPane.add(datePicker, 1, 6);

        // Add Submit Button
        Button submitButton = new Button("Register");
        submitButton.setPrefHeight(20);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(75);
        gridPane.add(submitButton, 0, 7, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(0, 0,0,0));

        submitButton.setOnAction(event -> {
            System.out.println(userField.getText());
            System.out.println(passwordField.getText());
            System.out.println(fullnameField.getText());
            System.out.println(emailField.getText());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
