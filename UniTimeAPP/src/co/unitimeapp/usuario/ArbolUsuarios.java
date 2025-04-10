package co.unitimeapp.usuario;

class NodoUsuario {
    Usuario usuario;
    NodoUsuario izquierdo, derecho;

    public NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ArbolUsuarios {
    private NodoUsuario raiz;

    public String insertarUsuario(String correo, String contraseña) {
        if (!correo.endsWith("@poligran.edu.co")) {
            return "formato invalido";
        }
        if (raiz == null) {
            raiz = new NodoUsuario(new Usuario(correo, contraseña));
            return "exito";
        } else {
            boolean exito = insertar(raiz, correo, contraseña);
            return exito ? "exito" : "existe";
        }
    }

    private boolean insertar(NodoUsuario nodo, String correo, String contraseña) {
        if (correo.equals(nodo.usuario.correo)) {
            return false;
        } else if (correo.compareTo(nodo.usuario.correo) < 0) {
            if (nodo.izquierdo == null) {
                nodo.izquierdo = new NodoUsuario(new Usuario(correo, contraseña));
                return true;
            } else {
                return insertar(nodo.izquierdo, correo, contraseña);
            }
        } else {
            if (nodo.derecho == null) {
                nodo.derecho = new NodoUsuario(new Usuario(correo, contraseña));
                return true;
            } else {
                return insertar(nodo.derecho, correo, contraseña);
            }
        }
    }

    public boolean verificarCredenciales(String correo, String contraseña) {
        return buscar(raiz, correo, contraseña);
    }

    private boolean buscar(NodoUsuario nodo, String correo, String contraseña) {
        if (nodo == null) {
            return false;
        }
        if (correo.equals(nodo.usuario.correo)) {
            return nodo.usuario.contraseña.equals(contraseña);
        } else if (correo.compareTo(nodo.usuario.correo) < 0) {
            return buscar(nodo.izquierdo, correo, contraseña);
        } else {
            return buscar(nodo.derecho, correo, contraseña);
        }
    }
}
