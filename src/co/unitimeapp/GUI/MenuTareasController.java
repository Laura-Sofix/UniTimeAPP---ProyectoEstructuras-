package co.unitimeapp.GUI;

import co.unitimeapp.tareas.eisenhower.GestorTareasEisenhower;
import co.unitimeapp.tareas.eisenhower.Tarea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MenuTareasController {
    private GestorTareasEisenhower gestor = new GestorTareasEisenhower();

    @FXML
    private Label lblFraseMotivacional;

    public void mostrarFraseMotivacional(String frase) {
        lblFraseMotivacional.setText("✧ Frase del día: " + frase);
    }

    @FXML
    private void agregarTarea() {
        TextInputDialog dialogTitulo = new TextInputDialog();
        dialogTitulo.setTitle("Agregar Tarea");
        dialogTitulo.setHeaderText("Título:");
        Optional<String> titulo = dialogTitulo.showAndWait();

        if (titulo.isPresent()) {
            TextInputDialog dialogFecha = new TextInputDialog();
            dialogFecha.setTitle("Agregar Tarea");
            dialogFecha.setHeaderText("Fecha (YYYY-MM-DD):");
            Optional<String> fecha = dialogFecha.showAndWait();

            if (fecha.isPresent()) {
                TextInputDialog dialogDescripcion = new TextInputDialog();
                dialogDescripcion.setTitle("Agregar Tarea");
                dialogDescripcion.setHeaderText("Descripción:");
                Optional<String> descripcion = dialogDescripcion.showAndWait();

                if (descripcion.isPresent()) {
                    boolean urgente = confirmar("¿Es urgente?");
                    boolean importante = confirmar("¿Es importante?");

                    Tarea nueva = new Tarea(titulo.get(), descripcion.get(), fecha.get(), urgente, importante, "00:00");
                    gestor.agregarTarea(nueva);
                    mostrarMensaje("Tarea agregada correctamente.");
                }
            }
        }
    }

    @FXML
    private void completarTarea() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Completar Tarea");
        dialog.setHeaderText("Ingrese el título de la tarea:");
        Optional<String> titulo = dialog.showAndWait();

        if (titulo.isPresent()) {
            boolean completada = gestor.completarTareaPorTitulo(titulo.get());
            if (completada) {
                mostrarMensaje("Tarea completada con éxito.");
            } else {
                mostrarMensaje("No se encontró una tarea con ese título.");
            }
        }
    }

    @FXML
    private void verTareasCompletadas() {
        List<Tarea> completadas = gestor.getTareasCompletadasGUI();

        if (completadas.isEmpty()) {
            mostrarMensaje("No hay tareas completadas.");
        } else {
            String texto = "Tareas completadas:\n\n";
            for (Tarea t : completadas) {
                texto += "✔ " + t.getTitulo() + " - " + t.getFecha() + "\n" + t.getDescripcion() + "\n\n";
            }
            mostrarMensaje(texto);
        }
    }

    @FXML
    private void buscarTareasPorFecha() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Buscar Tareas");
        dialog.setHeaderText("Ingrese la fecha (YYYY-MM-DD):");
        Optional<String> fecha = dialog.showAndWait();

        if (fecha.isPresent()) {
            List<Tarea> encontradas = gestor.buscarTareasPorFechaGUI(fecha.get());
            if (encontradas.isEmpty()) {
                mostrarMensaje("No se encontraron tareas con esa fecha.");
            } else {
                StringBuilder sb = new StringBuilder("Tareas encontradas:\n\n");
                for (Tarea t : encontradas) {
                    sb.append(t.getResumen()).append("\n\n");
                }
                mostrarMensaje(sb.toString());
            }
        }
    }

    @FXML
    private void deshacerUltimaTarea() {
        boolean exito = gestor.deshacerUltimaTareaCompletada();
        if (exito) {
            mostrarMensaje("Se deshizo la última tarea completada.");
        } else {
            mostrarMensaje("No hay tareas para deshacer.");
        }
    }

    @FXML
    private void mostrarMatriz() {
        String[][] nombresCuadrantes = {
                {"Urgente e Importante", "Urgente y No Importante"},
                {"No Urgente e Importante", "No Urgente y No Importante"}
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                List<Tarea> lista = gestor.getMatriz()[i][j];
                sb.append("=== ").append(nombresCuadrantes[i][j]).append(" ===\n");
                if (lista.isEmpty()) {
                    sb.append("(Sin tareas)\n\n");
                } else {
                    for (Tarea t : lista) {
                        sb.append("• ").append(t.getResumen()).append("\n\n");
                    }
                }
            }
        }
        mostrarMensaje(sb.toString());
    }


    @FXML
    private void recursos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/unitimeapp/GUI/MenuRecursos.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Recursos Estudiantiles");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void pomodoro(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/unitimeapp/GUI/MenuPomodoro.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Menu Pomodoro");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void calendario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/unitimeapp/GUI/MenuCalendario.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Menu Calendario");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void cerrarSesion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Obtener la ventana actual y reemplazarla
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("UniTimeApp - Menu Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean confirmar(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar");
        alert.setHeaderText(mensaje);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
