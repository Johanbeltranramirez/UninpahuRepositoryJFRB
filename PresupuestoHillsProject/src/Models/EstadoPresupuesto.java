package Models;

public class EstadoPresupuesto {
    private int id;
    private String descEstado; // "Borrador", "Aprobado", "Rechazado"
    
    public EstadoPresupuesto(){
        
    }

    public EstadoPresupuesto(int id, String descEstado) {
        this.id = id;
        this.descEstado = descEstado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }
    
}
