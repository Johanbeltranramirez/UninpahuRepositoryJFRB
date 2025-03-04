package DB;

import Models.Usuario;


public class UsuarioDB{
    
    public Usuario[] dbUsuario;
    
    public UsuarioDB(){
        dbUsuario = new Usuario[10];
        this.getUsuario();
    }
    
    public void getUsuario(){
        Usuario usuario = new Usuario(1, "Jhoan Ramirez", "jhoan123@gmail.com", "administrador");
        Usuario usuario2= new Usuario(2, "Andres Jimenez", "Jimenez02@gmail.com", "finanzas");
        Usuario usuario3 = new Usuario(3, "Maria Gonzalez", "maria.g@gmail.com", "administrador");
        Usuario usuario4 = new Usuario(4, "Carlos Perez", "carlos.perez@yahoo.com", "contable");
        Usuario usuario5 = new Usuario(5, "Laura Torres", "laura.t@gmail.com", "finanzas");
        
        dbUsuario[0] = usuario;
        dbUsuario[1] = usuario2;
        dbUsuario[2] = usuario3;
        dbUsuario[3] = usuario4;
        dbUsuario[4] = usuario5;
}
    
}
