/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores;

import com.mycompany.obligatorio_dda.Dominio.Entidades.Puesto;

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
    
    public void mostrarTiempoPromedioLlamadas(long cant);
    
    public void limpiarPantalla();
    
}
