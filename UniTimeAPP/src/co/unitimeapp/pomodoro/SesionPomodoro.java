package co.unitimeapp.pomodoro;

public class SesionPomodoro {
    private int turno;
    private String descripcion;

    public SesionPomodoro(int turno, String descripcion) {
        this.turno = turno;
        this.descripcion = descripcion;
    }

    public int getTurno() {
        return turno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void mostrarSesion() {
        System.out.println("Turno: " + turno);
        System.out.println("Descripción: " + descripcion);
        System.out.println("-------------------------------");
    }
}
