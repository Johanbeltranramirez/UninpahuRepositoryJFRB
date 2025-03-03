package Controllers;

import Models.Usuario;
import Services.UsuarioService;
import java.util.List;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public void insertarUsuario(Usuario usuario) {
        boolean respuesta = usuarioService.agregarUsuario(usuario);
        if (respuesta) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("Error al registrar usuario. Contacte al administrador.");
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        boolean respuesta = usuarioService.actualizarUsuario(usuario);
        if (respuesta) {
            System.out.println("Usuario actualizado con éxito.");
        } else {
            System.out.println("Error al actualizar usuario. Contacte al administrador.");
        }
    }

    public void eliminarUsuario(int id) {
        boolean respuesta = usuarioService.eliminarUsuario(id);
        if (respuesta) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar usuario. Contacte al administrador.");
        }
    }

    public void obtenerUsuario(int id) {
        Usuario usuario = usuarioService.obtenerUsuario(id);
        if (usuario != null) {
            System.out.println(usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void imprimirUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }
}
