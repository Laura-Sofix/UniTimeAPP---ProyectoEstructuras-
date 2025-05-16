package co.unitimeapp.recursos;
import java.util.ArrayList;
import java.util.Random;

public class MotivacionManager {
    private ArrayList<String> frasesMotivacionales;

    public MotivacionManager() {
        frasesMotivacionales = new ArrayList<>();
        frasesMotivacionales.add("¡Cada dia es una nueva oportunidad para aprender y crecer!");
        frasesMotivacionales.add("No te rindas, el comienzo siempre es lo mas dificil.");
        frasesMotivacionales.add("El exito no es la clave de la felicidad. La felicidad es la clave del exito.");
        frasesMotivacionales.add("No importa cuantas veces caigas, lo importante es levantarse siempre.");
        frasesMotivacionales.add("Haz hoy lo que otros no quieren, haz mañana lo que otros no pueden.");
        frasesMotivacionales.add("El unico modo de hacer un gran trabajo es amar lo que haces.");
    }

    public String obtenerFraseAleatoria() {
        Random random = new Random();
        int index = random.nextInt(frasesMotivacionales.size());
        return frasesMotivacionales.get(index);
    }
}
