package Logistica;

/**
 *
 * @author alfredo
 */
public class OperadorAlmacen extends Empleado implements ITrabajar {

    public OperadorAlmacen(int codigo, String nombre, String apellidos, String tipoDoc, String numDoc, double sueldo) {
        super(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
    }
    
    @Override
    public String getCargo() {
        return "Operador de almacen y despacho";
    }
    
    @Override
    public void trabajar() {
        System.out.println("Embalado y preparando paquetes para las rutas...");
    }
    
    
    
}
