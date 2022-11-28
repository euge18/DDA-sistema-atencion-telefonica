/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

/**
 *
 * @author Usuario
 */
public class Puesto {
    private int numeroPuesto;
    private boolean activo;
    private Trabajador trabajadorAsignado;
    private Llamada llamadaEnAtencion;
    private int cantidadLlamadasAtendidas;

    public Puesto(int numeroPuesto, boolean activo, Trabajador trabajadorAsignado) {
        this.numeroPuesto = numeroPuesto;
        this.activo = activo;
        this.trabajadorAsignado = trabajadorAsignado;
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
   
}
