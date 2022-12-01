/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author zeek2
 */
public class PrincipalPruebas{

    public static void main(String[] args){
        
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
      //Funciona bien
      Puesto puestoPrueba = SP.obtenerPuesto(0);
      Llamada llamada= puestoPrueba.getLlamadaEnAtencion();
      System.out.println("Datos: " + llamada.getIdLlamada() + " " + llamada.getEstado() + " " + llamada.getTrabajador().getNombre() + " " + llamada.getCliente().getNombreCompleto() + " " + llamada.getHoraAtencion());
      
      //Ahora voy a ver si puedo dejar 10 segundos con un Thread para el posterior calculo del costo
      
        
        //Aqui deberia deberia estar Sector observando
        //Quize hacer un for pero no da datos el tipo de la interfaz
        System.out.println("Observadores de esta llamada: " + llamada.getObservadores().size());
        
        System.out.println("Estado Llamada: " + llamada.getEstado());
        
        //Tanto cliente como puesto pueden finalizar la llamada el caso es que se rompe en la notificacion del observer
        clientePrueba.finalizarLlamda(llamada);
        //puestoPrueba.finalizarLlamada(llamada);      
        System.out.println("Estado Llamada: " + llamada.getEstado()); 
        //Aqui Sector ya deberia haberse removido como observador
        System.out.println("Observadores de esta llamada: " + llamada.getObservadores().size());
        
        //CALCULO COSTO LLAMADA
        
        //clientePrueba es de tipo ConCosto
        Cliente clienteExonerado = SC.obtenerCliente(1);
        Cliente clienteGestor = SC.obtenerCliente(2);

        
        Llamada llamadaPruebaCosto = new Llamada(EstadoLLamada.FINALIZADA , LocalDateTime.now(),  clientePrueba);
        llamadaPruebaCosto.setIdLlamada(7);
        llamadaPruebaCosto.setDescripcion("Esta es una descripcion de Prueba");
        llamadaPruebaCosto.setPuesto(puestoPrueba);
        llamadaPruebaCosto.setTrabajador(puestoPrueba.getTrabajadorAsignado());
        llamadaPruebaCosto.setSector(sectorPrueba);
        
        
        System.out.println("Datos: " + llamadaPruebaCosto.getEstado() + " " + llamadaPruebaCosto.getCliente().getNombreCompleto() + " " + llamadaPruebaCosto.getHoraInicio());
        
        int respuesta = 1;
        while(respuesta != 0){
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Presione 0 para atender la llamda"));
            llamadaPruebaCosto.setHoraAtencion(LocalDateTime.now());
        }
        
        while (respuesta != 1) {
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Presione 1 para finalizar la llamda"));
            llamadaPruebaCosto.setHoraFin(LocalDateTime.now());
        }
        
        
        System.out.println("Hora atencion: " + llamadaPruebaCosto.getHoraAtencion().toString());
        System.out.println("Hora atencion: " + llamadaPruebaCosto.getHoraFin().toString());
        
        System.out.println("El costo de la llamda fue de: " + llamadaPruebaCosto.calcularCosto(llamadaPruebaCosto));
        //float costo = llamadaPruebaCosto.calcularCosto();
        //llamadaPruebaCosto.setCosto(llamadaPruebaCosto.calcularCosto());
    }

}
