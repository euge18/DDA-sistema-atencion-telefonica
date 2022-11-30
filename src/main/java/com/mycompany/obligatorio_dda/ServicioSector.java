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
    
    public Sector ObtenerSector(int numSector){
        for(Sector s : sectores){
            if(s.getNumeroSector() == numSector){
                return s;
            }
        }
        return null;
    }
    
    public float calcularTiempoPromedioAtencionSector (int numeroSector){
        Sector s = ObtenerSector(numeroSector);
        int tiempoTotalAtencion = 0;
        for (Llamada l : s.getLlamadasFinalizadas()){
            tiempoTotalAtencion += (l.getHoraFin().getSecond() - l.getHoraAtencion().getSecond());
        }
        float promedio = tiempoTotalAtencion/s.getLlamadasFinalizadas().size();
        return promedio;
    }
    
}
