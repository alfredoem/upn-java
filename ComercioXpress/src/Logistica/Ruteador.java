package Logistica;

/**
 *
 * @author alfredo
 */
public class Ruteador extends Empleado {

    public Ruteador(int codigo, String nombre, String apellidos, String tipoDoc, String numDoc, double sueldo) {
        super(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
    }
    
    @Override
    public String getCargo() {
        return "Ruteador de entregas y recojos";
    }
    
    @Override
    public void trabajar() {
        System.out.println("Crando rutas de entregas y recojos de paquetes...");
    }
    
}
