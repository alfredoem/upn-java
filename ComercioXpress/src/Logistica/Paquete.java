package Logistica;


public class Paquete {
    
    private int id;
    private int catidadPiezas;
    private String codigoDestino;
    private String nombreDestinatario;
    private String telefonoDestinatario;
    private int alto;
    private int ancho;
    private int largo;
    private double pesoVolumetrico;

    public Paquete(int id, int catidadPiezas, String codigoDestino, String nombreDestinatario, String telefonoDestinatario, int alto, int ancho, int largo) {
        this.id = id;
        this.catidadPiezas = catidadPiezas;
        this.codigoDestino = codigoDestino;
        this.nombreDestinatario = nombreDestinatario;
        this.telefonoDestinatario = telefonoDestinatario;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }

    public int getId() {
        return id;
    }
    
    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }
    
    public String getCodigoDestino() {
        return codigoDestino;
    }

    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public double getPesoVolumetrico() {
        return this.pesoVolumetrico;
    }

    public void setPesoVolumetrico(double pesoVolumetrico) {
        this.pesoVolumetrico = pesoVolumetrico;
    }

    @Override
    public String toString() {
        return "Paquete {" + "\nID=" + this.id + "\ncodigoDestino=" + this.codigoDestino + ", \nnombreDestinatario=" + this.nombreDestinatario + ", \ntelefonoDestinatario=" + this.telefonoDestinatario + ", \npesoVolumetrico=" + this.pesoVolumetrico + "\n}";
    }
    
    
}
