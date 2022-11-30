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
        sectores.add(new Sector(0, "Administración"));
        sectores.add(new Sector(1, "Ventas"));
        sectores.add(new Sector(2, "Desarrollo"));
    }
    
    public Sector ObtenerSector(int numSector){
        for(Sector s : sectores){
            if(s.getNumeroSector() == numSector){
                return s;
            }
        }
        return null;
    }
    
}
