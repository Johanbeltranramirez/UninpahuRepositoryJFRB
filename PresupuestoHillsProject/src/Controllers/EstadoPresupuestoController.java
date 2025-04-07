package Controllers;

import Models.EstadoPresupuesto;
import Services.EstadoPresupuestoService;
import java.sql.*;

public class EstadoPresupuestoController {
    
    public EstadoPresupuestoService estadoService;

    public EstadoPresupuestoController() {
        this.estadoService = new EstadoPresupuestoService ();
    }

    public void insertarEstado(EstadoPresupuesto estado) {
        estadoService.AgregarEstadoPresupuesto(estado);
    }

    public void eliminarEstado(int id) {
        estadoService.EliminarEstadoPresupuesto(id);
    }
    
    public void actualizarEstado(EstadoPresupuesto estado, int id) {
        estadoService.EditarEstadoPresupuesto(estado, id);
        
    }

    public ResultSet listarEstadoPresupuesto(String ConsultaSQL){
        return estadoService.listarEstadoPresupuesto(ConsultaSQL);
    }
}
