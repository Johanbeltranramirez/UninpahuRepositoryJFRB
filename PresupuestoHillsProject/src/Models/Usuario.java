package Models;
import Models.Rol;

public class Usuario {
    private int id;
    private String nDocId;
    private String nombre;
    private String email;
    public Rol rol; // "Administrador", "Finanzas", "Contable"

    public Usuario(int id, String nDocId, String nombre, String email, Rol rol) {
        this.id = id;
        this.nDocId = nDocId;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNDocId() { return nDocId; }
    public void setNDocId(String nDocId) { this.nDocId = nDocId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}

