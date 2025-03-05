package Models;
import java.util.Date;

public class Aprobacion {
    private int id;
    public PresupuestoGeneral presupuesto; //Referencia a Presupuesto
    public Usuario usuario;         //Referencia a Usuario
    private String estado;           // "Pendiente", "Aprobado", "Rechazado"
    private String comentarios;
    private String fechaAprobacion;

    public Aprobacion(int id, PresupuestoGeneral presupuesto, Usuario usuario, String estado, String comentarios, String fechaAprobacion) {
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

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public String getFechaAprobacion() { return fechaAprobacion; }
    public void setFechaAprobacion(String fechaAprobacion) { this.fechaAprobacion = fechaAprobacion; }
}
