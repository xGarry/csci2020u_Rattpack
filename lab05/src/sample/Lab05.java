package sample;

import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Lab05 extends Application {

    Stage window;
    TableView<StudentRecord> table;


    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("stuff");

        //SID
        TableColumn<StudentRecord, String> sidColumn = new TableColumn("SID");
        sidColumn.setMinWidth(200);
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));

        //Assignments
        TableColumn<StudentRecord, Float> assignmentsColumn = new TableColumn("Assignments");
        assignmentsColumn.setMinWidth(200);
        assignmentsColumn.setCellValueFactory(new PropertyValueFactory<>("assignment"));

        //Midterm
        TableColumn<StudentRecord, Float> midtermColumn = new TableColumn("Midterm");
        midtermColumn.setMinWidth(200);
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        //Final Exam
        TableColumn<StudentRecord, Float> examColumn = new TableColumn("Final Exam");
        examColumn.setMinWidth(200);
        examColumn.setCellValueFactory(new PropertyValueFactory<>("finalExam"));

        //Final Mark
        TableColumn<StudentRecord, Float> finalMarkColumn = new TableColumn("Final Mark");
        finalMarkColumn.setMinWidth(200);
        finalMarkColumn.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        //Letter Grade
        TableColumn<StudentRecord, String> letterGradeColumn = new TableColumn("Letter Grade");
        letterGradeColumn.setMinWidth(200);
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));

        table = new TableView<>();
        table.setItems(getAllMarks());
        table.getColumns().addAll(sidColumn, assignmentsColumn, midtermColumn, examColumn, finalMarkColumn, letterGradeColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll();

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }



    public static void main(String[] args) {
        launch(args);
    }

        public ObservableList<StudentRecord> getAllMarks() {
            ObservableList<StudentRecord> marks = FXCollections.observableArrayList();
            // Student ID, Assignments, Midterm, Final exam
            marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
            marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
            marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
            marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
            marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
            marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
            marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
            marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
            marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
            marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));
            return marks;
        }
}





