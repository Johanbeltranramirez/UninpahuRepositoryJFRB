package Controllers;

import static DB.DataBaseSQL.Conectar;
import Models.Usuario;
import Services.UsuarioService;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioController {
    
    public UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public void InsertarUsuario(Usuario usuario) {        
        usuarioService.AgregarUsuario(usuario);
    }
    
    public void eliminarUsuario(int id) {
        usuarioService.EliminarUsuario(id);
    }
        
    public void ActualizarUsuario(Usuario usuario, int id) {
        usuarioService.EditarUsuario(usuario, id);
    }
    
    public ResultSet ConsultarUsuario(String ConsultarSQL){
        return usuarioService.ConsultarUsuario(ConsultarSQL);
    }
    
    
}
