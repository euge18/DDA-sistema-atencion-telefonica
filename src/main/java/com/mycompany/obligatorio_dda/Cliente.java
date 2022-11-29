/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private int idCliente;
    private String cedula;
    private String nombreCompleto;
    private ITipoCliente tipo;

    public Cliente(int idCliente, String cedula, String nombreCompleto, ITipoCliente tipo) {
        this.idCliente = idCliente;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.tipo = tipo;
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
    
    //para el metodo hacer llamada sea una accion del boton del formulario que crea un obj Llamada
    
}
