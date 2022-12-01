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
        
        long momentoAtencion = CalculadoraFechas.calcularMilisegundos(llamada.getHoraAtencion().getYear(), llamada.getHoraAtencion().getMonthValue(), llamada.getHoraAtencion().getDayOfMonth(), llamada.getHoraAtencion().getHour(), llamada.getHoraAtencion().getMinute(), llamada.getHoraAtencion().getSecond());
        long momentoFin = CalculadoraFechas.calcularMilisegundos(llamada.getHoraFin().getYear(), llamada.getHoraFin().getMonthValue(), llamada.getHoraFin().getDayOfMonth(), llamada.getHoraFin().getHour(), llamada.getHoraFin().getMinute(), llamada.getHoraFin().getSecond());

        long difernciaTiempo = CalculadoraFechas.calcularDiferenciaDeTiempo(momentoAtencion, momentoFin);
        
        float costoFijo = (float)Llamada.getCostoFijo();
        float costo;
        if(60>=difernciaTiempo){
            costo = difernciaTiempo * costoFijo;
            llamada.setCosto(costo);
            return costo;       
        } else {
            costo = (float)difernciaTiempo * (costoFijo/2);
            llamada.setCosto(costo);
            return costo; 
        }
    }
}
