/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, c
hoose Tools | Templates
 * and open the template in the editor.
 */
package sishotel;

import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class SisHotel {

    
  public static  String[][] Habitaciones= new String[5][2] ;
  public static  String[][] Clientes= new String[5][3] ;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        // TODO code application logic here
       
        
        Iniciar(); 
        LlenarHabitaciones();       
        GestionOpciones();
       
    }
    
    
    public static void LlenarHabitaciones(){
           
        int i , j  ;  
    
         for (i = 0; i < 5; i++) {
//            for (j = 0; j < 2; j++) {                
//                Habitaciones [i][j] = //            }
            Habitaciones [i][0] = "Habitacion " + i ;
            Habitaciones [i][1] = "Disponible " ;
            
        }
    }
    
    
    public static void ListarHabitaciones(){
    
          int i , j  ;  
    
         for (i = 0; i < 5; i++) {
//            for (j = 0; j < 2; j++) {                
//                Habitaciones [i][j] = //            }
             System.out.println( Habitaciones [i][0]  +  "  Estado : " + Habitaciones [i][1]);
            
        }
    }
    
    public  static void GestionOpciones(){
    
    
        int Opcion ; 
        Scanner Leer = new Scanner(System.in);
        
        Opcion = Leer.nextInt();
        
        
        while (Opcion!=0){

        if (Opcion==1){
            ListarHabitaciones ();
            Opcion = Leer.nextInt();            
          }
        
         
        switch (Opcion){
        
            case 2 : RegistrarCliente()  ;
            case 3 :  ;
            case 4 :  ;
            case 5 :  ;
            case 6 :  ;
            case 7 :  ;
            break ; 
        }
        
       }
        
        
        
        
    }
    
    public  static void  Iniciar(){
    
           System.out.println(".:: Bienvenido al Sistema de Hotel V2019 ::. ");                   
           
           System.out.println("Seleccione las Siguientes Opciones para comenzar con la Gestión ");
           
           System.out.println("(1)Ver Habitaciones Disponibles");
           System.out.println("(2)Registrar Cliente" );
           System.out.println("(3)Nuevo Hospedaje");
           System.out.println("(4)Ver Cuenta de Cliente");
           System.out.println("(5)Agregar Productos");
           System.out.println("(6)Cerrar Habitacion");
           System.out.println("(7)Ver Habitacion Ocupada ");
           System.out.println("(o) Salir del Sistema ");
           
    }
    
    
    
    
    public static void RegistrarCliente() {
    
        String Nombres ,Apellidos ,Dni ; 
        Scanner Leer = new Scanner(System.in);        
        System.out.println("Ingrese Nombres ");

        Nombres=Leer.next();
        
        System.out.println("Ingrese Apellidos ");
        Apellidos=Leer.next();
        System.out.println("Ingrese Dni ");
        Dni=Leer.next() ; 
                
           System.out.println("El clienete :" + Nombres + " " + Apellidos  + " ,Fue Correctamente Registrado");
         
        
    }
}
