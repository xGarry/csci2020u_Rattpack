package sample;

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.observableArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8")));
        xAxis.setLabel("Year");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Price");

        //Creating the Bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Commercial and Housing Prices");

        XYChart.Series<String, Number> housingPrices = new XYChart.Series<>();
        housingPrices.setName("Housing Prices");
        XYChart.Series<String, Number> commercialPrices = new XYChart.Series<>();
        commercialPrices.setName("Commercial Prices");

        double[] avgHousingPricesByYear = {
                247381.0,264171.4,287715.3,294736.1,
                308431.4,322635.9,340253.0,363153.7
        };
        double[] avgCommercialPricesByYear = {
                1121585.3,1219479.5,1246354.2,1295364.8,
                1335932.6,1472362.0,1583521.9,1613246.3
        };

        for(int i = 0; i <= 7; i++){
            housingPrices.getData().add(new XYChart.Data<>(Integer.toString(i+1), avgHousingPricesByYear[i]));
            commercialPrices.getData().add(new XYChart.Data<>(Integer.toString(i+1), avgCommercialPricesByYear[i]));
        }


        String[] ageGroups = {
                "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
        };
        int[] purchasesByAgeGroup = {
                648, 1021, 2453, 3173, 1868, 2247
        };
        String[] pieColours = {
                "aqua", "gold", "darkorange",
                "darksalmon", "lawngreen", "plum"
        };

        //Preparing ObservbleList object
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(int i = 0; i <= 5; i++){
            pieChartData.addAll(new PieChart.Data(ageGroups[i], purchasesByAgeGroup[i]));
        }


        //Creating a Pie chart
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Purchases by age groups");
        pieChart.setClockwise(false);
        pieChart.setLabelLineLength(50);
        pieChart.setLabelsVisible(true);
        pieChart.setLegendVisible(false);

        barChart.setLegendVisible(false);
        //Setting the data to bar chart
        FlowPane root = new FlowPane();
        barChart.getData().addAll(housingPrices, commercialPrices);

        root.getChildren().addAll(barChart, pieChart);

        for(Node n:barChart.lookupAll(".default-color0.chart-bar")){
            n.setStyle("-fx-bar-fill: red;");
        }

        for(Node n:barChart.lookupAll(".default-color1.chart-bar")){
            n.setStyle("-fx-bar-fill: blue;");
        }
        for(int i = 0; i <= 5; i++){
            for(Node n:pieChart.lookupAll(".default-color" + i +".chart-pie")) {
                n.setStyle("-fx-pie-color: "+ pieColours[i] + ";");
            }
        }

        Scene scene = new Scene(root, 1000, 500);
        stage.setTitle("Bar Chart");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

