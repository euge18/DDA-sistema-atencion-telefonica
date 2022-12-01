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
    private static float descuento = 0.3f; //30% se puede modificar

    @Override
    public float calcularCostoLlamada(Llamada llamada) {
        int tiempoLlamada = (llamada.getHoraFin().getSecond()-llamada.getHoraAtencion().getSecond());
        float costo = (tiempoLlamada * (Llamada.getCostoFijo()/2)) * descuento;
        return costo;
    }
    
}
