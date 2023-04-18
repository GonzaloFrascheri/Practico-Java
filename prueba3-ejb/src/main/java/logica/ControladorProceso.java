package logica;

import datatypes.DtProceso;
import entidades.Proceso;
import excepciones.ProcesoRepetido;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ControladorProceso implements ControladorProcesoRemote, ControladorProcesoLocal{

    @EJB
    datos.ManejadorProcesosRemote mpr;

    public ControladorProceso(){}

    public void agregarProceso(DtProceso dtp) throws ProcesoRepetido {
        if(mpr.buscarProceso(dtp.getId()) != null){
            throw new ProcesoRepetido("El proceso con el ID ingresado ya existe");
        }else{
            Proceso p = new Proceso(dtp.getId(), dtp.getDescripcion());
            mpr.altaProceso(p);
        }
    }

    public DtProceso buscarProceso(int x){
        Proceso p = mpr.buscarProceso(x);
        if(p != null){
            DtProceso dtp = p.getDtProceso();
            return dtp;
        }
        return null;
    }

    public List<DtProceso> getProcesos(){
        List<Proceso> lp = mpr.obtProcesos();
        int tam = lp.size();
        List<DtProceso> dtp = new ArrayList<>();
        if(tam > 0){
            for(int i=0; i<tam; i++){
                dtp.add(lp.get(i).getDtProceso());
            }
        }else{
            return dtp;
        }
        return dtp;
    }
}
