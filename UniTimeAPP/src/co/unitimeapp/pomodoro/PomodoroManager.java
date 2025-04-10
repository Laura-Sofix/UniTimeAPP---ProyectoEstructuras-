package co.unitimeapp.pomodoro;
import java.util.LinkedList;

public class PomodoroManager {
    private LinkedList<SesionPomodoro> sesiones;

    public PomodoroManager() {
        sesiones = new LinkedList<>();
    }

    public void agregarSesion(SesionPomodoro sesion) {
        sesiones.add(sesion); // guardar 'historial'
    }

    public void mostrarSesiones() {
        if (sesiones.isEmpty()) {
            System.out.println("No hay sesiones registradas.");
        } else {
            System.out.println("=== Sesiones Pomodoro Registradas ===");
            for (SesionPomodoro sesion : sesiones) {
                sesion.mostrarSesion();
            }
        }
    }
}
