package datos;

import entidades.Proceso;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
@LocalBean
public class ManejadorProcesos implements ManejadorProcesosRemote{

    private List<Proceso> procesos = new ArrayList<>();

    public ManejadorProcesos(){}

    public void altaProceso(Proceso proceso) { this.procesos.add(proceso);}

    public Proceso buscarProceso(int id){
        for(int i=0; i<this.procesos.size();i++){
            if(procesos.get(i).getId() == id){
                return this.procesos.get(i);
            }
        }
        return null;
    }

    public List<Proceso> obtProcesos(){ return this.procesos;}
}
