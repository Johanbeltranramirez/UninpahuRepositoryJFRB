package DB;

import Models.Aprobacion;


public class AprobacionDB{
    
    public Aprobacion[] ltsAprobacion;
    
    public AprobacionDB(){
        ltsAprobacion = new Aprobacion[10];
        this.getAprobaciones();
    }
    
    public void getAprobaciones(){
        Aprobacion aprobacion = new Aprobacion(1, "Presupuesto 2025", 1, "pendiente" );
        
    }
    
}
