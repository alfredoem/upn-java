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
    }
       
    public static void mostrarMenu() {
        System.out.println("**Menu de opciones**");
        System.out.println("0. Mostrar menu");
        System.out.println("1. Crear planilla");
        System.out.println("2. Editar datos de empleado");
        System.out.println("3. Mostrar empleados en planilla");
        System.out.println("4. Ingresar paquetes de productos al HUB");
        System.out.println("5. Crear Rutas de Entrega");
        System.out.println("6. Armado y pesado de piezas por ruta");
        System.out.println("7. Mostrar Reporte de Rutas");
        System.out.println("8. Poblar con datos de ejemplo");
        System.out.println("9. Salir");
    }
    
    public static void menu() {
        
        int opt = 0;
        mostrarMenu();
        
        while (opt != 9) {
            
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
                    aditarDatosEmpleado();
                    break;
                case 3:
                    planilla.mostrarPlanilla();
                    break;
                case 4:
                    ingresarPaquetes();
                    break;
                case 5:
                    creandoRutas();
                    break;
                case 6:
                    armadoRutasDeEntrega();
                    break;
                case 7:
                    mostrandoRutas();
                    break;
                case 8:
                    insertarDatosEjemplo();
                    break;
                case 9:
                    System.out.println("Gracias por usar el sistema...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
            
        }
        
    }
    
    public static boolean validarRutasCreadas() {
        
        boolean creada = true;
        
        if (almacenCentral.buscarRuta("PE-LIM") && rutaLima == null) {
            creada = false;
        } else if (almacenCentral.buscarRuta("PE-PIU") && rutaPiura == null) {
            creada = false;
        } else if (almacenCentral.buscarRuta("PE-JUN") && rutaJunin == null) {
            creada = false;
        } else if (almacenCentral.buscarRuta("PE-AYA") && rutaAyacucho == null) {
            creada = false;
        }
        
        return creada;
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
        
        System.out.println("*****Comenzando proceso de pesado de paquetes y armado de rutas de entrega...*****");
        
        if (planilla.getEmpleados() == null) {
            System.out.println("No hay empleados para inciar el proceso...");
            return;
        }
        
        System.out.println("*Reporte de actividades*");
        for (Empleado empleado : planilla.getEmpleados()) {
            System.out.println(empleado.getNombre() + ": ");
            empleado.trabajar();
        }
        
        if (validarRutasCreadas() == false) {
            System.out.println("Debe crear las rutas para continuar...");
            return;
        }
                
        // creación de objeto Cubicadora
        cubicadora = new Cubicadora();
        
        // se obteiene el primer paquete que ingreso al almacen
        Paquete paquete = almacenCentral.extraer();
        
        if (paquete == null) {
            System.out.println("No hay paquetes ingresados al HUB");
            return;
        }
        
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
        
        System.out.println("*Proceso de pesado de paquetes y armado finalizado...*");
    }
    
    // Se muestran los detalles de los paquetes de las rutas
    public static void mostrandoRutas() {
        System.out.println("*****Mostrando descripcion final de rutas y paquetes ramados*****");
        
        if (validarRutasCreadas() == false) {
            System.out.println("No hay rutas creadas...");
            return;
        }
        
        rutaLima.mostrar();
        rutaPiura.mostrar();
        rutaJunin.mostrar();
    }
    
    public static void ingresarPaquetes() {
        
        System.out.println("***** Ingreso de paquetes al HUB *****");
        
        System.out.println("Cuantos paquetes va a ingresar al almacen?");
        int cantidad = Integer.parseInt(sc.next());
        
        for (int i = 0; i < cantidad; i++) {
            almacenCentral.insertar(crearPaquete());
            System.out.println("Paquete ingresado correctamenente!");
        }
    }
    
    public static Paquete crearPaquete() {
        
        System.out.println("\nIngrese el codigo: ");
        int id = Integer.parseInt(sc.next());
        System.out.println("\nIngrese el destino, PE-LIM, PE-PIU, PE-JUN, PE-AYA: ");
        String destino = sc.next().toUpperCase().trim();
        System.out.println("\nIngrese la cantidad de piezas del paquete: ");
        int piezas = Integer.parseInt(sc.next());
        System.out.println("\nIngrese el nombre del destinatario: ");
        String nombreDestinatario = sc.next();
        System.out.println("\nIngrese el telefono del destinatario: ");
        String telefono = sc.next();
        System.out.println("\nIngrese las medidas de paquete: ");
        System.out.println("Alto: ");
        int alto = Integer.parseInt(sc.next());
        System.out.println("Ancho: ");
        int ancho = Integer.parseInt(sc.next());
        System.out.println("Largo: ");
        int largo = Integer.parseInt(sc.next());
        
        return new Paquete(id, piezas, destino, nombreDestinatario, telefono, alto, ancho, largo);
    }
    
    public static void crearPlanilla() {
        
        System.out.println("***** Creacion de Planilla *****");
        
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
    
    public static void insertarDatosEjemplo() {
        
        System.out.println("***** Insertando paquetes de ejemplo al HUB *****");
        
        // creacion de objetos Paquete con los datos basicos necesarios
        // para su procesamiento
        Paquete paquete1 = new Paquete(1, 4, "PE-LIM", "Adalbert Steiner", "985544111", 76, 32, 16);
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
        planilla = new Planilla(2019, 3);
        planilla.setEmpleado(new JefeAlmacen(1111, "Frank", "Jager", "DNI", "48154512", 3500), 0);
        planilla.setEmpleado(new JefeAlmacen(2222, "Leao", "Butron", "DNI", "48451212", 2500), 1);
        planilla.setEmpleado(new JefeAlmacen(3333, "Mirko", "Bucinic", "DNI", "78451245", 1500), 2);
        
        System.out.println("Datos de ejemplo creados...");
    }
    
    public static void aditarDatosEmpleado() {
        
        System.out.println("***** Edicion de Empleados *****");
        System.out.println("Ingrese el codigo:");
        int codigo = Integer.parseInt(sc.next());
        
        Empleado empleado = planilla.buscarEmpleado(codigo);
        
        if (empleado != null) {
            System.out.println("***** Actualizando empleado: " + empleado.getCodigo() + " - " + empleado.getNombre() + " *****");
            System.out.println("\nIngrese el cargo, 1-Jefe, 2-Ruteador, 3-Operario: ");
            int cargo = Integer.parseInt(sc.next());
            System.out.println("\nIngrese el nombre: ");
            String nombre = sc.next();
            System.out.println("\nIngrese los apellidos: ");
            String apellidos = sc.next();
            System.out.println("\nIngrese el tipo de documento DNI-CE-PTP: ");
            String tipoDoc = sc.next();
            System.out.println("\nIngrese el numero de documento: ");
            String numDoc = sc.next();
            System.out.println("\nIngrese el sueldo: ");
            double sueldo = Double.parseDouble(sc.next());
            
            switch (cargo) {
                case 1:
                    empleado = new JefeAlmacen(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
                    break;
                case 2:
                    empleado = new Ruteador(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
                    break;
                default:
                    empleado = new OperadorAlmacen(codigo, nombre, apellidos, tipoDoc, numDoc, sueldo);
                    break;
            }
            
            planilla.actualizarEmpleado(codigo, empleado);
            System.out.println("Empleado actualizado!");
            
            
        } else {
            System.out.println("El empleado con el codigo " + codigo + " no existe");
        }
        
    }    
}
