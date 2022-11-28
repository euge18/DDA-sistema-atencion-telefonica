/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Sector {
    private int numeroSector;
    private String nombre;
    private ArrayList<Puesto> puestos;
    private ArrayList<Llamada> llamadasEspera;
    private ArrayList<Llamada> llamadasFinalizadas;
    private ArrayList<Trabajador> trabajadores;

    public Sector(int numeroSector, String nombre) {
        this.numeroSector = numeroSector;
        this.nombre = nombre;
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
   
}
