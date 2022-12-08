/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores.Interfaces;

/**
 *
 * @author Usuario
 */
public interface VentanaTrabajador {
    
    public String getDescripcion();
    
    public void mostrarMensaje(String mensaje);
    
    public void mostrarMensajeLlamadaEnCurso(String mensaje);
    
    public void mostrarNombreCliente(String nombre);
    
    public void mostrarCantidadLlamadasAtendidas(int cant);
    
    public void mostrarTiempoPromedioLlamadas(float cant);
    
    public void limpiarPantalla();
    
}
