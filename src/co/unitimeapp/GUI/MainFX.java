package co.unitimeapp.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/co/unitimeapp/GUI/MenuPrincipal.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setTitle("UniTimeApp");

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Error al cargar la ventana principal:");
            e.printStackTrace();
        }
    }
}
