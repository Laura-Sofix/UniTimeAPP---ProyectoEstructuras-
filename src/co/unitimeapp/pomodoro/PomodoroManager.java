package co.unitimeapp.pomodoro;

import java.util.LinkedList;
import java.util.Queue;

public class PomodoroManager {
    private Queue<SesionPomodoro> colaSesiones;
    private int contador;

    public PomodoroManager() {
        this.colaSesiones = new LinkedList<>();
        this.contador = 1;
    }

    public void agregarSesion(String descripcion) {
        SesionPomodoro nuevaSesion = new SesionPomodoro(contador, descripcion);
        colaSesiones.add(nuevaSesion);
        System.out.println("Sesion agregada con turno: " + contador);
        contador++;
    }

    public void iniciarSesion() {
        if (!colaSesiones.isEmpty()) {
            SesionPomodoro sesion = colaSesiones.poll();
            System.out.println("▶ Iniciando sesion con turno: " + sesion.getTurno());
            System.out.println("Descripcion: " + sesion.getDescripcion());
        } else {
            System.out.println("No hay sesiones pendientes.");
        }
    }

    public void mostrarSesionesPendientes() {
        if (colaSesiones.isEmpty()) {
            System.out.println("No hay sesiones pendientes.");
        } else {
            System.out.println("=== Sesiones Pomodoro Pendientes ===");
            for (SesionPomodoro sesion : colaSesiones) {
                sesion.mostrarSesion();
            }
        }
    }

}