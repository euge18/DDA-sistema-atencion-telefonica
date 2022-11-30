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
public class ServicioCliente {
    private ArrayList<Cliente> clientes;
    private static ServicioCliente instancia = null; //Singleton 
    
    public static ServicioCliente getInstancia(){
       if(instancia == null){
           instancia = new ServicioCliente();
       }
       return instancia;
    }
    
    private ServicioCliente(){
        clientes = new ArrayList<>();
        clientes.add(new Cliente(0, "48756325", "Alison Beker", new ConCosto()));
        clientes.add(new Cliente(1, "86542258", "Martin Polar", new Exonerado()));
        clientes.add(new Cliente(2, "74235452", "Cedric Velmonte", new Gestor()));
        clientes.add(new Cliente(3, "85256214", "Karen Gutierrez", new ConCosto()));
        clientes.add(new Cliente(4, "24566997", "Victoria Donda", new Exonerado()));
        clientes.add(new Cliente(5, "36655892", "Elias Sané", new Gestor()));
    }
    
    public ArrayList<Cliente> obtenerClientes(){
        return clientes;
    }
}
