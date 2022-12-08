/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores.Mantenimientos;

import com.mycompany.obligatorio_dda.Controladores.Interfaces.IFachada;
import com.mycompany.obligatorio_dda.Controladores.Interfaces.VentanaMantMonitoreo;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Sector;
import com.mycompany.obligatorio_dda.Dominio.Fachada.Fachada;


/**
 *
 * @author zeek2
 */
public class MantMonitoreoController implements IFachada{
    
    private VentanaMantMonitoreo ventana;
    
    public MantMonitoreoController(VentanaMantMonitoreo ventana){
        this.ventana = ventana;
        this.ventana.mostrarLlamadas(Fachada.getInstancia().obtenerLlamadas());
        this.ventana.mostrarSectores(Fachada.getInstancia().obtenerSectores());
        Fachada.getInstancia().agregarObservador(this);
    }
    
    public VentanaMantMonitoreo getVentana() {
        return ventana;
    }

    public void setVentana(VentanaMantMonitoreo ventana) {
        this.ventana = ventana;
    }
    
    public void listarLlamadas() {
        Sector sectorSeleccionado = ventana.obtenerSectorSeleccionado();
        if (sectorSeleccionado == null) {
            //Que muestre todas las llamadas,  si las llamdas pendientes y rechazadas no deberian ir 
            //(porque literalmente va a traer todas) habira que hacer un metodo en el servicio que las filter
            //y que luego la fachada las ofrezca
            this.ventana.mostrarLlamadas(Fachada.getInstancia().obtenerLlamadas());
        } else if (sectorSeleccionado.getNumeroSector() == -1) {
            this.ventana.mostrarLlamadas(Fachada.getInstancia().obtenerLlamadas());
        } else {
            this.ventana.mostrarLlamadas(Fachada.getInstancia().obtenerLlamadasSector(sectorSeleccionado.getNumeroSector()));
        }
    }
     
     //Posiblemente nesecite hacer que mi monitoreo sea un observer de la fachada para que cuando se ejecute
     //alguna accion de interes sobre las llamadas (se agrego o cambio su estado) se actulize automaticamente 
     //los listados de llamdas
   

    @Override
    public void update(Fachada fachada) {
        listarLlamadas();
    }
}
