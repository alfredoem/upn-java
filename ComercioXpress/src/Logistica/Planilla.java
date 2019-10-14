/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logistica;

/**
 *
 * @author alfredo
 */
public class Planilla {
    
    private int año;
    private Empleado[] empleados;

    public Planilla() {
    }

    public Planilla(int año, int cantidadEmpleados) {
        this.año = año;
        empleados = new Empleado[cantidadEmpleados];
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleado(Empleado empleado, int numLista) {
        this.empleados[numLista] = empleado;
    }
    
    public void mostrarPlanilla() {
        
        if (this.empleados != null) {
            System.out.println("***PLANILLA - " + this.año + " ***");

            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
        } else {
            System.out.println("No hay empleados registrados!");
        }
        
    }
    
    
}
