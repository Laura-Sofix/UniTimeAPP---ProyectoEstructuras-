package co.unitimeapp.pomodoro;

public class SesionPomodoro {
    private String descripcion;
    private int duracionEstudio; // minutos
    private int duracionDescanso;

    public SesionPomodoro(String descripcion, int duracionEstudio, int duracionDescanso) {
        this.descripcion = descripcion;
        this.duracionEstudio = duracionEstudio;
        this.duracionDescanso = duracionDescanso;
    }

    public void mostrarSesion() {
        System.out.println("Estudio: " + duracionEstudio + " minutos");
        System.out.println("Descanso: " + duracionDescanso + " minutos");
        System.out.println("Descripcion: " + descripcion);
        System.out.println("----------------------");
    }
}
