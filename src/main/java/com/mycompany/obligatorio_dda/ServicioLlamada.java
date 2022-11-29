/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ServicioLlamada {
    private static int ultimoIdLlamada;
    
    private ArrayList<Llamada> llamadas;
    private static ServicioLlamada instancia = null; //Singleton 
    
    public static ServicioLlamada getInstancia(){
       if(instancia == null){
           instancia = new ServicioLlamada();
       }
       return instancia;
    }
    
    private ServicioLlamada(){
        llamadas = new ArrayList<>();
        ultimoIdLlamada = 0;
    }
}
