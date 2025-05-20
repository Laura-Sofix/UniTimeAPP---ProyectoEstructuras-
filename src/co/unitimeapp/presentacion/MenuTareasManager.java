package co.unitimeapp.presentacion;

import co.unitimeapp.recursos.CalculadoraPromedio;
import co.unitimeapp.recursos.JuegosEducativosManager;
import co.unitimeapp.recursos.RecursosEstudiantilesManager;
import co.unitimeapp.pomodoro.PomodoroManager;
import co.unitimeapp.recursos.TipsTiempoManager;
import co.unitimeapp.tareas.eisenhower.*;
import co.unitimeapp.calendario.Calendario;

import java.util.Scanner;

public class MenuTareasManager {

    public static void mostrarMenuTareas(Scanner scanner, GestorTareasEisenhower gestor, Calendario calendario) {
        PomodoroManager pomodoroManager = new PomodoroManager();
        boolean volver = false;

        while (!volver) {
            System.out.println("\n=== Gestor de Tareas ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar todas las tareas");
            System.out.println("3. Completar una tarea por título");
            System.out.println("4. Buscar tareas por fecha");
            System.out.println("5. Ver calendario");
            System.out.println("6. Ver tareas completadas");
            System.out.println("7. deshacer ultima tarea completada.");
            System.out.println("8. Gestor sesiones pomodoro.");
            System.out.println("9. Ver Recursos.");
            System.out.println("0. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Titulo de la tarea: ");
                    String tituloTarea = scanner.nextLine();
                    System.out.print("Descripcion de la tarea: ");
                    String descripcionTarea = scanner.nextLine();
                    System.out.print("Fecha de la tarea (dd/mm/aaaa): ");
                    String fechaTarea = scanner.nextLine();
                    System.out.print("¿Es urgente? (true/false): ");
                    boolean urgenteTarea = scanner.nextBoolean();
                    System.out.print("¿Es importante? (true/false): ");
                    boolean importanteTarea = scanner.nextBoolean();
                    scanner.nextLine();

                    // Preguntar si quiere poner hora
                    System.out.print("¿Desea agregar una hora a la tarea? (true/false): ");
                    String respuestaHora = scanner.nextLine();
                    String horaTarea = null;

                    if (respuestaHora.equalsIgnoreCase("true")) {
                        System.out.print("Hora de la tarea (hh:mm): ");
                        horaTarea = scanner.nextLine();
                    }

                    Tarea nuevaTarea = new Tarea(tituloTarea, descripcionTarea, fechaTarea, urgenteTarea, importanteTarea, horaTarea);
                    gestor.agregarTarea(nuevaTarea);
                    System.out.println("Tarea agregada.");
                    break;

                case 2:
                    gestor.mostrarTodasLasTareas();
                    break;

                case 3:
                    System.out.print("Ingrese el titulo de la tarea a completar: ");
                    String titulo = scanner.nextLine();
                    if (gestor.completarTareaPorTitulo(titulo)) {
                        System.out.println("Tarea completada y movida al historial.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la fecha (dd/mm/aaaa): ");
                    String fechaBuscar = scanner.nextLine();
                    gestor.buscarTareasPorFecha(fechaBuscar);
                    break;

                case 5:
                    MenuCalendarioManager.mostrarMenuCalendario(scanner, calendario, gestor);
                    break;

                case 6:
                    gestor.mostrarTareasCompletadas();
                    break;
                case 7:
                    gestor.deshacerUltimaTareaCompletada();
                    break;
                case 8:
                    MenuPomodoroManager.mostrarMenuPomodoro(scanner, pomodoroManager);
                    break;
                case 9:
                    MenuRecursosMananager.mostrarMenuRecursos(scanner);
                    break;
                case 0:
                    volver = true;
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
}