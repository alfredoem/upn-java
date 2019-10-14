/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logistica;

import java.util.Scanner;

/**
 *
 * @author alfredo
 */
public class LogisticaPrincipal {

    // Principales rutas de transportistas
    static Ruta rutaLima;
    static Ruta rutaPiura;
    static Ruta rutaJunin;
    static Ruta rutaAyacucho;
    static Almacen almacenCentral = new Almacen();
    // Cubicadora para el calculo de peso volumetrico
    static Cubicadora cubicadora;
    static Scanner sc = new Scanner(System.in);
    static Planilla planilla = new Planilla();
    
    public static void main(String[] args) {
        
        System.out.println("***Almacen Central de ComercioXpress*****");
        
        menu();

        //crearPlanilla();
        //planilla.mostrarPlanilla();
        
        //ingresarPaquetes();
        //almacenCentral.mostrar();
        
        
        // creacion de objetos Paquete con los datos basicos necesarios
        // para su procesamiento
        /*Paquete paquete1 = new Paquete(1, 4, "PE-LIM", "Adalbert Steiner", "985544111", 76, 32, 16);
        Paquete paquete2 = new Paquete(2, 6, "PE-PIU", "Cloud Strife", "945522147", 66, 10, 46);
        Paquete paquete3 = new Paquete(3, 67, "PE-PIU", "Yitan Tribal", "874521456", 29, 29, 29);
        Paquete paquete4 = new Paquete(4, 15, "PE-LIM", "Garnet Von Alexandros", "778563215", 40, 55, 80);
        Paquete paquete5 = new Paquete(5, 21, "PE-JUN", "Squall Leonhart", "881236544", 38, 24, 24);
        Paquete paquete6 = new Paquete(6, 99, "PE-JUN", "Tifa Lockhart", "784523698", 38, 46, 29);
        Paquete paquete7 = new Paquete(7, 45, "PE-JUN", "Aerith Gainsborough", "124565782", 12, 56, 24);
        Paquete paquete8 = new Paquete(8, 14, "PE-JUN", "Rinoa Heartilly", "547898654", 8, 32, 40);
        
        
        // creación de un objeto Almacen para ingresar los paquetes
        almacenCentral = new Almacen();
        
        // insercion de los paquetes en la cola paquetes del Almacen
        almacenCentral.insertar(paquete1);
        almacenCentral.insertar(paquete2);
        almacenCentral.insertar(paquete3);
        almacenCentral.insertar(paquete4);
        almacenCentral.insertar(paquete5);
        almacenCentral.insertar(paquete6);
        almacenCentral.insertar(paquete7);
        almacenCentral.insertar(paquete8);
        
        creandoRutas();
        
        System.out.println("Cantidad de paquetes ingresados al Almacen Central: " + almacenCentral.contar());
        System.out.println("*****Mostrando descripción de paquetes ingresados*****");
        almacenCentral.mostrar();
        
        System.out.println("*****Se registro mal la información del paquete con el ID: 6*****");
        System.out.println("Actualizando paquete...");
        Paquete nuevoPaquete6 = new Paquete(6, 1, "PE-JUN", "Zack Fair", "5548784", 38, 46, 29);
        almacenCentral.actualizar(6, nuevoPaquete6);
        System.out.println("*****Mostrando descripción de paquetes*****");
        almacenCentral.mostrar();
        
        System.out.println("*****Comenzando proceso de creado de rutas de entrega*****");
        creandoRutas();
        System.out.println("*****Comenzando proceso de pesado de paquetes y armado de rutas de entrega*****");
        armadoRutasDeEntrega();
        
        System.out.println("*****Mostrando descripcion de rutas y paquetes*****");
        mostrandoRutas();
        
        System.out.println("*****Eliminando paquetes de la ruta Junin por falta de espacio en el transporte*****");
        rutaJunin.eliminar();
        rutaJunin.eliminar();
        rutaJunin.eliminar();
        
        System.out.println("*****Mostrando descripcion final de rutas y paquetes ramados*****");
        mostrandoRutas();*/
    }
    
    public static void mostrarMenu() {
        System.out.println("**Menu de opciones**");
        System.out.println("0. Mostrar menu");
        System.out.println("1. Crear planilla");
        System.out.println("2. Mostrar empleados en planilla");
        System.out.println("3. Ingresar paquetes de productos al HUB");
        System.out.println("4. Crear Rutas de Entrega");
        System.out.println("5. Armado y pesado de piezas por ruta");
        System.out.println("6. Salir");
    }
    
    public static void menu() {
        
        int opt = 0;
        mostrarMenu();
        
        while (opt != 5) {
            
            System.out.println("Seleccione una opcion del menu:");
            opt = sc.nextInt();

            switch(opt) {
                case 0:
                    mostrarMenu();
                    break;
                case 1:
                    crearPlanilla();
                    break;
                case 2:
                    planilla.mostrarPlanilla();
                    break;
                case 3:
                    ingresarPaquetes();
                    break;
                case 4:
                    creandoRutas();
                    break;
                case 5:
                    armadoRutasDeEntrega();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
            
        }
        
    }
    
    // creación de objetos Ruta
    public static void creandoRutas() {
        
        System.out.println("***** Creacion de Rutas *****");
        int salir = 0;
        
        while (salir == 0) {
            
            System.out.println("Ingrese el codigo de ruta a crear, PE-LIM, PE-PIU, PE-JUN, PE-AYA");
            String codigoRuta = sc.next().toUpperCase();

            if (!almacenCentral.buscarRuta(codigoRuta)) {
                System.out.println("No hay paquetes ingresados para la ruta: " + codigoRuta);
            } else {
                
                switch(codigoRuta) {
                    case "PE-LIM":
                        rutaLima = new Ruta(codigoRuta);
                        break;
                    case "PE-PIU":
                        rutaPiura = new Ruta(codigoRuta);
                        break;
                    case "PE-JUN":
                        rutaJunin = new Ruta(codigoRuta);
                        break;
                    case "PE-AYA":
                        rutaAyacucho = new Ruta(codigoRuta);

                        break;
                }
                
                System.out.println("Se creo la ruta: " + codigoRuta);
            }
            
            System.out.println("Seguir creando rutas? S/N");
            String res = sc.next().trim();
            
            if (res.equalsIgnoreCase("N")) {
                salir = 1;
            }
        }
        
    }
    
    // Inserción de paquetes a las rutas correspondientes segun el destino
    public static void armadoRutasDeEntrega() {
        
        // creación de objeto Cubicadora
        cubicadora = new Cubicadora();
        
        // se obteiene el primer paquete que ingreso al almacen
        Paquete paquete = almacenCentral.extraer();
        
        // mientras que el paquete no sea nulo
        while (paquete != null) {            
            // se calcula y actualiza el peso volumetrico del paquete
            paquete.setPesoVolumetrico(cubicadora.calcularPesoVolumetrico(paquete.getLargo(), paquete.getAncho(), paquete.getAlto()));
            
            // se inserta el paquete a la ruta correspondiente
            // dea cuerdo al destino
            switch(paquete.getCodigoDestino()) {
                case "PE-LIM":
                    rutaLima.insertar(paquete);
                    break;
                case "PE-PIU":
                    rutaPiura.insertar(paquete);
                    break;
                case "PE-JUN":
                    rutaJunin.insertar(paquete);
                    break;
               case "PE-AYA":
                    rutaAyacucho.insertar(paquete);
                    break;
            }
            
            // se obtiene el siguiente paquete de la cola para su procesamiento
            paquete = almacenCentral.extraer();
            
        }
    }
    
    // Se muestran los detalles de los paquetes de las rutas
    public static void mostrandoRutas() {
        rutaLima.mostrar();
        rutaPiura.mostrar();
        rutaJunin.mostrar();
    }
    
    public static void ingresarPaquetes() {
        
        System.out.println("Cuantos paquetes va a ingresar al almacen?");
        int cantidad = sc.nextInt();
        
        for (int i = 0; i < cantidad; i++) {
            almacenCentral.insertar(crearPaquete());
            System.out.println("Paquete ingresado correctamenente!");
        }
    }
    
    public static Paquete crearPaquete() {
        
        System.out.println("Ingrese el codigo: ");
        int id = sc.nextInt();
        System.out.println("Ingrese el destino, PE-LIM, PE-PIU, LIM-JUN, LIM-AYA: ");
        String destino = sc.next().toUpperCase().trim();
        System.out.println("Ingrese la cantidad de piezas del paquete: ");
        int piezas = sc.nextInt();
        System.out.println("Ingrese el nombre del destinatario: ");
        String nombreDestinatario = sc.next();
        System.out.println("Ingrese el telefono del destinatario: ");
        String telefono = sc.next();
        System.out.println("Ingrese las medidas de paquete: ");
        System.out.println("Alto: ");
        int alto = sc.nextInt();
        System.out.println("Ancho: ");
        int ancho = sc.nextInt();
        System.out.println("Largo: ");
        int largo = sc.nextInt();
        
        return new Paquete(id, piezas, destino, nombreDestinatario, nombreDestinatario, alto, ancho, largo);
    }
    
    public static void crearPlanilla() {
        
        System.out.println("Ingrese el año de apertura");
        int año = sc.nextInt();
        
        System.out.println("Cuantos empleados va a registrar?");
        int cantidad = sc.nextInt();
        planilla = new Planilla(año, cantidad);
   
        for (int i = 0; i < cantidad; i++) {
            planilla.setEmpleado(crearEmpleado(), i);
            System.out.println("Datos creados correctamente!");
        }
        
    }
    
    public static Empleado crearEmpleado() {
        
        System.out.println("Ingrese el cargo, 1-Jefe, 2-Ruteador, 3-Operario: ");
        int cargo = sc.nextInt();

        System.out.println("Ingrese el codigo: ");
        int codigo = sc.nextInt();
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.next();
        System.out.println("Ingrese los apellidos: ");
        String apellidos = sc.next();
        System.out.println("Ingrese el tipo de documento DNI-CE-PTP: ");
        String tipoDoc = sc.next();
        System.out.println("Ingrese el numero de documento: ");
        String numDoc = sc.next();
        System.out.println("Ingrese el sueldo: ");
        double sueldo = sc.nextDouble();
        
        switch (cargo) {
            case 1:
                return new JefeAlmacen(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
            case 2:
                return new Ruteador(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
            default:
                return new OperadorAlmacen(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
        }
            
    }
    
}
