package Logistica;

public class NodoPaquete {
    
    Paquete paquete;
    NodoPaquete siguiente;

    public NodoPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}
