package co.unitimeapp.presentacion;

import co.unitimeapp.pomodoro.PomodoroManager;
import co.unitimeapp.pomodoro.SesionPomodoro;
import java.util.Scanner;

public class MenuPomodoroManager {
    public static void mostrarMenuPomodoro(Scanner scanner, PomodoroManager pomodoroManager) {
        boolean volver = false;

        while (!volver) {
            System.out.println("=== Menu Pomodoro ===");
            System.out.println("1. Agregar sesion");
            System.out.println("2. Ver sesiones registradas");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la sesion: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Duracion tiempo de estudio (min): ");
                    int estudio = scanner.nextInt();
                    System.out.print("Duracion de descanso (min): ");
                    int descanso = scanner.nextInt();
                    scanner.nextLine();

                    SesionPomodoro sesion = new SesionPomodoro(descripcion, estudio, descanso);
                    pomodoroManager.agregarSesion(sesion);
                    System.out.println("Sesion agregada.");
                    break;

                case 2:
                    pomodoroManager.mostrarSesiones();
                    break;

                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
}
