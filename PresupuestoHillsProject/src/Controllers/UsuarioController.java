package Controllers;
import Models.Usuario;
import Services.UsuarioService;

public class UsuarioController {
    public UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public void insertarUsuario(Usuario usuario) {
        if (usuario == null) {
            System.err.println("Error: El usuario no puede ser nulo.");
            return;
        }

        usuarioService.AgregarUsuario(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioService.EditarUsuario(usuario);
        System.out.println("Usuario actualizado con éxito.");
    }

    public void eliminarUsuario(int id) {
        usuarioService.EliminarUsuario(id);
        System.out.println("Usuario eliminado correctamente.");
    }

    public void listarUsuarios() {
        usuarioService.MostrarUsuarios();
    }
}
