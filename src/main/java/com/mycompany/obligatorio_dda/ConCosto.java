/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

/**
 *
 * @author Usuario
 */
public class ConCosto implements ITipoCliente{

    @Override
    public float calcularCostoLlamada(Llamada llamada) {
        int tiempoLlamada =(llamada.getHoraFin().getSecond()-llamada.getHoraAtencion().getSecond());
        float costo;
        if(60>=(llamada.getHoraInicio().getSecond()-llamada.getHoraAtencion().getSecond())){
            costo = tiempoLlamada * Llamada.getCostoFijo();
            return costo;       
        } else {
            costo = tiempoLlamada * (Llamada.getCostoFijo()/2);
            return costo;
        }
    }
    
}
