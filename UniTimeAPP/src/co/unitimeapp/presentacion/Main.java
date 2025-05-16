package co.unitimeapp.presentacion;

import co.unitimeapp.usuario.ArbolUsuarios;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolUsuarios arbolUsuarios = new ArbolUsuarios();

        MenuPrincipalManager.mostrarMenuPrincipal(scanner, arbolUsuarios);
    }
}
