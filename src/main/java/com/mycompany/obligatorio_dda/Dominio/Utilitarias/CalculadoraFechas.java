/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Utilitarias;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author zeek2
 */
public class CalculadoraFechas {
    public static long calcularMilisegundos(int anio, int mes, int dia, int hora, int minuto, int segundo) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(anio, mes, dia, hora, minuto, segundo);
        return calendario.getTimeInMillis();
    }

    public static long calcularDiferenciaDeTiempo(long atencion, long fin) {

        long diferenciaMilisegundos = Math.abs(atencion - fin);

        return TimeUnit.MILLISECONDS.toSeconds(diferenciaMilisegundos);
    }
}
