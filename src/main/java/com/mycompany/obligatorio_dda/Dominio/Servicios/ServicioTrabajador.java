/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Servicios;

import com.mycompany.obligatorio_dda.Dominio.Entidades.Trabajador;
import java.util.ArrayList;

/**
 *
 * @author zeek2
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

        trabajadores.add(new Trabajador(0, "111", "123", "Pablo Estigarribia", ServicioSector.getInstancia().ObtenerSector(1)));
        trabajadores.add(new Trabajador(1, "222", "123", "Marcela Lopez", ServicioSector.getInstancia().ObtenerSector(1)));
        trabajadores.add(new Trabajador(6, "777", "123", "Jhonatan Suarez", ServicioSector.getInstancia().ObtenerSector(1)));

        trabajadores.add(new Trabajador(2, "333", "123", "Eloisa Perez", ServicioSector.getInstancia().ObtenerSector(2)));
        trabajadores.add(new Trabajador(3, "444", "123", "Tadeo Molina", ServicioSector.getInstancia().ObtenerSector(2)));

        trabajadores.add(new Trabajador(4, "555", "123", "Gabriela Mendez", ServicioSector.getInstancia().ObtenerSector(3)));
        trabajadores.add(new Trabajador(5, "666", "123", "Rueben Nubes", ServicioSector.getInstancia().ObtenerSector(3)));
    }
    
    public ArrayList<Trabajador> ObtenerTrabajadores(){
        return trabajadores;
    }
    
    public Trabajador obtenerTrabajador(int idTrabajador){
        for(Trabajador t : trabajadores){
            if(t.getIdTrabajador()== idTrabajador){
                return t;
            }
        }
        return null;
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
    
    public Trabajador obtenerTrabajadorLogin(String ci, String pass){
        for(Trabajador t : trabajadores){
            if(t.getCedula().equals(ci) && t.getPass().equals(pass) ){
                return t;
            }
        }
        return null;
    }
    
}
