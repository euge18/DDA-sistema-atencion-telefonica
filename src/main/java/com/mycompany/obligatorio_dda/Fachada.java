/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zeek2
 */
public class Fachada implements IFachada, Observer{
    
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

    @Override
    public ArrayList<Llamada> obtenerLlamadas() throws RemoteException {
        return ServicioLlamada.getInstancia().obtenerLlamadas();
    }

    @Override
    public void agregarLlamada(Llamada llamada) throws RemoteException {
        ServicioLlamada.getInstancia().agregarLlamada(llamada);
    }

    @Override
    public Llamada obtenerLlamada(int idLlamada) throws RemoteException {
        return ServicioLlamada.getInstancia().obtenerLlamada(idLlamada);
    }

    @Override
    public ArrayList<Llamada> obtenerLlamadasTrabajador(int idTrabajador) throws RemoteException {
        return ServicioLlamada.getInstancia().obtenerLlamadasTrabajador(idTrabajador);
    }

    @Override
    public int calcularCantLlamadasTrabajador(int id) throws RemoteException {
       return ServicioLlamada.getInstancia().calcularCantLlamadasTrabajador(id);
    }

    @Override
    public ArrayList<Llamada> obtenerLlamadasSector(int numeroSector) throws RemoteException {
       return ServicioLlamada.getInstancia().obtenerLlamadasPorSector(numeroSector);
    }

    @Override
    public ArrayList<Sector> obtenerSectores() throws RemoteException {
       return ServicioSector.getInstancia().obtenerSectores();
    }

    @Override
    public Sector obtenerSector(int numeroSector) throws RemoteException {
        return ServicioSector.getInstancia().ObtenerSector(numeroSector);
    }

    @Override
    public ArrayList<Trabajador> obtenerTrabajares() throws RemoteException {
       return ServicioTrabajador.getInstancia().ObtenerTrabajadores();
    }

    @Override
    public ArrayList<Trabajador> obtenerTrabajadoresPorSector(int numeroSector) throws RemoteException {
       return ServicioTrabajador.getInstancia().ObtenerTrabajadoresPorSector(numeroSector);
    }

    @Override
    public Trabajador obtenerTrabajador(int idTrabajador) throws RemoteException {
       return ServicioTrabajador.getInstancia().ObtenerTrabajador(idTrabajador);
    }

    @Override
    public ArrayList<Puesto> obtenerPuestos() throws RemoteException {
       return ServicioPuesto.getInstancia().obtenerPuestos();
    }

    @Override
    public Puesto obtenerPuesto(int numeroPuesto) throws RemoteException {
       return ServicioPuesto.getInstancia().obtenerPuesto(numeroPuesto);
    }

    @Override
    public ArrayList<Cliente> obtenerClientes() throws RemoteException {
       return ServicioCliente.getInstancia().obtenerClientes();
    }

    @Override
    public Cliente obtenerCliente(int idCliente) throws RemoteException {
        return ServicioCliente.getInstancia().ObtenerCliente(idCliente);
    }

   
}

/*
import bio.apptaskshared.Evento;
import bio.apptaskshared.IFachada;
import bio.apptaskshared.IObserver;
import bio.apptaskshared.Tarea;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Fachada implements IFachada, Observer{
    private ArrayList<IObserver> observadores;
    
    public Fachada(){
        observadores = new ArrayList<>();
    }
    @Override
    public void agregarObserver(IObserver obs) throws RemoteException {
        observadores.add(obs);
        System.out.println("Agregado observador remoto a servidor");
    }
    
    public void notificarObservadors(Object o, Evento evt){
        for(IObserver io : observadores){
            try {
                io.actualizar(o, evt);
            } catch (RemoteException ex) {
                Logger.getLogger(Fachada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    @Override
    public ArrayList<Tarea> ObtenerTareasPendientes() throws RemoteException {
        return GestoraTareas.getInstance().ObtenerTareasIniciadas();
    }

    @Override
    public ArrayList<Tarea> ObtenerTareasFinalizadas() throws RemoteException {
        return GestoraTareas.getInstance().ObtenerTareasFinalizadas();
    }

    @Override
    public void AgregarTarea(String titulo) throws RemoteException {
        Tarea t = GestoraTareas.getInstance().agregarTarea(titulo);
        System.out.println("Llego tarea " + titulo + " a servidor" );
        t.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Ingreso update Fachada");
        if(arg instanceof Evento){
            notificarObservadors(null, (Evento)arg);
        }
    }
    
}
*/
