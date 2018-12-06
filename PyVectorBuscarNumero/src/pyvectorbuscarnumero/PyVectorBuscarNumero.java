/*
 * 10. Ingresar n números enteros a un vector, luego ingrese un numero, 
 *  si el numero ingresado se encuentra dentro del vector, 
 *   que muestre su posición, caso contrario mostrar el mensaje: 
 *   “El numero no esta en el arreglo”.
 */
package pyvectorbuscarnumero;

import java.util.Scanner;

/**
 *
 * @author alfredo
 */
public class PyVectorBuscarNumero {
    
    static Scanner leer;

    public static void main(String[] args) 
    {
        leer = new Scanner(System.in);
        int numeros[], numero_buscar, cantidad, numero_posicion = 0;
        boolean encontrado = false;
        
        cantidad = leerentero("Cantidad de números a registrar");
        numeros = leervector(cantidad, "número entero");
        numero_buscar = leerentero("el número a buscar");
        
        for (int i = 0; i < cantidad; i++) {
            
            if (soniguales(numeros[i], numero_buscar)) {
                numero_posicion = i;
                encontrado = true;
            }
            
        }
        
        if (encontrado) {
            System.out.println("El número esta ubicado en la posición " + numero_posicion + " del arreglo");
        } else {
            System.out.println("El número no esta en el arreglo");
        }
    }
    
    public static int leerentero(String texto) 
    {
        int x;
        
        System.out.println("Ingrese "+texto);
        x=leer.nextInt();
        
        while (x < 0) {
            System.out.println("Error, Ingrese "+texto);
            x=leer.nextInt();   
        }
        
        return x;
    }
    
    public static int[] leervector(int n,String t)
    {
        int lista[];
        lista = new int[n];
        
        for (int i=0; i<n; i++) {
            lista[i] = leerentero(t+" "+(i+1)+": ");
        }
        
        return lista;
    }
    
    public static boolean soniguales(int numero, int numero_comparar) 
    {
        return numero == numero_comparar;
    }
    
}
