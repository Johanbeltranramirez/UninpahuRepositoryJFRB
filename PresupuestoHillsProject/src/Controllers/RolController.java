package Controllers;

import static DB.DataBaseSQL.Conectar;
import Models.Rol;
import Services.RolService;
import java.sql.*;
import javax.swing.JOptionPane;

public class RolController {
    
    public RolService rolService;

    public RolController() {
        this.rolService = new RolService();
    }

    public void insertarRol(Rol rol) {
        rolService.AgregarRol(rol);
    }
    
    public void eliminarRol(int id) {
        System.out.println("ID:" + id);
        rolService.EliminarRol(id);
    }

    public void actualizarRol(Rol rol, int id){
        rolService.EditarRol(rol, id);
    }

    public ResultSet listarRoles(String ConsultaSQL) {
        return rolService.listarRoles(ConsultaSQL);
    }
}
