/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyplanfinanciero;

import java.util.Scanner;

/**
 *
 * @author alfredo
 */
public class PyPlanFinanciero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double saldo_actual = 0, saldo_nuevo = 0, monto_prestamo = 0, monto_insumos = 0, monto_incentivos = 0;
        int monto_ecomputo = 0, monto_mobiliario = 0;
           
        System.out.println("Ingresa el saldo actual:");
        saldo_actual = leer.nextDouble();
        
        if (saldo_actual < 0) {
            monto_prestamo = 10000 - saldo_actual;
        } else if (saldo_actual > 0) {
            
            if (saldo_actual < 20000) {
                monto_prestamo = 20000 - saldo_actual;
            }
        }
        
        saldo_nuevo = saldo_actual + monto_prestamo;
        
        monto_ecomputo = 5000;
        monto_mobiliario = 2000;
        
        saldo_nuevo = saldo_nuevo - (monto_ecomputo + monto_mobiliario);
        
        monto_insumos = saldo_nuevo / 2;
        monto_incentivos = saldo_nuevo / 2;
        
        System.out.println("Monto insumos: " + monto_insumos);
        System.out.println("Monto incentivos: " + monto_incentivos);
        
        if (monto_prestamo > 0) {
            System.out.println("Monto prestamo: " + monto_prestamo);
        }
        

    }
     
}
