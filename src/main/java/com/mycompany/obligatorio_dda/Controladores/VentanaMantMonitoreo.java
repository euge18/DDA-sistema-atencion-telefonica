/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores;

import com.mycompany.obligatorio_dda.Dominio.Entidades.*;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */
public interface VentanaMantMonitoreo {
    
      public void mostrarSectores(ArrayList<Sector> sectores);
      
      public void mostrarLlamadas(ArrayList<Llamada> llamadas);
      
      public Sector obtenerSectorSeleccionado();
    
}
