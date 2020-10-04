package Converter;
/*
 * Unit Converter
 * Temperature Converter
 * Distance Converter
 * */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Converter extends Application {

	private final int WIDTH = 600, HEIGHT = 500;
	private TemperatureConverter temperature;
	private DistanceConverter metric;
	
	public void start(Stage stage) {
		temperature = new TemperatureConverter();
		metric = new DistanceConverter();
		
		VBox root = new VBox(temperature, metric);
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
