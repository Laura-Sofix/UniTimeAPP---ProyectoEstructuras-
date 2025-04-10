package co.unitimeapp.presentacion;

import co.unitimeapp.calendario.Calendario;
import co.unitimeapp.usuario.ArbolUsuarios;
import co.unitimeapp.usuario.ListaUsuariosTareas;
import co.unitimeapp.recursos.MotivacionManager;
import co.unitimeapp.tareas.eisenhower.GestorTareasEisenhower;

import java.util.Scanner;

public class MenuPrincipalManager {

    public static void mostrarMenuPrincipal(Scanner scanner, ArbolUsuarios arbolUsuarios, ListaUsuariosTareas listaUsuariosTareas, Calendario calendario) {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== UniTimeApp ===");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    boolean registrado = false;
                    while (!registrado) {
                        System.out.print("Ingrese su correo (El dominio debe ser @poligran.edu.co): ");
                        String correo = scanner.nextLine();
                        System.out.print("Ingrese su contraseña: ");
                        String contraseña = scanner.nextLine();

                        String resultado = arbolUsuarios.insertarUsuario(correo, contraseña);

                        switch (resultado) {
                            case "formato invalido":
                                System.out.println("El correo debe terminar en @poligran.edu.co");
                                break;
                            case "existe":
                                System.out.println("El usuario ya existe.");
                                break;
                            case "exito":
                                System.out.println("Usuario registrado con exito.");
                                listaUsuariosTareas.agregarUsuario(correo);
                                registrado = true;
                                break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Correo: ");
                    String correoLogin = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contraseñaLogin = scanner.nextLine();

                    if (arbolUsuarios.verificarCredenciales(correoLogin, contraseñaLogin)) {
                        System.out.println("Inicio de sesion exitoso.");

                        // Mostrar frase motivacional
                        MotivacionManager motivacionManager = new MotivacionManager();
                        String frase = motivacionManager.obtenerFraseAleatoria();
                        System.out.println("\n ✧˖° Frase motivacional del dia: " + frase + "\n");

                        GestorTareasEisenhower gestor = listaUsuariosTareas.buscarGestorPorCorreo(correoLogin);
                        if (gestor != null) {
                            MenuTareasManager.mostrarMenuTareas(scanner, gestor, calendario);
                        } else {
                            System.out.println("Error: el usuario no tiene gestor de tareas.");
                        }
                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }
                    break;

                case 3:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
}
