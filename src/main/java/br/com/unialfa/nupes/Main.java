package br.com.unialfa.nupes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// AnchorPane root =
			// FXMLLoader.load(getClass().getResource("./view/FXMLLogin.fxml"));
			AnchorPane root = FXMLLoader.load(getClass().getResource("./view/FXMLCadastroBanca.fxml"));
			Scene scene = new Scene(root, 774, 521);
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Connection Open!");
	}

	public static void main(String[] args) {
		launch(args);;
	}
}
