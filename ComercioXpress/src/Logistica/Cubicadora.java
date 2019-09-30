package Logistica;

public class Cubicadora {
    
    private final int divisorVolumetrico = 5000;
    
    public double calcularPesoVolumetrico(int alto, int ancho, int largo) {
        System.out.println("Calculando peso volumetrico de: " + largo +"x"+ ancho +"x"+ alto);
        return (largo*ancho*alto)/this.divisorVolumetrico;
    }
    
}
