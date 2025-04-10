package co.unitimeapp.recursos;
import java.util.ArrayList;
import java.util.List;

public class RecursosEstudiantilesManager {
    private static final List<String> productividad = new ArrayList<>();
    private static final List<String> investigacion = new ArrayList<>();
    private static final List<String> programacion = new ArrayList<>();
    private static final List<String> idiomas = new ArrayList<>();

    static {
        productividad.add("https://trello.com/");
        productividad.add("https://todoist.com/");
        productividad.add("https://notion.so/");

        investigacion.add("https://scholar.google.com/");
        investigacion.add("https://dialnet.unirioja.es/");
        investigacion.add("https://redalyc.org/");

        programacion.add("https://www.w3schools.com/");
        programacion.add("https://stackoverflow.com/");
        programacion.add("https://github.com/");

        idiomas.add("https://www.duolingo.com/");
        idiomas.add("https://www.memrise.com/");
        idiomas.add("https://es.babbel.com/");
    }

    public static void mostrarRecursos() {
        System.out.println("=== Sitios Web Útiles para Estudiantes ===");
        System.out.println(" Productividad:");
        for (String url : productividad) {
            System.out.println("   ★ " + url);
        }
        System.out.println("\n Investigación:");
        for (String url : investigacion) {
            System.out.println("   ★ " + url);
        }
        System.out.println("\n Programación:");
        for (String url : programacion) {
            System.out.println("   ★ " + url);
        }
        System.out.println("\n Idiomas:");
        for (String url : idiomas) {
            System.out.println("   ★ " + url);
        }
        System.out.println();
    }
}
