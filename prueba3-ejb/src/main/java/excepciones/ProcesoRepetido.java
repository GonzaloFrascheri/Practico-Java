package excepciones;

public class ProcesoRepetido extends Exception{

    private static final long serialVersionUID = 1L;

    public ProcesoRepetido(String mensaje) { super(mensaje);}
}
