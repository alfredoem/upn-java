package com.mycompany.comercioxpressmaven;

// Maquina que permite realizar mediciones y calculo de peso de un paquete
public class Cubicadora {
    
    // contante que indica un divisor estandar para el calcullo 
    // de peso volumetrico de paquetes
    private final int divisorVolumetrico = 5000;
    
    // retorna el resultado de la formula de calculo de peso volumetrico
    public double calcularPesoVolumetrico(int alto, int ancho, int largo) {
        System.out.println("Calculando peso volumetrico de: " + largo +"x"+ ancho +"x"+ alto);
        return (largo*ancho*alto)/this.divisorVolumetrico;
    }
    
}
