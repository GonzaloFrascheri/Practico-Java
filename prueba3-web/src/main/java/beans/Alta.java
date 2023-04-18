package beans;

import datatypes.DtProceso;
import excepciones.ProcesoRepetido;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("addpp")
@RequestScoped
public class Alta {

    @EJB
    logica.ControladorProcesoRemote cpr;

    private int id;
    private String desc;

    public Alta() {
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

    public void addDtp() { //
        DtProceso dtp = new DtProceso(this.id, this.desc);

        try {
            cpr.agregarProceso(dtp);
            System.out.println("HICE EL ADD");
        } catch (ProcesoRepetido e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
