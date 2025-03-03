package Models;
import java.util.Date;

public class EjecucionPresupuestaria {
    private int id;
    public int idPartida;
    private double montoReal;
    private Date fecha;

    public EjecucionPresupuestaria(int id, int idPartida, double montoReal, Date fecha) {
        this.id = id;
        this.idPartida = idPartida;
        this.montoReal = montoReal;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getMontoReal() { return montoReal; }
    public void setMontoReal(double montoReal) { this.montoReal = montoReal; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}

