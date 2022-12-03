/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Fachada;

import com.mycompany.obligatorio_dda.Dominio.Entidades.*;
import com.mycompany.obligatorio_dda.Dominio.Servicios.*;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */


//Arreglar Fachada y Aplicarle un Patron Observer para que los Controlers lo usen

public class Fachada {
    
    
     private static Fachada instancia = null; //Singleton 
    
    public static Fachada getInstancia(){
       if(instancia == null){
           instancia = new Fachada();
       }
       return instancia;
    }
    
    private Fachada(){
        
    }
    
    public ArrayList<Llamada> obtenerLlamadas() {
        return ServicioLlamada.getInstancia().obtenerLlamadas();
    }

    public void agregarLlamada(Llamada llamada) {
        ServicioLlamada.getInstancia().agregarLlamada(llamada);
    }

    public Llamada obtenerLlamada(int idLlamada) {
        return ServicioLlamada.getInstancia().obtenerLlamada(idLlamada);
    }

    public ArrayList<Llamada> obtenerLlamadasTrabajador(int idTrabajador) {
        return ServicioLlamada.getInstancia().obtenerLlamadasTrabajador(idTrabajador);
    }

    public int calcularCantLlamadasTrabajador(int id) {
       return ServicioLlamada.getInstancia().calcularCantLlamadasTrabajador(id);
    }

    public ArrayList<Llamada> obtenerLlamadasSector(int numeroSector) {
       return ServicioLlamada.getInstancia().obtenerLlamadasPorSector(numeroSector);
    }

    public ArrayList<Sector> obtenerSectores() {
       return ServicioSector.getInstancia().obtenerSectores();
    }

    public Sector obtenerSector(int numeroSector) {
        return ServicioSector.getInstancia().ObtenerSector(numeroSector);
    }

    public ArrayList<Trabajador> obtenerTrabajares() {
       return ServicioTrabajador.getInstancia().ObtenerTrabajadores();
    }

    public ArrayList<Trabajador> obtenerTrabajadoresPorSector(int numeroSector) {
       return ServicioTrabajador.getInstancia().ObtenerTrabajadoresPorSector(numeroSector);
    }

    public Trabajador obtenerTrabajador(int idTrabajador) {
       return ServicioTrabajador.getInstancia().obtenerTrabajador(idTrabajador);
    }

    public ArrayList<Puesto> obtenerPuestos() {
       return ServicioPuesto.getInstancia().obtenerPuestos();
    }

    public Puesto obtenerPuesto(int numeroPuesto) {
       return ServicioPuesto.getInstancia().obtenerPuesto(numeroPuesto);
    }

    public ArrayList<Cliente> obtenerClientes() {
       return ServicioCliente.getInstancia().obtenerClientes();
    }

    public Cliente obtenerCliente(int idCliente) {
        return ServicioCliente.getInstancia().ObtenerCliente(idCliente);
    }
 
    /*
    private ArrayList<IObserverRemoto> observadores;
    
    public Fachada(){
        observadores = new ArrayList<>();
    }
    
    @Override
    public void agregarObserverRemoto(IObserverRemoto obs) throws RemoteException {
        observadores.add(obs);
        System.out.println("Agregado observador remoto a servidor");
    }
    
    public void notificarObservadoresRemotos(Object o, Evento evt){
        for(IObserverRemoto io : observadores){
            try {
                io.actualizar(o, evt);
            } catch (RemoteException ex) {
                Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Ingreso update Fachada");
        if (arg instanceof Evento) {
            notificarObservadoresRemotos(null, (Evento) arg);
        }
    }
    */
   
}
