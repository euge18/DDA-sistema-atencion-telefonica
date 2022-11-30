/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.obligatorio_dda;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author zeek2
 */
public interface IObserverRemoto extends Remote{
    void actualizar(Object o, Evento evt) throws RemoteException;
}
