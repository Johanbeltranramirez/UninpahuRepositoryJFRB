package Models;

public class TipoPartida {
    private int id;
    private String descTipo; //Si es ingreso o gasto

    public TipoPartida(){
        
    }
    public TipoPartida(int id, String descTipo) {
        this.id = id;
        this.descTipo = descTipo;
    }

    public int getTipoId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescTipo() {
        return descTipo;
    }

    public void setDescTipo(String descTipo) {
        this.descTipo = descTipo;
    }
    
    
    
}
