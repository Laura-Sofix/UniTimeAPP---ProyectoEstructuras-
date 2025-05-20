package co.unitimeapp.recursos;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
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
                System.out.println("Nota inválida. Debe estar entre 0 y 5.");
            }
        }

        double promedio = calculadora.calcularPromedio();
        System.out.printf("Su promedio es: %.2f\n\n", promedio);
    }

    public static String calcularDesdeGUI() {
        CalculadoraPromedio calculadora = new CalculadoraPromedio();
        boolean continuar = true;

        while (continuar) {
            TextInputDialog dialogo = new TextInputDialog();
            dialogo.setTitle("Ingresar Nota");
            dialogo.setHeaderText("Calculadora de Promedio");
            dialogo.setContentText("Ingrese una nota entre 0 y 5 (o -1 para finalizar):");

            Optional<String> resultado = dialogo.showAndWait();
            if (resultado.isEmpty()) {
                // Usuario cerró la ventana
                continuar = false;
            } else {
                try {
                    double nota = Double.parseDouble(resultado.get());
                    if (nota == -1) {
                        continuar = false;
                    } else if (nota >= 0 && nota <= 5) {
                        calculadora.agregarNota(nota);
                    } else {
                        mostrarAlerta("Nota inválida", "La nota debe estar entre 0 y 5.");
                    }
                } catch (NumberFormatException e) {
                    mostrarAlerta("Entrada inválida", "Por favor, ingrese un número válido.");
                }
            }
        }

        double promedio = calculadora.calcularPromedio();
        return String.format("Se ingresaron las notas correctamente.\nPromedio: %.2f", promedio);
    }

    private static void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
