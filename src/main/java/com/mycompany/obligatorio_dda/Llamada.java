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

    public Llamada(int idLlamada, EstadoLLamada estado, LocalDateTime horaInicio, Cliente cliente) {
        this.idLlamada = idLlamada;
        this.estado = estado;
        this.horaInicio = horaInicio;
        this.cliente = cliente;
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
        this.estado = estado;
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
    
    public void calcularCosto (){
        float costo = cliente.getTipo().calcularCostoLlamada(this);
        this.costo = costo;
    }
    
    
}
