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
public class Sector implements IObserverLlamada{
    private int numeroSector;
    private String nombre;
    private ArrayList<Puesto> puestos;
    private ArrayList<Llamada> llamadasEspera;
    private ArrayList<Llamada> llamadasFinalizadas;
    private ArrayList<Trabajador> trabajadores;

    public Sector(int numeroSector, String nombre) {
        this.numeroSector = numeroSector;
        this.nombre = nombre;
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
    
    //cuando el trabajador se logea que esta funcion lo asigne automaticamnete
    // caso no encuentre un puesto se puede crear uno fuera del for, se debe de agregar el nuevo puesto a la lista
    // pero si todo esta precargado pueden se 5 trabajadores para 5 puestos
    public void asignarTrabajadorLibre(Trabajador trabajador) {
        for (Puesto p : puestos) {
            if (p.isActivo() == false) {
                p.setTrabajadorAsignado(trabajador);
            }
        }
    }
    
    public void dejarPuesto (Puesto puesto){
        puesto.setTrabajadorAsignado(null);
    }
    
    public float calcularTiempoPromedioAtencion (){
        float timepoTotalAtencion = 0;
        for(Puesto p : puestos){
            timepoTotalAtencion += p.getTiempoTotalAtencion();
        }
        return timepoTotalAtencion/puestos.size();
    }
    
    public void recibirLlamada (Llamada llamada){
        try{
            if (llamadasEspera.size() < 5) {
                llamadasEspera.add(llamada);
                derivarLlamadaAPuesto(llamada);
            }
        } catch (Exception e){
            //lanzar mensaje "llame mas tarde"
        }

 
    }
    
    public void derivarLlamadaAPuesto(Llamada llamada) {
        try {
            Puesto puestoLibre = obtenerPuestoLibre();
            if (puestoLibre != null) {
                puestoLibre.setLlamadaEnAtencion(llamada);
                llamada.setEstado(EstadoLLamada.CURSO);
                //Aqui se llama al observer desde la funcion del setEstado, 
                //pues sector debe saber cuando finaliza para agregarla a las llamadas 
                //finalizadas y reasignar el puesto
                llamadasEspera.remove(llamada);
            }
        } catch (Exception ex) {
            //lanzar mensaje: "aguarde en linea que pronto sera atendido
        }
    }
    
    public Puesto obtenerPuestoLibre (){
        for (Puesto p : puestos) {
            if (p.isActivo() == true && p.getLlamadaEnAtencion() == null) {
                return p;
            }
        }
        return null;
    }
    
    /*Cuando finalice un llamada y el puesto quede libre que Sector busque otra llamada en espera
    y se lo asigne, ademas de eliminarse como observador de esa llamada*/

    @Override
    public void update(Llamada llamada) {
        if (llamada.getEstado() == EstadoLLamada.FINALIZADA){
            llamadasFinalizadas.add(llamada);
            llamada.removerObservador(this);
            Llamada proximaLlamada = llamadasEspera.get(0);
            derivarLlamadaAPuesto(proximaLlamada);
            
        }
    }
}
