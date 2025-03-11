package Models;

public class EstadoAprobacion {
    private int id;
    private String descEstado; // "Pendiente", "Aprobado", "Rechazado"

    public EstadoAprobacion(int id, String descEstado) {
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
