package Models;

import java.util.Date;

public class Rol {
    
    private int id;
    private String descRol;
    
    public Rol(){
        
    }

    public Rol(int id, String descRol) {
        this.id = id;
        this.descRol = descRol; // Administrador, Contador, Cliente
    }

    public int getRolId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescRol() {
        return descRol;
    }

    public void setDescRol(String descRol) {
        this.descRol = descRol;
    }
       
}
