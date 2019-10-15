package Logistica;

/**
 *
 * @author alfredo
 */
public class JefeAlmacen extends Empleado {

    public JefeAlmacen(int codigo, String nombre, String apellidos, String tipoDoc, String numDoc, double sueldo) {
        super(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
    }

    @Override
    public String getCargo() {
        return "Jefe de Almacen";
    }

    @Override
    public void trabajar() {
        System.out.println("Supervisando operaciones en almacen...");
    }
    
}
