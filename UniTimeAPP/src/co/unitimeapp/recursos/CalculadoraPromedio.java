package co.unitimeapp.recursos;
import java.util.Scanner;

public class CalculadoraPromedio {
    private NodoNota cabeza;

    static class NodoNota {
        double nota;
        NodoNota siguiente;

        NodoNota(double nota) {
            this.nota = nota;
            this.siguiente = null;
        }
    }

    public void agregarNota(double nota) {
        NodoNota nuevo = new NodoNota(nota);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoNota actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public double calcularPromedio() {
        double suma = 0;
        int cantidad = 0;
        NodoNota actual = cabeza;
        while (actual != null) {
            suma += actual.nota;
            cantidad++;
            actual = actual.siguiente;
        }
        return (cantidad == 0) ? 0 : suma / cantidad;
    }

    public static void usarCalculadora(Scanner scanner) {
        CalculadoraPromedio calculadora = new CalculadoraPromedio();
        boolean continuar = true;

        while (continuar) {
            System.out.print("Ingrese una nota (o -1 para calcular promedio): ");
            double nota = scanner.nextDouble();
            if (nota == -1) {
                continuar = false;
            } else if (nota >= 0 && nota <= 5) {
                calculadora.agregarNota(nota);
            } else {
                System.out.println("Nota invalida. Debe estar entre 0 y 5.");
            }
        }

        double promedio = calculadora.calcularPromedio();
        System.out.printf("Su promedio es: %.2f\n\n", promedio);
    }
}
