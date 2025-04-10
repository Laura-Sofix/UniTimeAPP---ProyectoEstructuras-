package co.unitimeapp.recursos;
import java.util.ArrayList;
import java.util.List;

public class TipsTiempoManager {
    private static final List<String> tips = new ArrayList<>();

    static {
        tips.add(" ★ Usa la tecnica Pomodoro: 25 minutos de trabajo, 5 de descanso.");
        tips.add(" ★ Planifica tu dia la noche anterior.");
        tips.add(" ★ Evita las distracciones digitales mientras estudias.");
        tips.add(" ★ Prioriza tus tareas con la matriz de Eisenhower.");
        tips.add(" ★ Comienza con la tarea mas difícil primero.");
        tips.add(" ★ Establece metas realistas para cada jornada.");
        tips.add(" ★ Desactiva notificaciones durante tus bloques de estudio.");
    }

    public static void mostrarTips() {
        System.out.println("=== Recomendaciones para una mejor gestion del tiempo ===");
        for (String tip : tips) {
            System.out.println(tip);
        }
        System.out.println();
    }
}
