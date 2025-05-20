package co.unitimeapp.GUI;

import co.unitimeapp.usuario.ArbolUsuarios;
import co.unitimeapp.recursos.MotivacionManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {

    @FXML private Button btnRegistrar;
    @FXML private Button btnIniciarSesion;
    @FXML private Button btnSalir;

    private ArbolUsuarios arbolUsuarios = new ArbolUsuarios();
    private MotivacionManager motivacionManager = new MotivacionManager();

    @FXML
    private void initialize() {
        // Botón Registrar
        btnRegistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage ventanaRegistro = new Stage();
                ventanaRegistro.setTitle("Registro");

                TextField campoCorreo = new TextField();
                campoCorreo.setPromptText("Correo");

                PasswordField campoClave = new PasswordField();
                campoClave.setPromptText("Contraseña");

                Button botonGuardar = new Button("Registrar");
                Label mensaje = new Label();

                botonGuardar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        String correo = campoCorreo.getText();
                        String clave = campoClave.getText();
                        String resultado = arbolUsuarios.insertarUsuario(correo, clave);

                        if (resultado.equals("formato invalido")) {
                            mensaje.setText("Correo debe terminar en @poligran.edu.co");
                        } else if (resultado.equals("existe")) {
                            mensaje.setText("El usuario ya existe.");
                        } else if (resultado.equals("exito")) {
                            mensaje.setText("Usuario registrado correctamente.");
                        }
                    }
                });
                VBox layout = new VBox(10, new Label("Registro de Usuario"), campoCorreo, campoClave, botonGuardar, mensaje);
                ventanaRegistro.setScene(new Scene(layout, 300, 170));
                ventanaRegistro.show();
            }
        });

        // iniciar sesion
        btnIniciarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage ventanaLogin = new Stage();
                ventanaLogin.setTitle("Iniciar Sesión");
                TextField campoCorreo = new TextField();
                campoCorreo.setPromptText("Correo");
                PasswordField campoClave = new PasswordField();
                campoClave.setPromptText("Contraseña");
                Button botonLogin = new Button("Entrar");
                Label mensaje = new Label();

                botonLogin.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        String correo = campoCorreo.getText();
                        String clave = campoClave.getText();

                        if (arbolUsuarios.verificarCredenciales(correo, clave)) {
                            mensaje.setText("Inicio de sesion exitoso!");

                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/unitimeapp/GUI/MenuTareas.fxml"));
                                Parent root = loader.load();

                                MenuTareasController controlador = loader.getController();
                                String frase = motivacionManager.obtenerFraseAleatoria();
                                controlador.mostrarFraseMotivacional(frase);

                                Stage ventanaTareas = new Stage();
                                ventanaTareas.setTitle("Menú de Tareas");
                                ventanaTareas.setScene(new Scene(root));
                                ventanaTareas.show();

                                Stage loginStage = (Stage) botonLogin.getScene().getWindow();
                                loginStage.close();

                                Stage menuPrincipalStage = (Stage) btnIniciarSesion.getScene().getWindow();
                                menuPrincipalStage.close();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                                mensaje.setText("No se pudo abrir el menu de tareas.");
                            }
                        } else {
                            mensaje.setText("Correo o contraseña incorrectos.");
                        }
                    }
                });

                VBox layout = new VBox(10, new Label("Inicio de Sesion"), campoCorreo, campoClave, botonLogin, mensaje);
                ventanaLogin.setScene(new Scene(layout, 300, 170));
                ventanaLogin.show();
            }
        });

        // salir
        btnSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage ventana = (Stage) btnSalir.getScene().getWindow();
                ventana.close();
            }
        });
    }
}
