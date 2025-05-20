package co.unitimeapp.calendario;

public class Evento {
    private String titulo;
    private String fecha;
    private String descripcion;
    private String hora;

    public Evento(String titulo, String fecha, String descripcion, String hora) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.hora = hora != null && !hora.trim().isEmpty() ? hora : null; // Si la hora no se pasa es null
    }

    public String getFecha() {
        return fecha;
    }

    public void mostrarDetalles() {
        System.out.println("Evento: " + titulo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Fecha: " + fecha + " Hora: " + (hora != null ? hora : "Sin especificar"));
    }

    public String getResumen() {
        return "Fecha: " + fecha + "\nTitulo: " + titulo + "\nDescripción: " + descripcion + "\nHora: " + (hora != null ? hora : "Sin especificar");
    }
}

