package Logistica;


public class Almacen {
    
    NodoPaquete inicio; 
    NodoPaquete fin; 
    
    public void insertar(Paquete paquete) {
        
        NodoPaquete nuevo = new NodoPaquete(paquete);
        nuevo.paquete = paquete;
        nuevo.siguiente = null;
        
        if (this.estaVacio()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.siguiente = nuevo;
            this.fin = nuevo;
        }
    }
    
    public Paquete extraer() {
        if (this.estaVacio()) {
            return null;
        }
        
        Paquete paquete = this.inicio.paquete;
        
        if (this.inicio == this.fin) {
            this.inicio = null;
            this.fin = null;
        } else {
            this.inicio = this.inicio.siguiente;
        }
        
        return paquete;
    }
    
    public boolean estaVacio() {
        if (this.inicio == null && this.fin == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public int contar() {
        int contador = 0;
        NodoPaquete nodo = this.inicio;
        
        while (nodo != null) {
            contador++;
            nodo = nodo.siguiente;
        }
        
        return contador;
    }
    
    public void mostrar() {
        NodoPaquete nodo = this.inicio;
        while (nodo != null) {            
            System.out.println(nodo.paquete.toString());
            nodo = nodo.siguiente;
        }
    }
    
    public boolean buscarRuta(String codigoDestino) {
        boolean existeCodigo = false;
        NodoPaquete nodo = this.inicio;
        
        while (nodo != null) {            
            if (codigoDestino.equals(nodo.paquete.getCodigoDestino())) {
                existeCodigo = true;
                break;
            } else {
                nodo = nodo.siguiente;
            }
        }
        
        return existeCodigo;
    }
    
}
