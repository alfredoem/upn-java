package com.mycompany.comercioxpressmaven;

// Almacen donde son recibidos los paquetes que recojen los transportistas
// para su porterior envio al destinatario
// El almacen debe procesar los paquetes en el orden de ingreso (FIFO): Colas
public class Almacen {
    
    // elemento inicial de la cola
    NodoPaquete inicio; 
    
    // elemento final de la cola
    NodoPaquete fin; 
    
    // agregar un elemento al final de la cola
    public void insertar(Paquete paquete) {
        
        NodoPaquete nuevo = new NodoPaquete(paquete);
        nuevo.paquete = paquete;
        nuevo.siguiente = null;
        
        // si la cola esta vacia el elemento inicial 
        // y final sera el nuevo nodo paquete
        if (this.estaVacio()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else { // si la cola no esta vacia
            // el nuevo nodo paquete es insertado al final de la cola
            this.fin.siguiente = nuevo;
            this.fin = nuevo;
        }
    }
    
    // actualizar un paquete de la cola, buscandolo por ID
    public void actualizar(int id, Paquete paquete) {
        
        // obtenemos el nodo paquete inicial para comenzar la busqueda
        NodoPaquete nodo = this.inicio;
        
        // mientras que el nodo paquete no sea el último
        while (nodo != null) {
            // si el ID buscado es igual al ID del paquete de un nodo
            if (id == nodo.paquete.getId()) {
                // se reemplaza el paquete del nodo por el nuevo paquete
                nodo.paquete = paquete;
                // sale del bucle
                break;
            } else {// si no encuentra el paquete
                // el nodo a evaluar pasa a ser el siguiente en la cola
                nodo = nodo.siguiente;
            }
        }
        
    }
    
    // extraer un paquete de la cola
    public Paquete extraer() {
        
        // si la cola esta vacia no continua el proceso
        if (this.estaVacio()) {
            return null;
        }
        
        // obtenemos el paquete del nodo inicial de la cola
        Paquete paquete = this.inicio.paquete;
        
        // si el nodo inicial y final es igual
        if (this.inicio == this.fin) {
            // se asignan valores nulos a los nodos, ya que el nodo
            // a extraer es el ultimo de la cola
            this.inicio = null;
            this.fin = null;
        } else {// si no es el último nodo
            // el nuevo nodo incial pasa a ser siguiente de la cola
            this.inicio = this.inicio.siguiente;
        }
        
        // se retorna paquete extraido de la cola
        return paquete;
    }
    
    // comprueba si la cola esta vacia
    public boolean estaVacio() {
        // si el elemento incial y final no existe
        if (this.inicio == null && this.fin == null) {
            return true;
        } else {
            return false;
        }
    }
    
    // cuenta la cantidad de nodos de paquetes de la cola
    public int contar() {
        int contador = 0;
        // obtenemos el nodo inicial de la cola
        NodoPaquete nodo = this.inicio;
        
        // mientras que el nodo a contar no este vacio
        while (nodo != null) {
            // incrementamos el contador en 1
            contador++;
            // el nodo a evaluar es el siguiente de la lista
            nodo = nodo.siguiente;
        }
        
        // se retorna el contador
        return contador;
    }
    
    // mostrar las propiedades de los paquetes de los nodos de la cola
    public void mostrar() {
        
        // obtenemos el nodo inicial de la cola
        NodoPaquete nodo = this.inicio;
        
        // mientras que el nodo a contar no este vacio
        while (nodo != null) {
            // muestra las propiedades del paquete
            System.out.println(nodo.paquete.toString());
            // el nodo a evaluar es el siguiente de la cola
            nodo = nodo.siguiente;
        }
    }
    
    // busca si existe por lo menos un paquete para el destino buscado
    public boolean buscarRuta(String codigoDestino) {
        boolean existeCodigo = false;
        
        // obtenemos el nodo inicial de la cola
        NodoPaquete nodo = this.inicio;
        
        // mientras que el nodo a evaluar no este vacio
        while (nodo != null) {    
            // si el codigo de destino del paquete es igual al codigo buscado
            if (codigoDestino.equals(nodo.paquete.getCodigoDestino())) {
                // existe por lo menos un paquete con el destino
                existeCodigo = true;
                // salimos del bucle
                break;
            } else {// si no lo encuentra
                // el nodo a evaluar es el siguiente de la cola
                nodo = nodo.siguiente;
            }
        }
        
        // retornamos un booleano que indica si existe un elemento encontrado
        return existeCodigo;
    }
    
}
