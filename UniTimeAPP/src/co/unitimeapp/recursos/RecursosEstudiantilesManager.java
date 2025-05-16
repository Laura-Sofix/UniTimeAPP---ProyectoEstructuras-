package co.unitimeapp.recursos;

public class RecursosEstudiantilesManager {
    private static final String[] productividad = {
            "https://trello.com/",
            "https://todoist.com/",
            "https://notion.so/"
    };

    private static final String[] investigacion = {
            "https://scholar.google.com/",
            "https://dialnet.unirioja.es/",
            "https://redalyc.org/"
    };

    private static final String[] programacion = {
            "https://www.w3schools.com/",
            "https://stackoverflow.com/",
            "https://github.com/"
    };

    private static final String[] idiomas = {
            "https://www.duolingo.com/",
            "https://www.memrise.com/",
            "https://es.babbel.com/"
    };

    public static void mostrarRecursos() {
        System.out.println("=== Sitios Web Útiles para Estudiantes ===");

        System.out.println(" Productividad:");
        for (int i = 0; i < productividad.length; i++) {
            System.out.println("   ★ " + productividad[i]);
        }

        System.out.println("\n Investigación:");
        for (int i = 0; i < investigacion.length; i++) {
            System.out.println("   ★ " + investigacion[i]);
        }

        System.out.println("\n Programación:");
        for (int i = 0; i < programacion.length; i++) {
            System.out.println("   ★ " + programacion[i]);
        }

        System.out.println("\n Idiomas:");
        for (int i = 0; i < idiomas.length; i++) {
            System.out.println("   ★ " + idiomas[i]);
        }

        System.out.println();
    }
}
