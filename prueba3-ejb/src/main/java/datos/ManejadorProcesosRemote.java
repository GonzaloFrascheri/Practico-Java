package datos;

import entidades.Proceso;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface ManejadorProcesosRemote {

    public void altaProceso(Proceso proceso);

    public Proceso buscarProceso(int id);

    public List<Proceso> obtProcesos();

}
