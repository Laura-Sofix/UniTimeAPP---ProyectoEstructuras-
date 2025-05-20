package co.unitimeapp.calendario;

public class Calendario {
    private NodoEvento cabeza;

    public class NodoEvento {
        public Evento evento;
        public NodoEvento siguiente;

        public NodoEvento(Evento evento) {
            this.evento = evento;
            this.siguiente = null;
        }
    }

    public void agregarEvento(Evento nuevoEvento) {
        NodoEvento nuevoNodo = new NodoEvento(nuevoEvento);
        if (cabeza == null || nuevoEvento.getFecha().compareTo(cabeza.evento.getFecha()) < 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            NodoEvento actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.evento.getFecha().compareTo(nuevoEvento.getFecha()) < 0) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }

    public void mostrarEventos() {
        if (cabeza == null) {
            System.out.println("No hay eventos programados.");
            return;
        }
        NodoEvento actual = cabeza;
        while (actual != null) {
            actual.evento.mostrarDetalles();
            System.out.println("---");
            actual = actual.siguiente;
        }
    }

    public void mostrarEventosPorFecha(String fecha) {
        NodoEvento actual = cabeza;
        boolean encontrado = false;
        while (actual != null) {
            if (actual.evento.getFecha().equals(fecha)) {
                actual.evento.mostrarDetalles();
                encontrado = true;
            }
            actual = actual.siguiente;
        }
        if (!encontrado) {
            System.out.println("No hay eventos para esa fecha.");
        }
    }

    //GUI
    public String obtenerTodosLosEventosComoTexto() {
        if (cabeza == null) {
            return "No hay eventos programados.";
        }
        StringBuilder sb = new StringBuilder();
        NodoEvento actual = cabeza;
        while (actual != null) {
            sb.append(actual.evento.getResumen()).append("\n---\n");
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    public String obtenerEventosComoTextoPorFecha(String fecha) {
        NodoEvento actual = cabeza;
        StringBuilder sb = new StringBuilder();
        boolean encontrado = false;
        while (actual != null) {
            if (actual.evento.getFecha().equals(fecha)) {
                sb.append(actual.evento.getResumen()).append("\n---\n");
                encontrado = true;
            }
            actual = actual.siguiente;
        }
        return encontrado ? sb.toString() : "No hay eventos para esa fecha.";
    }
}
