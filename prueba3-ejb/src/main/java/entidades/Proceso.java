package entidades;

import datatypes.DtProceso;

import java.io.Serializable;

public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String descripcion;

    public Proceso(int id, String descripcion){
        super();
        this.id = id;
        this.descripcion = descripcion;
    }

    public Proceso(){super();}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DtProceso getDtProceso(){
        DtProceso dtp = new DtProceso(this.getId(), this.getDescripcion());
        return dtp;
    }

}
