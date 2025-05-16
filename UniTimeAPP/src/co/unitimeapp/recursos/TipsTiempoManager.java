package co.unitimeapp.recursos;

public class TipsTiempoManager {
    private static final String [] tips = {
            "Usa la tecnica Pomodoro: 25 minutos de trabajo, 5 de descanso.",
            "Planifica tu dia la noche anterior.",
            "Evita las distracciones digitales mientras estudias.",
            "Prioriza tus tareas con la matriz de Eisenhower.",
            "Comienza con la tarea mas difícil primero.",
            "Establece metas realistas para cada jornada.",
            "Desactiva notificaciones durante tus bloques de estudio.",
    };

    public static void mostrarTips() {
        System.out.println("=== Recomendaciones para una mejor gestion del tiempo ===");
        for (int i = 0; i < tips.length; i++) {
            System.out.println((i + 1) + ". ★ " + tips[i]);
        }
        System.out.println();
    }
}