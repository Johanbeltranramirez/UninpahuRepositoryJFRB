package Models;
import Models.TipoPartida;
import Models.CategoriaPresupuesto;
import java.util.Date;

public class PartidaPresupuestaria {
    private int id;
    public CategoriaPresupuesto categoria;
    private String descripcion;
    private double monto;
    public TipoPartida tipo;
    private Date fecha;

    public PartidaPresupuestaria(int id, CategoriaPresupuesto categoria, String descripcion, double monto, TipoPartida tipo, Date fecha) {
        this.id = id;
        this.categoria = categoria;
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

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}

