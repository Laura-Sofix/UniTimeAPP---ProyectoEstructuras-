package co.unitimeapp.GUI;

import co.unitimeapp.pomodoro.PomodoroManagerGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Optional;

public class MenuPomodoroController {

    private PomodoroManagerGUI gestorPomodoro = new PomodoroManagerGUI();

    @FXML
    public void agregarSesionPomodoro(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nueva sesión Pomodoro");
        dialog.setHeaderText("Agregar una nueva sesión Pomodoro");
        dialog.setContentText("Descripción de la sesión:");

        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()) {
            String descripcion = resultado.get();
            String mensaje = gestorPomodoro.agregarSesion(descripcion);
            mostrarMensaje(mensaje);
        }
    }

    @FXML
    public void iniciarSesionPomodoro(ActionEvent event) {
        String mensaje = gestorPomodoro.iniciarSesion();
        mostrarMensaje(mensaje);
    }

    @FXML
    public void verSesionesPendientes(ActionEvent event) {
        String mensaje = gestorPomodoro.obtenerSesionesPendientes();
        mostrarMensaje(mensaje);
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

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
