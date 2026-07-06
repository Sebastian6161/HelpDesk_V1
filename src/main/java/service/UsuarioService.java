package service;

import model.Usuario;
import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuario agregado correctamente.");
    }

    public Usuario buscarUsuario(int id) {

        for (Usuario usuario : listaUsuarios) {

            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }

    public void mostrarUsuarios() {

        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : listaUsuarios) {
            usuario.mostrarInfo();
        }
    }
}
