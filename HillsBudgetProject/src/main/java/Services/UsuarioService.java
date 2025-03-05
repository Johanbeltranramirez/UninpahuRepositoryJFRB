package Services;

import DB.DataBase;
import Models.Usuario;

public class UsuarioService {
    private DataBase db;

    public UsuarioService() {
        this.db = new DataBase();
        this.db.getUsuario();
        
    }
    public boolean agregarUsuario(Usuario nuevoUsuario) {

        return this.db.lstUsuarios.add(nuevoUsuario);

    }    
     public void ObtenerUsuario() {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < this.db.lstUsuarios.size(); i++) {

            if (this.db.lstUsuarios.get(i) != null) {

                System.out.println("id: " + this.db.lstUsuarios.get(i).getId());
                System.out.println("Nombre: " + this.db.lstUsuarios.get(i).getNombre());
                System.out.println("Email: " + this.db.lstUsuarios.get(i).getEmail());
                System.out.println("Rol: " + this.db.lstUsuarios.get(i).getRol());
                System.out.println("");

            }

        }
        System.out.println("---------------------------------------------------");
    }

    public boolean actualizarUsuario(Usuario editarUsuario) {
        boolean respuesta = false;
        for (int i = 0; i < this.db.lstUsuarios.size(); i++){
            if (this.db.lstUsuarios.get(i) != null && this.db.lstUsuarios.get(i).getId() == editarUsuario.getId()) {

                this.db.lstUsuarios.set(i, editarUsuario);
                respuesta = true;
                break;
            }
        }
        return respuesta;
       }    
    
   
     public boolean eliminarUsuario(int id) {
        boolean respuesta =false;
        
        for(int i = 0; i < this.db.lstUsuarios.size(); i++){
            if (this.db.lstUsuarios.get(i) !=null && this.db.lstUsuarios.get(i).getId() == id){
                this.db.lstUsuarios.remove(i);
                respuesta = true;
                break;
            }
        }
       return respuesta;
     }

}
