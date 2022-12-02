/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.time.LocalDateTime;
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
        //Inicializo las listas en el constructor
        llamadasEspera = new ArrayList<Llamada>();
        llamadasFinalizadas = new ArrayList<Llamada>();
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
                llamadasEspera.add(llamada);
                derivarLlamadaAPuesto(llamada);
            } else {
                llamada.setEstado(EstadoLLamada.RECHAZADA);
                System.out.println("Todas nuestras lineas se encuentran ocupada, intente llamndo más tarde");
            }
    }
    
    public void derivarLlamadaAPuesto(Llamada llamada) {
            Puesto puestoLibre = obtenerPuestoLibre();
            if (puestoLibre != null) {
                puestoLibre.atenderLlamada(llamada);
                llamada.setSector(this);
                //Sector se agrega como observer
                llamada.agregarObservador(this);
                //Aqui se llama al observer desde la funcion del setEstado, 
                //pues sector debe saber cuando finaliza para agregarla a las llamadas 
                //finalizadas y reasignar el puesto
                llamadasEspera.remove(llamada);
            } else {
                System.out.println("Actualmente no hay puestos libres");
                recibirLlamada(llamada);
                //hoa
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
    
    /*Cuando finalice un llamada y el puesto quede libre que Sector busque otra llamada en espera
    y se lo asigne, ademas de eliminarse como observador de esa llamada*/

    @Override
    public void update(Llamada llamada) {
        if (llamada.getEstado() == EstadoLLamada.FINALIZADA){
            llamada.setHoraFin(LocalDateTime.now());
            llamadasFinalizadas.add(llamada);
            llamada.removerObservador(this);
            
            if (llamadasEspera.isEmpty()){
                System.out.println("No hay mas llamadas por ahora");
            } else {
                Llamada proximaLlamada = llamadasEspera.get(0);
                System.out.println("Proxima llamada");
                derivarLlamadaAPuesto(proximaLlamada);
            }
            //Se rompe aqui cuando llamda viene null
            
            //if(proximaLlamada==null){
            //}  else {}
        }
    }
}
