package logica;

import datatypes.DtProceso;
import excepciones.ProcesoRepetido;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface ControladorProcesoRemote {

    static final long serialVersionUID = 1L;

    public void agregarProceso(DtProceso dtp) throws ProcesoRepetido;

    public DtProceso buscarProceso(int x);

    public List<DtProceso> getProcesos();
}
