package logica;

import datatypes.DtProceso;
import excepciones.ProcesoRepetido;

import java.util.List;

public interface ControladorProcesoLocal {

    public void agregarProceso(DtProceso dtp) throws ProcesoRepetido;

    public DtProceso buscarProceso(int x);

    public List<DtProceso> getProcesos();
}
