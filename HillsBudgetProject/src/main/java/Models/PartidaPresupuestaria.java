package Models;
import java.util.Date;

public class PartidaPresupuestaria {
    private int id;
    public int idCategoria;
    private String descripcion;
    private double monto;
    private String tipo; //Si es ingreso o gasto
    private Date fecha;

    public PartidaPresupuestaria(int id, int idCategoria, String descripcion, double monto, String tipo, Date fecha) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}

