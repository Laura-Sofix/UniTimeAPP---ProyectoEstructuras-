package co.unitimeapp.usuario;
import co.unitimeapp.tareas.eisenhower.GestorTareasEisenhower;
import co.unitimeapp.pomodoro.PomodoroManager;
import co.unitimeapp.calendario.Calendario;

// Lista enlazada para guardar lo que haga el usuario
class NodoUsuarioTareas {
    String correo;
    GestorTareasEisenhower gestorTareas;
    PomodoroManager gestorPomodoro;
    Calendario calendario;
    NodoUsuarioTareas siguiente;

    public NodoUsuarioTareas(String correo) {
        this.correo = correo;
        this.gestorTareas = new GestorTareasEisenhower();
        this.gestorPomodoro = new PomodoroManager();
        this.calendario = new Calendario();
        this.siguiente = null;
    }
}

public class ListaUsuariosTareas {
    private NodoUsuarioTareas cabeza;

    public void agregarUsuario(String correo) {
        NodoUsuarioTareas nuevo = new NodoUsuarioTareas(correo);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public GestorTareasEisenhower buscarGestorPorCorreo(String correo) {
        NodoUsuarioTareas actual = cabeza;
        while (actual != null) {
            if (actual.correo.equals(correo)) {
                return actual.gestorTareas;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}

