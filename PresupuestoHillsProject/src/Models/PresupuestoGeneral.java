package Models;
import Models.CategoriaPresupuesto;
import Models.EstadoPresupuesto;
import java.util.Date;

public class PresupuestoGeneral {
    private int id;
    private String nombre;
    private String descripcion;
    private double montoTotal;
    public EstadoPresupuesto estado; 
    public CategoriaPresupuesto categoria;
    private Date fechaCreacion;

    public PresupuestoGeneral(int id, String nombre, String descripcion, double montoTotal, EstadoPresupuesto estado, CategoriaPresupuesto categoria, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoTotal = montoTotal;
        this.estado = estado;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}

