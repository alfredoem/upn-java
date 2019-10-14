package com.mycompany.comercioxpressmaven;

// Rutas agrupadores de paquetes con un mismo destino
// Los paquetes son divididos en rutas que son apilados uno encima de otra
// y procesadas tomando el último paquete apilado (LIFO): Pilas
public class Ruta {
    
    private String nombre;
    // primer nodo paquete de los paquetes apilados
    private NodoPaquete raiz;
    
    // el constructor de la ruta requiere un nombre
    public Ruta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    // inserta un nodo paquete al inicio de la pila de paquetes
    public void insertar(Paquete paquete) {
        
        NodoPaquete nuevo = new NodoPaquete(paquete);
        
        // si el nodo incial de la pila es nulo
        if (this.raiz == null) {
            // la siguiente referencia del nuevo nodo se asigna como vacio
            nuevo.siguiente = null;
            // el nodo paquete incicial de la pila es el paquete a insertar
            this.raiz = nuevo;
        } else {// si la pila no esta vacia
            // se desplaza el nodo inicial
            // la siguiente referencia del nuevo nodo es el nodo inicial
            nuevo.siguiente = this.raiz;
            // el nuevo nodo pasa a ser el nuevo nodo paquete inicial
            this.raiz = nuevo;
        }
        
    }
    
    // eliminar un nodo paquete de la pila
    public void eliminar() {
        // si el nodo inicial de la pila no es nulo
        if (this.raiz != null) {
            // el segundo nodo paquete de la pila pasa a ser el primero
            this.raiz = this.raiz.siguiente;
        }
    }
    
    // obtener un nodo paquete de la pila
    public Paquete extraer() {
        // si el nodo paquete inicial de la pila no es nulo
        if (this.raiz != null) {
            // se obtiene el paquete del nodo inicial de la pila
            Paquete paquete = this.raiz.paquete;
            // el segundo nodo paquete de la pila pasa a ser el primero
            this.raiz = this.raiz.siguiente;
            // se retorna el paquete inicial de la pila
            return paquete;
        } else {// si la cola esta vacia retorna un valor nulo
            return null;
        }
    }
    
    // mostrar las propiedades de los paquetes de los nodos de la pila
    public void mostrar() {
        System.out.println("\nMostrando descripcion de ruta: " + this.nombre);
        // obtenemos el nodo inicial de la cola
        NodoPaquete nodo = raiz;
        
        // mientras que el nodo a contar no este vacio
        while(nodo != null) {
            // muestra las propiedades del paquete
            System.out.println(nodo.paquete.toString());
            // el nodo a evaluar es el siguiente de la pila
            nodo = nodo.siguiente;
        } 
    }
    
    // cuenta la cantidad de nodos de paquete de la pila
    public int contar() {
        // utiliza un metodo recursivo para el conteo, envia el primer
        // nodo de la pila y el contador en 0
        return this.contarRec(this.raiz, 0);
    }
    
    // metodo recursivo para contar nodos de la pila
    public int contarRec(NodoPaquete raiz, int cantidad) {
        // si el nodo es nulo, retorna la cantidad
        // si se llego al ultimo nodo o si la pila estavacia
        if (raiz == null) {
            return cantidad;
        }
        
        // retorna la cantidad de nodos de la pila
        // se utiliza el ++ a la izquierda para poder incrementar el contador
        // y enviarlo como argumento
        return this.contarRec(raiz.siguiente, ++cantidad);
    }
    
}
