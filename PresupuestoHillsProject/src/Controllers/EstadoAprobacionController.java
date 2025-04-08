package Controllers;

import Models.EstadoAprobacion;
import Services.EstadoAprobacionService;
import java.sql.*;

public class EstadoAprobacionController {
            
    public EstadoAprobacionService estadoService;

    public EstadoAprobacionController() {
        this.estadoService = new EstadoAprobacionService ();
    }

    public void insertarEstado(EstadoAprobacion estado) {
        estadoService.AgregarEstadoAprobacion(estado);
    }
    
    public void eliminarEstado(int id) {
        estadoService.EliminarEstadoAprobacion(id);
    }

    public void actualizarEstado(EstadoAprobacion estado, int id) {
        estadoService.EditarEstadoAprobacion(estado, id);
    }


    public ResultSet listarEstados(String ConsultaSQL) {
         return estadoService.ListarEstadosAprobacion(ConsultaSQL);
    }
}
