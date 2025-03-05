package Services;

import Models.PresupuestoGeneral;
import DB.DataBase;

public class PresupuestoGeneralService {
    private DataBase db;

    public PresupuestoGeneralService() {
        this.db = new DataBase();
        this.db.getPresupuestoGeneral();
    }

    public boolean agregarPresupuesto(PresupuestoGeneral presupuesto) {
        return db.lstPresupuestos.add(presupuesto);
    }
    
     public void ObtenerLista() {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < this.db.lstPresupuestos.size(); i++) {

            if (this.db.lstPresupuestos.get(i) != null) {

                System.out.println("id: " + this.db.lstPresupuestos.get(i).getId());
                System.out.println("Nombre: " + this.db.lstPresupuestos.get(i).getNombre());
                System.out.println("Descripcion: " + this.db.lstPresupuestos.get(i).getDescripcion());
                System.out.println("montoTotal: " + this.db.lstPresupuestos.get(i).getMontoTotal());
                System.out.println("Estado: " + this.db.lstPresupuestos.get(i).getEstado());
                System.out.println("fechaCreacuion: " + this.db.lstPresupuestos.get(i).getFechaCreacion());
                System.out.println("");

            }

        }
        System.out.println("---------------------------------------------------");
    }

    

    public boolean actualizarPresupuesto(PresupuestoGeneral editarPresupuesto) {

        boolean respuesta = false;

        for (int i = 0; i < this.db.lstPresupuestos.size(); i++) {
            if (this.db.lstPresupuestos.get(i) != null && this.db.lstPresupuestos.get(i).getId() == editarPresupuesto.getId()) {

                this.db.lstPresupuestos.set(i, editarPresupuesto);
                respuesta = true;
                break;
            }
        }

        return respuesta;
    }

    public boolean eliminarPresupuesto(int id) {
        boolean respuesta =false;
        
        for(int i = 0; i < this.db.lstPresupuestos.size(); i++){
            if (this.db.lstPresupuestos.get(i) !=null && this.db.lstPresupuestos.get(i).getId() == id){
                this.db.lstPresupuestos.remove(i);
                respuesta = true;
                break;
            }
        }
       return respuesta;
    }
    
}

    