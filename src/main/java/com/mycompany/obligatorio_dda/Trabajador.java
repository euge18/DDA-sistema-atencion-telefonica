/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

/**
 *
 * @author Usuario
 */
public class Trabajador {
    private int idTrabajador;
    private String cedula;
    private String pass;
    private String nombre;
    private Sector sector;

    public Trabajador(int idTrabajador, String cedula, String pass, String nombre, Sector sector) {
        this.idTrabajador = idTrabajador;
        this.cedula = cedula;
        this.pass = pass;
        this.nombre = nombre;
        this.sector = sector;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    } 
    
    //Login y Logout son funciones que usa el formulario de Login (como el PortalTareas)
    // por tanto son responsabilidades del controlador verificar la existencia de ese trabajador
}
