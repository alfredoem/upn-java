package Logistica;

/**
 *
 * @author alfredo
 */
public abstract class Empleado implements ITrabajar {
    
    private int codigo;
    private String nombre;
    private String apellidos;
    private String tipoDoc;
    private String numDoc;
    private double sueldo;

    public Empleado(int codigo, String nombre, String apellidos, String tipoDoc, String numDoc, double sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.sueldo = sueldo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public abstract String getCargo();

    @Override
    public String toString() {
        return "Empleado{" 
                + "codigo=" + codigo 
                + "cargo=" + getCargo()
                + ", nombre=" + nombre 
                + ", apellidos=" + apellidos
                + ", tipoDoc=" + tipoDoc
                + ", numDoc=" + numDoc 
                + ", sueldo=" + sueldo
                + '}';
    }
    
}
