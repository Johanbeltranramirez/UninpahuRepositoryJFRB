package Controllers;

import Models.Usuario;
import Services.UsuarioService;
import java.util.List;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void insertarUsuario(Usuario usuario) {
        if (usuario == null) {
            System.err.println("Error: El usuario no puede ser nulo.");
            return;
        }

        boolean respuesta = usuarioService.agregarUsuario(usuario);
        if (respuesta) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.err.println("Error al registrar usuario. Contacte al administrador.");
        }
    }

    public void actualizarUsuario(int id, String nDocId, String nombre, String email) {
        boolean respuesta = usuarioService.actualizarUsuario(id, nDocId, nombre, email);
        if (respuesta) {
            System.out.println("Usuario actualizado con éxito.");
        } else {
            System.err.println("Error al actualizar usuario. Contacte al administrador.");
        }
    }

    public void eliminarUsuario(int id) {
        boolean respuesta = usuarioService.eliminarUsuario(id);
        if (respuesta) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.err.println("Error al eliminar usuario. Contacte al administrador.");
        }
    }

    public void obtenerUsuario(int id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getNombre());
        } else {
            System.err.println("No se encontró el usuario con ID: " + id);
        }
    }

    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Email: " + usuario.getEmail());
            }
        }
    }
}
