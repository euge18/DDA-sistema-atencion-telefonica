/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */
public interface IFachada extends Remote{
    
   void agregarObserverRemoto(IObserverRemoto obs)throws RemoteException;
   
   ArrayList<Llamada>obtenerLlamadas()throws RemoteException;
   
   void agregarLlamada(Llamada llamada)throws RemoteException;
   
   Llamada obtenerLlamada(int idLlamada)throws RemoteException;
   
   ArrayList<Llamada>obtenerLlamadasTrabajador(int idTrabajador)throws RemoteException;
   
   int calcularCantLlamadasTrabajador(int id)throws RemoteException;
   
   ArrayList<Llamada>obtenerLlamadasSector(int numeroSector)throws RemoteException;
   
   //Servicios de Sector
   ArrayList<Sector>obtenerSectores()throws RemoteException;
   
   Sector obtenerSector(int numeroSector)throws RemoteException;
   
   //Servicios Trabajador
   ArrayList<Trabajador>obtenerTrabajares()throws RemoteException;
   
   ArrayList<Trabajador> obtenerTrabajadoresPorSector(int numeroSector)throws RemoteException;
   
   Trabajador obtenerTrabajador(int idTrabajador)throws RemoteException;
   
   //Servicios Puesto
   ArrayList<Puesto>obtenerPuestos()throws RemoteException;
   
   Puesto obtenerPuesto(int numeroPuesto)throws RemoteException;
   
   //Servicios Cliente
   ArrayList<Cliente>obtenerClientes()throws RemoteException;
   
   Cliente obtenerCliente(int idCliente)throws RemoteException;
   
}
