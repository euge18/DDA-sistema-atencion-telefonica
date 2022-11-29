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
public class ServicioSector {
    private ArrayList<Sector> sectores;
    private static ServicioSector instancia = null; //Singleton 
    
    public static ServicioSector getInstancia(){
       if(instancia == null){
           instancia = new ServicioSector();
       }
       return instancia;
    }
    
    private ServicioSector(){
        sectores = new ArrayList<>();
        //Agregar sectores
    }
}
