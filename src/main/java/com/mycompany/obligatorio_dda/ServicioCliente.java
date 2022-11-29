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
        //Agregar clientes
    }
}
