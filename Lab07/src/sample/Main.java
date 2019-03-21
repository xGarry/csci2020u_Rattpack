package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage){

        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("weatherwarnings-2015.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add((values[5]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] arr = new String[records.size()];
        arr = records.toArray(arr);

        int count = 0;

        int occurences[] = {0, 0, 0, 0};
        String[] type = {"FLASH FLOOD", "SEVERE THUNDERSTORM", "SPECIAL MARINE", "TORNADO"};

        for(int i = 0;i < arr.length;i++) {

            if(arr[i].equals("FLASH FLOOD")) {
                occurences[0] += 1;
            }

            else if(arr[i].equals("SEVERE THUNDERSTORM")){
                occurences[1] += 1;
            }

            else if(arr[i].equals("SPECIAL MARINE")){
                occurences[2] += 1;
            }

            else if (arr[i].equals("TORNADO")){
                occurences[3] += 1;
            }

        }
        System.out.println(" Occurences: " + occurences[0] + " " + occurences[1] + " " + occurences[2] + " " + occurences[3]);


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(int i = 0; i <= 3; i++){
            pieChartData.addAll(new PieChart.Data(type[i], occurences[i]));
        }


        //Creating a Pie chart
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Weather Statistics");
        pieChart.setClockwise(false);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(false);
        pieChart.setLegendVisible(true);

        FlowPane root = new FlowPane();
        root.getChildren().addAll(pieChart);

        String[] pieColours = {
                "aqua", "gold", "darkorange",
                "darksalmon", "lawngreen", "plum"
        };

        for(int i = 0; i <= 5; i++){
            for(Node n:pieChart.lookupAll(".default-color" + i +".chart-pie")) {
                n.setStyle("-fx-pie-color: "+ pieColours[i] + ";");
            }
        }

        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle("Bar Chart");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }


}
