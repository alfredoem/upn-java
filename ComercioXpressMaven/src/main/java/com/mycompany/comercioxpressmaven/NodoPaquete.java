package com.mycompany.comercioxpressmaven;

// Nodo que almacena como dato un paquete y guarda una referencia
// del siguiente nodo de la pila o cola
public class NodoPaquete {
    
    // elemento paquete del nodo
    Paquete paquete;
    // siguiente elemento nodo paquete
    NodoPaquete siguiente;
    
    // constructor del nodo paquete, requiere un paquete
    // el siguiente nodo paquete por defecto es nulo
    public NodoPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}
