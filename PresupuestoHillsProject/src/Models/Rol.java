package Models;

public class Rol {

    private int id;
    private String descRol;

    public Rol() {
    }

    public Rol(int id, String descRol) {
        this.id = id;
        this.descRol = descRol;
    }

    public Rol(String descRol) {
        this.descRol = descRol;
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

    @Override
    public String toString() {
        return descRol;
    }
}

