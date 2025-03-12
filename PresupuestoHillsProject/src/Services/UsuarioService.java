package Services;

import Models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios;

    public UsuarioService() {
        this.usuarios = new ArrayList<>();
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        return usuarios.add(usuario);
    }

    public boolean actualizarUsuario(int id, String nDocId, String nombre, String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.setNDocId(nDocId);
                usuario.setNombre(nombre);
                usuario.setEmail(email);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    public Usuario obtenerUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
