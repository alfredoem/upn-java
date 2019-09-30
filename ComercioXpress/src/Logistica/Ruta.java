package Logistica;

public class Ruta {
    
    private String nombre;
    private NodoPaquete raiz;

    public Ruta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void insertar(Paquete paquete) {
        
        NodoPaquete nuevo = new NodoPaquete(paquete);
        
        if (this.raiz == null) {
            nuevo.siguiente = null;
            this.raiz = nuevo;
        } else {
            nuevo.siguiente = this.raiz;
            this.raiz = nuevo;
        }
        
    }
    
    public Paquete extraer() {
        if (this.raiz != null) {
            Paquete paquete = this.raiz.paquete;
            this.raiz = this.raiz.siguiente;
            return paquete;
        } else {
            return null;
        }
    }
    
    public void mostrar() {
        System.out.println("\nMostrando descripcion de ruta: " + this.nombre);
        NodoPaquete nodo = raiz;
        
        while(nodo != null) {
            System.out.println(nodo.paquete.toString());
            nodo = nodo.siguiente;
        } 
    }
    
    public int contar() {
        return this.contarRec(this.raiz, 0);
    }
    
    public int contarRec(NodoPaquete raiz, int cantidad) {
        System.out.println(cantidad);
        if (raiz == null) {
            return cantidad;
        }
        
        return this.contarRec(raiz.siguiente, ++cantidad);
    }
    
}
