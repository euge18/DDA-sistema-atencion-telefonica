/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.util.ArrayList;

/**
 *
 * @author zeek2
 */
public class PrincipalPruebas {

    public static void main(String[] args) {
        
      //Para que lo primero que hagan las instancias sea inicializar las listas   
      ServicioCliente SC = ServicioCliente.getInstancia();
      ServicioLlamada SL = ServicioLlamada.getInstancia();
      ServicioPuesto SP = ServicioPuesto.getInstancia();
      ServicioSector SS = ServicioSector.getInstancia();
      ServicioTrabajador ST = ServicioTrabajador.getInstancia();
      
      //Hay que tener cudado con las listas que sector nesecita de puestos y trabajadores
      //Se pueden inicilizar como ArraysList vacios en los constructores, o llamar a los servicios
      //de trabajador y puestos y pedirle sus listas por sector 
      Sector sectorPrueba = SS.ObtenerSector(0);
      sectorPrueba.setPuestos(SP.ObtenerPuetosPorSector(sectorPrueba.getNumeroSector()));
      sectorPrueba.setTrabajadores(ST.ObtenerTrabajadoresPorSector(sectorPrueba.getNumeroSector()));
      for (Puesto p : sectorPrueba.getPuestos()){
          System.out.println("lista de puestos: " + p.getTrabajadorAsignado().getNombre());
      }
      
      ArrayList<Cliente> clientes = SC.obtenerClientes();
      for (Cliente c : clientes){
          System.out.println("Cliente: " + c.getNombreCompleto() + " " + c.getCedula() + " " + c.getTipo());
      }
      
      //Alision Bekar
      Cliente clientePrueba = SC.obtenerCliente(0);
      System.out.println(clientePrueba.getNombreCompleto());
      
      //llama a Adimnistracion
      //Hasta este punto bien, Sector la recibe y deriva al puesto correspondiente
      clientePrueba.hacerLlmada(0);
      
      //el puesto libre en Administracion es el 0 atendido por Pablo Estigarribia
      Puesto puestoPrueba = SP.obtenerPuesto(0);
      Llamada llamada= puestoPrueba.getLlamadaEnAtencion();
        System.out.println("Datos: " + llamada.getIdLlamada() + " " + llamada.getEstado() + " " + llamada.getTrabajador().getNombre() + " " + llamada.getCliente().getNombreCompleto() + " " + llamada.getHoraAtencion());
      

      
    }
}
