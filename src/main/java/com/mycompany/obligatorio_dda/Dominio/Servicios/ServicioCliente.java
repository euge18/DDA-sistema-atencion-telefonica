/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Servicios;

import com.mycompany.obligatorio_dda.Dominio.Entidades.*;
import java.util.ArrayList;

/**
 *
 * @author zeek2
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
        clientes.add(new Cliente(0, "123", "Alison Beker", new ConCosto(), 500));
        clientes.add(new Cliente(1, "222", "Martin Polar", new Exonerado(), 1500));
        clientes.add(new Cliente(2, "333", "Cedric Velmonte", new Gestor(), 1100));
        clientes.add(new Cliente(3, "444", "Karen Gutierrez", new ConCosto(),2100));
        clientes.add(new Cliente(4, "555", "Victoria Donda", new Exonerado(),4563));
        clientes.add(new Cliente(5, "666", "Elias Sané", new Gestor(),800));
    }
    
    public ArrayList<Cliente> obtenerClientes(){
        return clientes;
    }
    
    public Cliente ObtenerCliente (int idCliente){
        for(Cliente c : clientes){
            if(c.getIdCliente() == idCliente){
                return c;
            }
        }
        return null;
    }
    
        public Cliente ObtenerClientePorCedula (String cedulaCliente){
        for(Cliente c : clientes){
            if(c.getCedula() == null ? cedulaCliente == null : c.getCedula().equals(cedulaCliente)){
                return c;
            }
        }
        return null;
    }
}
