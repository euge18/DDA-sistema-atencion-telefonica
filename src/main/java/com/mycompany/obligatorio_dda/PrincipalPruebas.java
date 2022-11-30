/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

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
      //Se pueden inicilizar como ArraysList vacias en los constructores o como aqui (que ya estan
      // precargados pero no asignados a sector)
      Sector sectorPrueba = SS.ObtenerSector(0);
      sectorPrueba.setPuestos(SP.ObtenerPuetosPorSector(sectorPrueba.getNumeroSector()));
      sectorPrueba.setTrabajadores(ST.ObtenerTrabajadoresPorSector(sectorPrueba.getNumeroSector()));
      for (Puesto p : sectorPrueba.getPuestos()){
          System.out.println("lista de puestos: " + p.getTrabajadorAsignado().getNombre());
      }
      
    }
}
