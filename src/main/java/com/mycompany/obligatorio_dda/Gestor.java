/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

/**
 *
 * @author Usuario
 */
public class Gestor implements ITipoCliente{
    private static float descuento = 0.7f; //30% se puede modificar

    @Override
    public float calcularCostoLlamada(Llamada llamada) {    
        //Hay que revisar el calculo del tiempo porque puede dar negativo
        int tiempoLlamada =(llamada.getHoraFin().getSecond()-llamada.getHoraAtencion().getSecond());
        float costoFijo = (float)Llamada.getCostoFijo();
        float costo = (tiempoLlamada * (costoFijo/2)) * descuento;
        if(costo<0){
            costo = 0;
        }
        return costo;
    }
    
}
