package co.unitimeapp.presentacion;

import co.unitimeapp.calendario.Calendario;
import co.unitimeapp.calendario.Evento;
import co.unitimeapp.tareas.eisenhower.GestorTareasEisenhower;
import java.util.Scanner;

public class MenuCalendarioManager {

    public static void mostrarMenuCalendario(Scanner scanner, Calendario calendario, GestorTareasEisenhower gestorTareas) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n=== Calendario ===");
            System.out.println("1. Ver todos los eventos y tareas");
            System.out.println("2. Buscar eventos por fecha");
            System.out.println("3. Agregar evento");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("=== Eventos ===");
                    calendario.mostrarEventos();

                    System.out.println("=== Tareas ===");
                    gestorTareas.mostrarTareasCalendario();
                    break;
                case 2:
                    System.out.print("Ingrese la fecha (dd/mm/aaaa): ");
                    String fechaBuscar = scanner.nextLine();
                    calendario.mostrarEventosPorFecha(fechaBuscar);
                    gestorTareas.buscarTareasPorFecha(fechaBuscar);
                    break;
                case 3:
                    System.out.print("Título del evento: ");
                    String tituloEvento = scanner.nextLine();
                    System.out.print("Descripcion del evento: ");
                    String descripcionEvento = scanner.nextLine();
                    System.out.print("Fecha del evento (dd/mm/aaaa): ");
                    String fechaEvento = scanner.nextLine();
                    System.out.print("Hora del evento (formato hh:mm): ");
                    String horaEvento = scanner.nextLine();

                    if (horaEvento.trim().isEmpty()) {
                        System.out.println("La hora es obligatoria para registrar un evento.");
                    } else {
                        calendario.agregarEvento(new Evento(tituloEvento, fechaEvento, descripcionEvento, horaEvento));
                        System.out.println("Evento añadido al calendario.");
                    }
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
