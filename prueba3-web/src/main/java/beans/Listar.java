package beans;

import datatypes.DtProceso;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named("listarpp")
@RequestScoped
public class Listar {

    @EJB
    logica.ControladorProcesoRemote cpr;

    private List<DtProceso> dtp = new ArrayList<>();

    public Listar() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    public void init() {
        dtp = cpr.getProcesos();
    }

    public List<DtProceso> getDtp() {
        return dtp;
    }

    public void setDtp(List<DtProceso> dtp) {
        this.dtp = dtp;
    }

}
