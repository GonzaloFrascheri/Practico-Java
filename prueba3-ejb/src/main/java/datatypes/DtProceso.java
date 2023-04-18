package datatypes;

import java.io.Serializable;

public class DtProceso implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String descripcion;

    public DtProceso(int id, String descripcion){
        super();
        this.id = id;
        this.descripcion = descripcion;
    }

    public DtProceso(){super();}

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

    public String toString(){ return "DtProceso [id= " + id + ", descripcion=" + descripcion + "\n]";}

}
