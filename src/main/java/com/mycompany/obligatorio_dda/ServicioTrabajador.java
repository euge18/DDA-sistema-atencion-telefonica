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
public class ServicioTrabajador {
    private ArrayList<Trabajador> trabajadores;
    private static ServicioTrabajador instancia = null; //Singleton 
    
    public static ServicioTrabajador getInstancia(){
       if(instancia == null){
           instancia = new ServicioTrabajador();
       }
       return instancia;
    }
    
    private ServicioTrabajador(){
        trabajadores = new ArrayList<>();
        //Agregar trabajadores
        //trabajadores.add(new Trabajador(1,"1122","123Demo","Juan",));
    }
    
    public ArrayList<Trabajador> ObtenerTrabajadores(){
        return trabajadores;
    }
    
    public ArrayList<Trabajador> ObtenerTrabajadoresPorSector(int numSector){
        ArrayList<Trabajador> trabajadoresPorSector = new ArrayList<>();
        for(Trabajador t : trabajadores){
            if(t.getSector().getNumeroSector() == numSector){
                trabajadoresPorSector.add(t);
            }
        }
        return trabajadoresPorSector;
    }
}
