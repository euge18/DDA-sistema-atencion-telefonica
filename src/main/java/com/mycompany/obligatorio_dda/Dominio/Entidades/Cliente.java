/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Entidades;

import com.mycompany.obligatorio_dda.Dominio.Repositorios.ITipoCliente;
import com.mycompany.obligatorio_dda.Dominio.Servicios.ServicioLlamada;
import com.mycompany.obligatorio_dda.Dominio.Servicios.ServicioSector;

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
    
    public void hacerLlmada(int numeroSector, Llamada llamada) {
        try {
            if (saldo > 0) {
                llamada.setCliente(this);
                ServicioLlamada.getInstancia().agregarLlamada(llamada);
                Sector sector = ServicioSector.getInstancia().ObtenerSector(numeroSector);
                if (sector != null) {
                    sector.recibirLlamada(llamada);
                } 
            } 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
