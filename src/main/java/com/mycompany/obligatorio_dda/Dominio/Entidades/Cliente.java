/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Entidades;

import com.mycompany.obligatorio_dda.Dominio.Repositorios.ITipoCliente;
import com.mycompany.obligatorio_dda.Dominio.Servicios.*;
import java.time.LocalDateTime;

/**
 *
 * @author zeek2
 */
public class Cliente {
    private int idCliente;
    private String cedula;
    private String nombreCompleto;
    private ITipoCliente tipo;
    private float saldo;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Cliente(int idCliente, String cedula, String nombreCompleto, ITipoCliente tipo, float saldo) {
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.tipo = tipo;
        this.saldo = saldo;
    }
    
    //Sacar este constructor de prueba
    public Cliente(){
        
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public ITipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(ITipoCliente tipo) {
        this.tipo = tipo;
    }
    
    //ESTE DEJAR => LO NESECITA EL SIMULADOR DEL LADO DEL CLIENTE
    public void hacerLlmada(int numeroSector, Llamada llamada){
        if (saldo>0){
            llamada.setCliente(this);
            ServicioLlamada.getInstancia().agregarLlamada(llamada);
            Sector sector = ServicioSector.getInstancia().ObtenerSector(numeroSector);
            if (sector != null) {
                sector.recibirLlamada(llamada);
            } else {
                //Ver como lanzar mensajes
                System.out.println("Ingrese un número de Sector valido");
            }
        } else {
            System.out.println("Regarge su saldo");
        }
  
    }
    
    //Este SACAR => SOLO PARA QUE ANDE LA APPTEST TRABAJADOR
        public void hacerLlmada(int numeroSector){
        if (saldo>0){
            Llamada llamda = new Llamada(EstadoLLamada.PENDIENTE, LocalDateTime.now(), this);
            ServicioLlamada.getInstancia().agregarLlamada(llamda);
            Sector sector = ServicioSector.getInstancia().ObtenerSector(numeroSector);
            if (sector != null) {
                sector.recibirLlamada(llamda);
            } else {
                //Ver como lanzar mensajes
                System.out.println("Ingrese un número de Sector valido");
            }
        } else {
            System.out.println("Regarge su saldo");
        }
  
    }
    
    public void finalizarLlamda(Llamada llmada){
        llmada.setEstado(EstadoLLamada.FINALIZADA);
    }
    
    @Override
    public String toString() {
        return this.nombreCompleto;
    }
}
