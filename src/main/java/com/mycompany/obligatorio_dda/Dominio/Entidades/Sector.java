/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Entidades;

import com.mycompany.obligatorio_dda.Dominio.Repositorios.*;
import com.mycompany.obligatorio_dda.Dominio.Servicios.*;
import com.mycompany.obligatorio_dda.Dominio.Utilitarias.CalculadoraFechas;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */
public class Sector implements IObserverLlamada {
    
    private int numeroSector;
    private String nombre;
    private ArrayList<Puesto> puestos;
    private ArrayList<Llamada> llamadasEspera;
    private ArrayList<Llamada> llamadasFinalizadas;
    private ArrayList<Trabajador> trabajadores;
    private ArrayList<IObserversSector> observadores;

    public Sector(int numeroSector, String nombre) {
        this.numeroSector = numeroSector;
        this.nombre = nombre;
        llamadasEspera = new ArrayList<Llamada>();
        llamadasFinalizadas = new ArrayList<Llamada>();
        puestos = new ArrayList<Puesto>();
        trabajadores = new ArrayList<Trabajador>();
        observadores = new ArrayList<IObserversSector>();
    }

    public int getNumeroSector() {
        return numeroSector;
    }

    public void setNumeroSector(int numeroSector) {
        this.numeroSector = numeroSector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(ArrayList<Puesto> puestos) {
        this.puestos = puestos;
    }

    public ArrayList<Llamada> getLlamadasEspera() {
        return llamadasEspera;
    }

    public void setLlamadasEspera(ArrayList<Llamada> llamadasEspera) {
        this.llamadasEspera = llamadasEspera;
    }

    public ArrayList<Llamada> getLlamadasFinalizadas() {
        return llamadasFinalizadas;
    }

    public void setLlamadasFinalizadas(ArrayList<Llamada> llamadasFinalizadas) {
        this.llamadasFinalizadas = llamadasFinalizadas;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    public Puesto obtenerPuestoTrabajador(Trabajador trabajador){
        for (Puesto p : puestos) {
            if (p.getTrabajadorAsignado().equals(trabajador)) {
                return p;
            }
        }
        return null;
    }
    
    public boolean asignarTrabajadorLibre(Trabajador trabajador) {
        for (Puesto p : puestos) {
            if (p.isActivo() == false) {
                p.setActivo(true);
                p.setTrabajadorAsignado(trabajador);
                return true;
            }
        }
        return false;
    }
    
        public boolean puestosLibres() {
            
        int puestoLibre = 0;
        for (Puesto p : puestos) {
            if (p.isActivo() == true) {
                ++puestoLibre;

            }
        }
        if(puestoLibre>0){
            return false;
        } else {
            return true;
        } 
    }
        
        
    
    public void dejarPuesto (Puesto puesto){
        puesto.setActivo(false);
        puesto.setTrabajadorAsignado(null);
    }
    
    //calcular timepo segun la lista de llamadas finalizadas
    public float calcularTiempoPromedioAtencion (){
        float timepoTotalAtencion = 0;
        for(Llamada l : llamadasFinalizadas){
            timepoTotalAtencion += (l.getHoraAtencion().getSecond()-l.getHoraFin().getSecond());
        }
        return timepoTotalAtencion/puestos.size();
    }
    
    public void recibirLlamada (Llamada llamada){
            if (llamadasEspera.size() <= 5) {
                derivarLlamadaAPuesto(llamada);
            } else {
                llamada.setEstado(EstadoLLamada.RECHAZADA);
            }
    }
    
    public void derivarLlamadaAPuesto(Llamada llamada) {
            Puesto puestoLibre = obtenerPuestoLibre();
            if (puestoLibre != null) {
                puestoLibre.atenderLlamada(llamada);
                llamada.setSector(this);
                llamada.agregarObservador(this);
                llamadasEspera.remove(llamada);
                //vuelvo a notificar y si en el update no encuentro la llamda en la lista me remuevo como observador
                notifiacearObservers();
            } else {
                llamada.setEstado(EstadoLLamada.ESPERA);
                llamadasEspera.add(llamada); 
                notifiacearObservers();
            }
    }
    
    public void notifiacearObservers() {
        ArrayList<IObserversSector> copiaListaObservadores = (ArrayList<IObserversSector>) observadores.clone();
        for (IObserversSector o : copiaListaObservadores) {
            o.update(this);
        }
    }
    
    public void agregarObservador (IObserversSector o){
        observadores.add(o);
    }
    
    public void removerObservador (IObserversSector o){
        observadores.remove(o);
    }
    
    public Puesto obtenerPuestoLibre (){
        for (Puesto p : puestos) {
            if (p.isActivo() == true && p.getLlamadaEnAtencion() == null) {
                return p;
            }
        }
        return null;
    }
    
    public long calcularTiempoAtencioPuesto(int numPuesto){
        Puesto puesto = ServicioPuesto.getInstancia().obtenerPuesto(numPuesto);
        long tiempoTotalAtencion =0;
        for(Llamada l : llamadasFinalizadas){
            if(l.getPuesto().getNumeroPuesto()==numPuesto){
                long momentoAtencion = CalculadoraFechas.calcularMilisegundos(l.getHoraAtencion().getYear(), l.getHoraAtencion().getMonthValue(), l.getHoraAtencion().getDayOfMonth(), l.getHoraAtencion().getHour(), l.getHoraAtencion().getMinute(), l.getHoraAtencion().getSecond());
                long momentoFin = CalculadoraFechas.calcularMilisegundos(l.getHoraFin().getYear(), l.getHoraFin().getMonthValue(), l.getHoraFin().getDayOfMonth(), l.getHoraFin().getHour(), l.getHoraFin().getMinute(), l.getHoraFin().getSecond());

                long difernciaTiempo = CalculadoraFechas.calcularDiferenciaDeTiempo(momentoAtencion, momentoFin);
                
                tiempoTotalAtencion+=difernciaTiempo;
            }
        }
        return tiempoTotalAtencion/puesto.getCantidadLlamadasAtendidas();
    }
    

    @Override
    public void update(Llamada llamada) {
        if (llamada.getEstado() == EstadoLLamada.FINALIZADA){
            llamadasFinalizadas.add(llamada);
            llamada.removerObservador(this);         
            if (llamadasEspera.isEmpty()){
                System.out.println("No hay mas llamadas por ahora");
            } else {
                Llamada proximaLlamada = llamadasEspera.get(0);
                derivarLlamadaAPuesto(proximaLlamada);
            }         
        }
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
