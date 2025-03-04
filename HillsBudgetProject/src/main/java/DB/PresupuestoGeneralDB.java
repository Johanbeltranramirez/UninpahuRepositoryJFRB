package DB;

import Models.PresupuestoGeneral;


public class PresupuestoGeneralDB{
    
    public PresupuestoGeneral[] dbPresupuestoGeneral;
    
    public PresupuestoGeneralDB(){
        dbPresupuestoGeneral = new PresupuestoGeneral[10];
        this.getPresupuestoGeneral();
    }
    
    public void getPresupuestoGeneral(){
        PresupuestoGeneral presupuestoGeneral = new PresupuestoGeneral(1, "Presupuesto 2025", "Presupuesto anual para operaciones generales", 50000, "Pendiente", '02/03/2025');
        
        PresupuestoGeneral[0] = presupuestoGeneral;
        
    
}
