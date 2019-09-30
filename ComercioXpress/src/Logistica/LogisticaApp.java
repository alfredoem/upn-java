package Logistica;

public class LogisticaApp {
    
    // Principales rutas de transportistas
    static Ruta rutaLima;
    static Ruta rutaPiura;
    static Ruta rutaJunin;
    static Ruta rutaAyacucho;
    static Almacen almacenCentral;
    // Cubicadora para el calculo de peso volumetrico
    static Cubicadora cubicadora;

    public static void main(String[] args) {
        
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
        
        System.out.println("***Almacen Central de ComercioXpress*****");
        
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
        mostrandoRutas();
    }
    
    // creación de objetos Ruta
    public static void creandoRutas() {
        
        // se busca si existe un paquete con destino en el almacen
        // PE-LIM para crear la ruta
        if (almacenCentral.buscarRuta("PE-LIM")) {
            rutaLima = new Ruta("PE-LIM");
            System.out.println("Se creo la ruta PE-LIM");
        }
        
        // se busca si existe un paquete con destino en el almacen
        // PE-PIU para crear la ruta
        if (almacenCentral.buscarRuta("PE-PIU")) {
            rutaPiura = new Ruta("PE-PIU");
            System.out.println("Se creo la ruta PE-PIU");
        }
        
        // se busca si existe un paquete con destino en el almacen
        // PE-JUN para crear la ruta
        if (almacenCentral.buscarRuta("PE-JUN")) {
            rutaJunin = new Ruta("PE-JUN");
            System.out.println("Se creo la ruta PE-JUN");
        }
        
        // se busca si existe un paquete con destino en el almacen
        // PE-AYA para crear la ruta
        if (almacenCentral.buscarRuta("PE-AYA")) {
            rutaAyacucho = new Ruta("PE-AYA");
            System.out.println("Se creo la ruta PE-AYA");
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
    
}
