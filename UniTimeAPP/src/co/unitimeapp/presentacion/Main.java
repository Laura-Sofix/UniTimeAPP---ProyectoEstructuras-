package co.unitimeapp.presentacion;

import co.unitimeapp.calendario.Calendario;
import co.unitimeapp.usuario.ArbolUsuarios;
import co.unitimeapp.usuario.ListaUsuariosTareas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolUsuarios arbolUsuarios = new ArbolUsuarios();
        ListaUsuariosTareas listaUsuariosTareas = new ListaUsuariosTareas();

        MenuPrincipalManager.mostrarMenuPrincipal(scanner, arbolUsuarios, listaUsuariosTareas, new Calendario());

    }
}

