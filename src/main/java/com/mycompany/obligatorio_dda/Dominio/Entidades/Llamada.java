/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Entidades;

import com.mycompany.obligatorio_dda.Dominio.Repositorios.IObserverLlamada;
import com.mycompany.obligatorio_dda.Dominio.Utilitarias.CalculadoraFechas;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */
public class Llamada {
      private static int costoFijo = 1;
    
    private int idLlamada;
    private EstadoLLamada estado;
    private LocalDateTime horaInicio;
    private LocalDateTime horaAtencion; 
    private LocalDateTime horaFin;
    private float costo;
    private String descripcion;
    private Cliente cliente;
    private Sector sector; 
    private Puesto puesto;
    private Trabajador trabajador; 
    private ArrayList<IObserverLlamada> observadores;

    public Llamada(EstadoLLamada estado, LocalDateTime horaInicio, Cliente cliente) {
        this.estado = estado;
        this.horaInicio = horaInicio;
        this.cliente = cliente;
        
        this.observadores = new ArrayList<IObserverLlamada>();
    }
   
    public Llamada (int num, String descripcionEncabezado){
        this.idLlamada = -1;
        this.descripcion = descripcionEncabezado;
    }

    public static int getCostoFijo() {
        return costoFijo;
    }

    public static void setCostoFijo(int costoFijo) {
        Llamada.costoFijo = costoFijo;
    }

    public int getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    public EstadoLLamada getEstado() {
        return estado;
    }

    public void setEstado(EstadoLLamada estado) {
        if(this.estado != estado){
            //Gran ERRROR: como no seteaba primero siempre al update le llegaba en CURSO y rebotaba
            this.estado = estado;
            notifiacearObservers();
        }
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(LocalDateTime horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public ArrayList<IObserverLlamada> getObservadores() {
        return observadores;
    }

    public void setObservadores(ArrayList<IObserverLlamada> observadores) {
        this.observadores = observadores;
    }
    
    public float calcularCosto (Llamada llamada){
        return cliente.getTipo().calcularCostoLlamada(llamada);
    }
    
    //Se rompe aqui cuando finaliza la funcion update, no regresa el control a la clase principal
    //quizas porque ese update remueve el observador en el medio de la ejecucuion del for?
    
    //Cunado el cliente finaliza la llamda se da setEstado y notifica que finalizo, como finalizo
    //va al for a recorrer sus observadores (size = 1) y va al update de Sector, y este se remueve
    //cuando regresa el control al for el size=0 y rompe
    public void notifiacearObservers(){
        //ArrayList<IObserverLlamada> copiaLista = observadores;
        ArrayList<IObserverLlamada> copiaListaObservadores = (ArrayList<IObserverLlamada>) observadores.clone();
        for(IObserverLlamada o : copiaListaObservadores){      
            o.update(this);
        }
    }
    
    //cuando la llamada deriva a un puesto a Sector se lo agrega
    public void agregarObservador (IObserverLlamada o){
        observadores.add(o);
    }
    
    //cuando la llamada finaliza a Sector ya no le interesa seguir observando
    public void removerObservador (IObserverLlamada o){
        observadores.remove(o);
    }
    
    

    
    //Ver como convertir las fechas en formatos mas lindos
    @Override
    public String toString(){       
        if(this.idLlamada==-1){
            return this.descripcion;
        } else {
                  long difernciaTiempo = 0;
        boolean Fin;
        if (this.estado==EstadoLLamada.FINALIZADA){
            Fin = true;
            long momentoAtencion = CalculadoraFechas.calcularMilisegundos(this.getHoraAtencion().getYear(), this.getHoraAtencion().getMonthValue(), this.getHoraAtencion().getDayOfMonth(), this.getHoraAtencion().getHour(), this.getHoraAtencion().getMinute(), this.getHoraAtencion().getSecond());
            long momentoFin = CalculadoraFechas.calcularMilisegundos(this.getHoraFin().getYear(), this.getHoraFin().getMonthValue(), this.getHoraFin().getDayOfMonth(), this.getHoraFin().getHour(), this.getHoraFin().getMinute(), this.getHoraFin().getSecond());
            difernciaTiempo = CalculadoraFechas.calcularDiferenciaDeTiempo(momentoAtencion, momentoFin);
        } else {
            Fin = false;
        }    
        return this.idLlamada + " | " + this.estado + " | " + CalculadoraFechas.formatearFecha(this.horaInicio) + " | " + (Fin? CalculadoraFechas.formatearFecha(this.horaFin): "Sin Finalizar") + " | " + this.puesto + " | " + this.puesto.getTrabajadorAsignado() + " | " +(Fin? difernciaTiempo: "Sin Finalizar") + " | " + (Fin? this.costo: "Sin Finalizar") + " | " + this.cliente + " | " + this.cliente.getSaldo();  
        }
    }
    
     
}
