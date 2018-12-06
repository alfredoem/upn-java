/*
 * 5. Guardar n números enteros a un vector, calcular el promedio 
 *  y reemplazar todos los números que ocupan las posiciones pares, 
 *  por el promedio calculado.
 */
package pyvectorpromedio;

import java.util.Scanner;

/**
 *
 * @author alfredo
 */
public class PyVectorPromedio {
    
    static Scanner leer;

    public static void main(String[] args) 
    {
        leer=new Scanner(System.in);
        int cantidad;
        double numeros[], promedio;
        
        cantidad=leerentero("Cantidad de números a promediar");
        numeros=leervector(cantidad,"número entero");
        promedio=promediovector(numeros, cantidad);
        
        System.out.println("El promedio es: " + promedio);
        
        for (int i = 0; i < cantidad; i++) {
            
            if (espar(i)) {
                numeros[i] = promedio;
            }
            
            System.out.println("El nuevo valor de la posición " + i + " es: " + numeros[i]);
            
        }
        
    }
    
    public static int leerentero(String texto)
    {
        int x;
        
        System.out.println("Ingrese "+texto);
        x=leer.nextInt();
        
        while (x < 0){
            System.out.println("Error, Ingrese "+texto);
            x = leer.nextInt();   
        }
        
        return x;
    }
    
    public static double[] leervector(int n, String t)
    {
        double lista[];
        lista = new double[n];
        
        for(int i = 0; i < n; i++) {
            lista[i] = leerentero(t + " " + (i + 1) + ": ");
        }
        
        return lista;
    }
    
    public static double promediovector(double[] lista, int cantidad) 
    {
        int suma = 0;
                
        for (int i = 0; i < cantidad; i++) {
            suma += lista[i];
        }
        
        return (double) suma/cantidad;
    }
    
    public static boolean espar(int numero)
    {
        if (numero == 0) {
            return false;
        }
        
        return numero%2 == 0;
    }
    
}
