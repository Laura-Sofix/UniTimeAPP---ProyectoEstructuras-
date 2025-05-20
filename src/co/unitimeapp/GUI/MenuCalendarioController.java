package co.unitimeapp.GUI;

import co.unitimeapp.calendario.Calendario;
import co.unitimeapp.calendario.Evento;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Optional;

public class MenuCalendarioController {
    private Calendario calendario = new Calendario();

    @FXML
    private void agregarEvento() {
        TextInputDialog dialogTitulo = new TextInputDialog();
        dialogTitulo.setTitle("Agregar Evento");
        dialogTitulo.setHeaderText("Título del evento:");
        Optional<String> titulo = dialogTitulo.showAndWait();

        if (titulo.isPresent()) {
            TextInputDialog dialogFecha = new TextInputDialog();
            dialogFecha.setTitle("Agregar Evento");
            dialogFecha.setHeaderText("Fecha del evento (formato YYYY-MM-DD):");
            Optional<String> fecha = dialogFecha.showAndWait();

            if (fecha.isPresent()) {
                TextInputDialog dialogDescripcion = new TextInputDialog();
                dialogDescripcion.setTitle("Agregar Evento");
                dialogDescripcion.setHeaderText("Descripción del evento:");
                Optional<String> descripcion = dialogDescripcion.showAndWait();

                if (descripcion.isPresent()) {
                    TextInputDialog dialogHora = new TextInputDialog();
                    dialogHora.setTitle("Agregar Evento");
                    dialogHora.setHeaderText("Hora del evento (opcional, formato HH:MM):");
                    Optional<String> hora = dialogHora.showAndWait();

                    Evento nuevoEvento = new Evento(
                            titulo.get(),
                            fecha.get(),
                            descripcion.get(),
                            hora.orElse(null)
                    );
                    calendario.agregarEvento(nuevoEvento);
                    mostrarAlerta("Evento agregado exitosamente.");
                }
            }
        }
    }

    @FXML
    private void buscarEventoPorFecha() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Buscar Evento");
        dialog.setHeaderText("Ingrese la fecha (YYYY-MM-DD):");
        Optional<String> fecha = dialog.showAndWait();

        if (fecha.isPresent()) {
            String eventos = calendario.obtenerEventosComoTextoPorFecha(fecha.get());
            mostrarAlerta(eventos);
        }
    }

    @FXML
    private void verTodosLosEventos() {
        String eventos = calendario.obtenerTodosLosEventosComoTexto();
        mostrarAlerta(eventos);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
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
            nuevoStage.setTitle("Menu de Tareas");
            nuevoStage.setScene(new Scene(root));
            nuevoStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
