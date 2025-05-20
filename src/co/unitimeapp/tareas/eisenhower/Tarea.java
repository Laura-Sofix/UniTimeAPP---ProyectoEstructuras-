package co.unitimeapp.tareas.eisenhower;
public class Tarea {
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private boolean urgente;
    private boolean importante;
    private String estado;  // pendiente o completada

    public Tarea(String titulo, String descripcion, String fecha, boolean urgente, boolean importante, String hora) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.urgente = urgente;
        this.importante = importante;
        this.hora = hora;
        this.estado = "Pendiente";
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getFecha() { return fecha; }
    public boolean isImportante() { return importante;}
    public String getTitulo() { return titulo; }
    public boolean isUrgente() { return urgente; }
    public String getDescripcion() {
        return descripcion;
    }
    public String getHora() {
        return hora;
    }
    public String getEstado() {
        return estado;
    }


    public void mostrarDetalles() {
        System.out.println("Tarea: " + titulo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Estado: " + estado);
    }

    public String getResumen() {
        return "Título: " + titulo + "\nFecha: " + fecha + "\nDescripción: " + descripcion + "\nEstado: " + estado;
    }

    @Override
    public String toString() {
        return titulo + " [" + fecha + " " + hora + "] - " + estado;
    }
}
