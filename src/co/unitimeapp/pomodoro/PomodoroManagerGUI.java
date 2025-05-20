package co.unitimeapp.pomodoro;

import java.util.LinkedList;
import java.util.Queue;

public class PomodoroManagerGUI {

    private Queue<SesionPomodoro> colaSesiones;
    private int contador;

    public PomodoroManagerGUI() {
        this.colaSesiones = new LinkedList<>();
        this.contador = 1;
    }

    public String agregarSesion(String descripcion) {
        SesionPomodoro nuevaSesion = new SesionPomodoro(contador, descripcion);
        colaSesiones.add(nuevaSesion);
        return " Sesión agregada con turno #" + (contador++);
    }

    public String iniciarSesion() {
        if (!colaSesiones.isEmpty()) {
            SesionPomodoro sesion = colaSesiones.poll();
            return "▶ Iniciando sesión Pomodoro:\n" + sesion.toTexto();
        } else {
            return "⚠ No hay sesiones pendientes.";
        }
    }

    public String obtenerSesionesPendientes() {
        if (colaSesiones.isEmpty()) {
            return "⚠ No hay sesiones pendientes.";
        }

        StringBuilder sb = new StringBuilder("📋 Sesiones Pomodoro Pendientes:\n");
        for (SesionPomodoro sesion : colaSesiones) {
            sb.append(sesion.toTexto()).append("\n-------------------------\n");
        }
        return sb.toString();
    }
}

