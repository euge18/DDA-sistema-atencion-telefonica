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
    
    public void agregarLlamada (Llamada llamda){
        ++ultimoIdLlamada;
        llamda.setIdLlamada(ultimoIdLlamada);
        llamadas.add(llamda);
    }
    
    public Llamada obtenerLlamada(int id){
        for(Llamada l : llamadas){
            if (l.getIdLlamada()==id){
                return l;
            }
        }
        return null;
    }
    
    public ArrayList<Llamada> obtenerLlamadas(){
        return llamadas;
    }
    
    public ArrayList<Llamada> obtenerLlamadasTrabajador(int idTrabajador){
        ArrayList<Llamada> llamadasTrabajador = new ArrayList<Llamada>();
        for (Llamada l : llamadas){
            if (l.getTrabajador().getIdTrabajador()==idTrabajador){
                llamadasTrabajador.add(l);
            }
        }
        return llamadasTrabajador;
    }
    
    public int calcularCantLlamadasTrabajador(int idTrabajador) {
        int cantLlamadas = 0;
        for (Llamada l : llamadas) {
            if (l.getTrabajador().getIdTrabajador() == idTrabajador) {
                ++cantLlamadas;
            }
        }
        return cantLlamadas;
    }
    
    public ArrayList<Llamada> obtenerLlamadasPorSector(int numeroSector){
        ArrayList<Llamada> llamadasSector = new ArrayList<Llamada>();
        for(Llamada l : llamadas){
            if (l.getSector().getNumeroSector()==numeroSector){
                llamadasSector.add(l);
            }
        }
        return llamadasSector;
    }
}
