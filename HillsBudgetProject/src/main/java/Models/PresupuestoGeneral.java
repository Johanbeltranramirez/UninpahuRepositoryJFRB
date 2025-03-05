
package Models;

public class PresupuestoGeneral {
    private int id;
    private String nombre;
    private String descripcion;
    private double montoTotal;
    private String estado;  // "Borrador", "Aprobado", "Rechazado"
    private String fechaCreacion;

    public PresupuestoGeneral(int id, String nombre, String descripcion, double montoTotal, String estado, String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoTotal = montoTotal;
        this.estado = estado;
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

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(String fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}

