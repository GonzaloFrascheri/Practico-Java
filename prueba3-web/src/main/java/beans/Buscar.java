package beans;

import datatypes.DtProceso;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("buscarpp")
@RequestScoped
public class Buscar {

    @EJB
    logica.ControladorProcesoRemote cpr;

    private int id;
    private String desc;
    private DtProceso dtp;

    public Buscar() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DtProceso getDtp() {
        return dtp;
    }

    public void setDtp(DtProceso dtp) {
        this.dtp = dtp;
    }

    @PostConstruct
    public void findProceso() {
        this.dtp = cpr.buscarProceso(id);
    }
}
