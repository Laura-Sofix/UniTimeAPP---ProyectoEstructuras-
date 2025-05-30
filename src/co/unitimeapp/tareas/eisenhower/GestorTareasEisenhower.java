package co.unitimeapp.tareas.eisenhower;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GestorTareasEisenhower {
    private ArrayList<Tarea>[][] matriz;
    private Stack<Tarea> tareasCompletadas;

    public GestorTareasEisenhower() {
        matriz = new ArrayList[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                matriz[i][j] = new ArrayList<>();
        tareasCompletadas = new Stack<>();
    }

    public void agregarTarea(Tarea tarea) {
        int i = tarea.isUrgente() ? 0 : 1;
        int j = tarea.isImportante() ? 0 : 1;
        matriz[i][j].add(tarea);
    }

    public void mostrarTodasLasTareas() {
        String[][] cuadrantes = {
                {"Urgente e Importante", "Urgente y No Importante"},
                {"No Urgente e Importante", "No Urgente y No Importante"}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("=== " + cuadrantes[i][j] + " ===");
                for (Tarea tarea : matriz[i][j]) {
                    tarea.mostrarDetalles();
                    System.out.println("---");
                }
                if (matriz[i][j].isEmpty()) {
                    System.out.println("(Sin tareas)");
                }
                System.out.println();
            }
        }
    }

    public void buscarTareasPorFecha(String fecha) {
        boolean encontrada = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (Tarea tarea : matriz[i][j]) {
                    if (tarea.getFecha().equals(fecha)) {
                        tarea.mostrarDetalles();
                        System.out.println("---");
                        encontrada = true;
                    }
                }
            }
        }
        if (!encontrada) {
            System.out.println("No se encontraron tareas con esa fecha.");
        }
    }

    public void mostrarTareasCalendario() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (Tarea tarea : matriz[i][j]) {
                    tarea.mostrarDetalles();
                    System.out.println("---");
                }
            }
        }
    }

    public boolean completarTareaPorTitulo(String titulo) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < matriz[i][j].size(); k++) {
                    Tarea tarea = matriz[i][j].get(k);
                    if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                        tarea.setEstado("Completada");

                        tareasCompletadas.push(tarea); // pila

                        matriz[i][j].remove(k);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void mostrarTareasCompletadas() {
        if (tareasCompletadas.isEmpty()) {
            System.out.println("No hay tareas completadas.");
        } else {
            System.out.println("=== Tareas Completadas ===");
            for (Tarea tarea : tareasCompletadas) {
                tarea.mostrarDetalles();
                System.out.println("---");
            }
        }
    }

    public boolean deshacerUltimaTareaCompletada() {
        if (!tareasCompletadas.isEmpty()) {
            Tarea tarea = tareasCompletadas.pop();
            tarea.setEstado("Pendiente");

            int i = tarea.isUrgente() ? 0 : 1;
            int j = tarea.isImportante() ? 0 : 1;
            matriz[i][j].add(tarea);

            return true;
        } else {
            return false;
        }
    }

    //GUI
    public ArrayList<Tarea>[][] getMatriz() {
        return matriz;
    }
    public List<Tarea> getTareasCompletadasGUI() {
        return new ArrayList<>(tareasCompletadas);
    }

    public ArrayList<Tarea> buscarTareasPorFechaGUI(String fecha) {
        ArrayList<Tarea> encontradas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (Tarea tarea : matriz[i][j]) {
                    if (tarea.getFecha().equals(fecha)) {
                        encontradas.add(tarea);
                    }
                }
            }
        }
        return encontradas;
    }
}
