/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Servicios;

import com.mycompany.obligatorio_dda.Dominio.Entidades.Puesto;
import java.util.ArrayList;

/**
 *
 * @author zeek2
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
        puestos.add(new Puesto(0, true, ServicioTrabajador.getInstancia().obtenerTrabajador(0), ServicioSector.getInstancia().ObtenerSector(1)));
        puestos.add(new Puesto(1, false, ServicioTrabajador.getInstancia().obtenerTrabajador(1), ServicioSector.getInstancia().ObtenerSector(1)));

        puestos.add(new Puesto(2, true, ServicioTrabajador.getInstancia().obtenerTrabajador(2), ServicioSector.getInstancia().ObtenerSector(1)));
        puestos.add(new Puesto(3, false, ServicioTrabajador.getInstancia().obtenerTrabajador(3), ServicioSector.getInstancia().ObtenerSector(1)));

        puestos.add(new Puesto(4, true, ServicioTrabajador.getInstancia().obtenerTrabajador(4), ServicioSector.getInstancia().ObtenerSector(2)));
        puestos.add(new Puesto(5, false, ServicioTrabajador.getInstancia().obtenerTrabajador(5), ServicioSector.getInstancia().ObtenerSector(2)));
        //Agregar puestos
    }
    
    public ArrayList<Puesto> obtenerPuestos(){
        return puestos;
    }

    public ArrayList<Puesto> ObtenerPuetosPorSector(int numSector) {
        ArrayList<Puesto> puestosPorSector = new ArrayList<>();
        for (Puesto p : puestos) {
            if (p.getSector().getNumeroSector() == numSector) {
                puestosPorSector.add(p);
            }
        }
        return puestosPorSector;
    }
    
    public Puesto obtenerPuesto(int numeroPuesto){
        for (Puesto p : puestos){
            if(p.getNumeroPuesto() == numeroPuesto){
                return p;
            }
        }
        return null;
    }
}
