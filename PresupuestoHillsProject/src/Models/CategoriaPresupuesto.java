package Models;

import java.util.Date;

public class CategoriaPresupuesto {
    
    private int id;
    private String nombreCategoria;
    
    public CategoriaPresupuesto(){
        
    }

    public CategoriaPresupuesto(int id, String nombreCategoria) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCategoria() { return nombreCategoria; }
    public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }

}
