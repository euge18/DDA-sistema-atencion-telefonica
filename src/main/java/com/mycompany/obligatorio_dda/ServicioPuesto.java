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
public class ServicioPuesto {
    private ArrayList<Puesto> puestos;
    private static ServicioPuesto instancia = null; //Singleton 
    
    public static ServicioPuesto getInstancia(){
       if(instancia == null){
           instancia = new ServicioPuesto();
       }
       return instancia;
    }
    
    private ServicioPuesto(){
        puestos = new ArrayList<>();
        //Agregar puestos
    }
}
