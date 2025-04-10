package co.unitimeapp.recursos;

import java.util.ArrayList;
import java.util.List;

public class JuegosEducativosManager {
    private static final List<String> juegos = new ArrayList<>();

    static {
        juegos.add("https://www.arcademics.com/");
        juegos.add("https://www.educaplay.com/");
        juegos.add("https://www.mundoprimaria.com/juegos-educativos");
        juegos.add("https://www.purposegames.com/");
    }

    public static void mostrarJuegosEducativos() {
        System.out.println("=== Juegos Educativos ===");
        int i = 1;
        for (String url : juegos) {
            System.out.println(i + ". ★ " + url);
            i++;
        }
        System.out.println("\nPuedes copiar y pegar el enlace en tu navegador para jugar.\n");
    }
}
