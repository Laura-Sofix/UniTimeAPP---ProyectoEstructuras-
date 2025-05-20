package co.unitimeapp.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class MenuRecursosController {

    @FXML
    private void mostrarTips() {
        String contenido = co.unitimeapp.recursos.TipsTiempoManager.obtenerTips();
        Ventana.mostrar("Tips de Gestión del Tiempo", contenido);
    }

    @FXML
    private void mostrarRecursosEnLinea() {
        String contenido = co.unitimeapp.recursos.RecursosEstudiantilesManager.obtenerRecursos();
        Ventana.mostrar("Recursos en Línea", contenido);
    }

    @FXML
    private void mostrarJeugosEducativos() {
        String contenido = co.unitimeapp.recursos.JuegosEducativosManager.obtenerJuegos();
        Ventana.mostrar("Juegos Educativos", contenido);
    }

    @FXML
    private void CalculadoraPromedio() {
        String resultado = co.unitimeapp.recursos.CalculadoraPromedio.calcularDesdeGUI();
        Ventana.mostrar("Calculadora de Promedio", resultado);
    }

    @FXML
    private Button btnVolver;

    @FXML
    private void volverAlMenuPrincipal() {
        Stage stageActual = (Stage) btnVolver.getScene().getWindow();
        stageActual.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/unitimeapp/GUI/MenuTareas.fxml"));
            Parent root = loader.load();

            Stage nuevoStage = new Stage();
            nuevoStage.setTitle("Menú de Tareas");
            nuevoStage.setScene(new Scene(root));
            nuevoStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Ventana {
    public static void mostrar(String titulo, String contenido) {
        Stage ventana = new Stage();
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle(titulo);
        ventana.setMinWidth(400);
        ventana.setMinHeight(300);

        TextArea textArea = new TextArea(contenido);
        textArea.setWrapText(true);
        textArea.setEditable(false);

        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20;");
        layout.getChildren().add(textArea);

        Scene scene = new Scene(layout);
        ventana.setScene(scene);
        ventana.showAndWait();
    }
}
