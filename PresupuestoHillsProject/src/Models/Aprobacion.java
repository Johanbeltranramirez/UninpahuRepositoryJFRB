package Models;
import Models.Usuario;
import java.util.Date;

public class Aprobacion {
    private int id;
    public PresupuestoGeneral presupuesto; 
    public Usuario usuario;         
    public EstadoAprobacion estado;           
    private String comentarios;
    private Date fechaAprobacion;

    public Aprobacion(int id, PresupuestoGeneral presupuesto, Usuario usuario, EstadoAprobacion estado, String comentarios, Date fechaAprobacion) {
        this.id = id;
        this.presupuesto = presupuesto;
        this.usuario = usuario;
        this.estado = estado;
        this.comentarios = comentarios;
        this.fechaAprobacion = fechaAprobacion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public Date getFechaAprobacion() { return fechaAprobacion; }
    public void setFechaAprobacion(Date fechaAprobacion) { this.fechaAprobacion = fechaAprobacion; }
}
