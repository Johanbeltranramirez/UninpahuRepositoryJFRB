package Models;

public class CategoriaPresupuesto {
    private int id;
    public int idPresupuesto;
    private String nombreCategoria;
    private double montoAsignado;

    public CategoriaPresupuesto(int id, int idPresupuesto, String nombreCategoria, double montoAsignado) {
        this.id = id;
        this.idPresupuesto = idPresupuesto;
        this.nombreCategoria = nombreCategoria;
        this.montoAsignado = montoAsignado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCategoria() { return nombreCategoria; }
    public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }

    public double getMontoAsignado() { return montoAsignado; }
    public void setMontoAsignado(double montoAsignado) { this.montoAsignado = montoAsignado; }
}
