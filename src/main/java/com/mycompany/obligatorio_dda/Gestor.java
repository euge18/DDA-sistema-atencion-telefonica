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

    @Override
    public float calcularCostoLlamada(Llamada llamada) { 
 
        long momentoInicial = CalculadoraFechas.calcularMilisegundos(llamada.getHoraInicio().getYear(), llamada.getHoraInicio().getMonthValue(), llamada.getHoraInicio().getDayOfMonth(), llamada.getHoraInicio().getHour(), llamada.getHoraInicio().getMinute(), llamada.getHoraInicio().getSecond());
        long momentoAtencion = CalculadoraFechas.calcularMilisegundos(llamada.getHoraAtencion().getYear(), llamada.getHoraAtencion().getMonthValue(), llamada.getHoraAtencion().getDayOfMonth(), llamada.getHoraAtencion().getHour(), llamada.getHoraAtencion().getMinute(), llamada.getHoraAtencion().getSecond());
        long momentoFin = CalculadoraFechas.calcularMilisegundos(llamada.getHoraFin().getYear(), llamada.getHoraFin().getMonthValue(), llamada.getHoraFin().getDayOfMonth(), llamada.getHoraFin().getHour(), llamada.getHoraFin().getMinute(), llamada.getHoraFin().getSecond());
        
        long tiempoDemora = CalculadoraFechas.calcularDiferenciaDeTiempo(momentoInicial, momentoAtencion);
        long difernciaTiempo = CalculadoraFechas.calcularDiferenciaDeTiempo(momentoAtencion, momentoFin);
        
        float demora;
        demora = (float)tiempoDemora;
        demora *= 0.8;
        
        float costoFijo = (float)Llamada.getCostoFijo()/2;
        float costo;
        
        if (difernciaTiempo >= 180) {
            costo = difernciaTiempo * costoFijo;
            llamada.setCosto(costo);
            return costo;
        } else {
            costo = ((float) difernciaTiempo * costoFijo) - demora;
            if (costo < 0) {
                costo = 0;
            }
            llamada.setCosto(costo);
            return costo;
        }
    }
    
}
