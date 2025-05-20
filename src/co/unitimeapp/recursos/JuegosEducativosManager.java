package co.unitimeapp.recursos;

public class JuegosEducativosManager {
    private static final String[] juegos = {
            "https://www.arcademics.com/",
            "https://www.educaplay.com/",
            "https://www.mundoprimaria.com/juegos-educativos",
            "https://www.purposegames.com/"
    };

    public static void mostrarJuegosEducativos() {
        System.out.println("=== Juegos Educativos ===");
        for (int i = 0; i < juegos.length; i++) {
            System.out.println((i + 1) + ". ★ " + juegos[i]);
        }
        System.out.println("\nPuedes copiar y pegar el enlace en tu navegador para jugar.\n");
    }

    public static String obtenerJuegos() {
        StringBuilder sb = new StringBuilder("=== Juegos Educativos ===\n\n");
        for (int i = 0; i < juegos.length; i++) {
            sb.append((i + 1)).append(". ★ ").append(juegos[i]).append("\n");
        }
        sb.append("\nPuedes copiar y pegar el enlace en tu navegador para jugar.");
        return sb.toString();
    }

}