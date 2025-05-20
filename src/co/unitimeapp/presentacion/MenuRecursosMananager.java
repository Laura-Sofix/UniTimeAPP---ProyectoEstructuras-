package co.unitimeapp.presentacion;

import co.unitimeapp.recursos.CalculadoraPromedio;
import co.unitimeapp.recursos.JuegosEducativosManager;
import co.unitimeapp.recursos.RecursosEstudiantilesManager;
import co.unitimeapp.pomodoro.PomodoroManager;
import co.unitimeapp.recursos.TipsTiempoManager;
import co.unitimeapp.tareas.eisenhower.*;
import co.unitimeapp.calendario.Calendario;

import java.util.Scanner;

public class MenuRecursosMananager {

    public static void mostrarMenuRecursos(Scanner scanner) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n=== Recursos ===");
            System.out.println("1. Recomendaciones de gestion del tiempo");
            System.out.println("2. Ver sitios web utiles para estudiantes");
            System.out.println("3. Acceder a juegos educativos");
            System.out.println("4. Calculadora de promedio");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    TipsTiempoManager.mostrarTips();
                    break;
                case 2:
                    RecursosEstudiantilesManager.mostrarRecursos();
                    break;
                case 3:
                    JuegosEducativosManager.mostrarJuegosEducativos();
                    break;
                case 4:
                    CalculadoraPromedio.usarCalculadora(scanner);
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