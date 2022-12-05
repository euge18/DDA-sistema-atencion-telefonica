/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores;

import com.mycompany.obligatorio_dda.Dominio.Entidades.Puesto;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Sector;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Trabajador;
import com.mycompany.obligatorio_dda.Dominio.Fachada.Fachada;

/**
 *
 * @author Usuario
 */
public class LoginController {
    private VentanaLogin ventana;
    
    public LoginController(VentanaLogin ventana) {
        this.ventana = ventana;
    }

    public VentanaLogin getVentana() {
        return ventana;
    }

    public void setVentana(VentanaLogin ventana) {
        this.ventana = ventana;
    }
    
    public Trabajador loggearTrabajador () {
        String ci = ventana.getCi();
        String pass = ventana.getPass();
        Trabajador trabajador = Fachada.getInstancia().obtenerTrabajadorLogin(ci, pass);
        
        if(trabajador != null){
            Sector sector = Fachada.getInstancia().obtenerSector(trabajador.getSector().getNumeroSector());
            if(sector.asignarTrabajadorLibre(trabajador)){
                return trabajador;
            } else {
                ventana.mostrarMensaje("No hay puestos disponibles");
                return null;
            }
        } else {
            ventana.mostrarMensaje("Acceso denegado");
            return null;
        }
    }
    
}
