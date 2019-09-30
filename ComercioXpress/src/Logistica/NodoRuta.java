package Logistica;

public class NodoRuta {
    
    Paquete paquete;
    NodoRuta siguiente;

    public NodoRuta(Paquete paquete) {
        this.paquete = paquete;
    }
    
}
