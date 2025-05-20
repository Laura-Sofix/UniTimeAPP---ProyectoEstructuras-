package co.unitimeapp.presentacion;

import co.unitimeapp.pomodoro.PomodoroManager;
import java.util.Scanner;

public class MenuPomodoroManager {
    public static void mostrarMenuPomodoro(Scanner scanner, PomodoroManager pomodoroManager) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n=== Menu Pomodoro ===");
            System.out.println("1. Agregar sesion");
            System.out.println("2. Iniciar proxima sesion");
            System.out.println("3. Ver sesiones pendientes");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la sesion: ");
                    String descripcion = scanner.nextLine();

                    pomodoroManager.agregarSesion(descripcion);
                    break;
                case 2:
                    pomodoroManager.iniciarSesion();
                    break;
                case 3:
                    pomodoroManager.mostrarSesionesPendientes();
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}