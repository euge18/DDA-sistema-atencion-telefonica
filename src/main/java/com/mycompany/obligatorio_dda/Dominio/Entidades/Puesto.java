/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Entidades;

import com.mycompany.obligatorio_dda.Dominio.Utilitarias.CalculadoraFechas;
import java.time.LocalDateTime;

/**
 *
 * @author zeek2
 */
public class Puesto {
      private int numeroPuesto;
    private boolean activo;
    private Trabajador trabajadorAsignado;
    private Llamada llamadaEnAtencion;
    private int cantidadLlamadasAtendidas = 0;
    private Sector sector;

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Puesto(int numeroPuesto, boolean activo, Trabajador trabajadorAsignado, Sector sector) {
        this.numeroPuesto = numeroPuesto;
        this.activo = activo;
        this.trabajadorAsignado = trabajadorAsignado;
        this.sector = sector;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Trabajador getTrabajadorAsignado() {
        return trabajadorAsignado;
    }

    public void setTrabajadorAsignado(Trabajador trabajadorAsignado) {
        this.trabajadorAsignado = trabajadorAsignado;
    }

    public Llamada getLlamadaEnAtencion() {
        return llamadaEnAtencion;
    }

    public void setLlamadaEnAtencion(Llamada llamadaEnAtencion) {
        this.llamadaEnAtencion = llamadaEnAtencion;
    }

    public int getCantidadLlamadasAtendidas() {
        return cantidadLlamadasAtendidas;
    }

    public void setCantidadLlamadasAtendidas(int cantidadLlamadasAtendidas) {
        this.cantidadLlamadasAtendidas = cantidadLlamadasAtendidas;
    }
    
    //AtenderLlamada es otra accion que se reliza desde el formulario
    //otra opcion es que sector no setee la llamada en Atencion, sino que se la pase al puesto y este
    //sea quien la setee
 
    //puede haber otro parametro booleano para botones de aceptar o rechazar la llamda
    public void atenderLlamada(Llamada llamada){
            llamada.setEstado(EstadoLLamada.CURSO);
            llamada.setHoraAtencion(LocalDateTime.now());
            llamada.setPuesto(this);
            llamada.setTrabajador(trabajadorAsignado);
            ++cantidadLlamadasAtendidas;
            llamadaEnAtencion = llamada;           
    }
    
    //Aqui podria haber una funcion contestar, 
    //para que el puesto no atienda de inmediato sino que el trabajador tenga la potestad
    
    public void finalizarLlamada(Llamada llamamda){
        llamamda.setEstado(EstadoLLamada.FINALIZADA);
    }
    
    @Override
    public String toString(){
        return this.numeroPuesto+"";
    }
}
       