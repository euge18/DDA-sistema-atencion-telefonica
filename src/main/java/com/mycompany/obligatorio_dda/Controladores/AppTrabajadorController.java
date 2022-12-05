/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores;

import com.mycompany.obligatorio_dda.Dominio.Entidades.EstadoLLamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Llamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Puesto;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Trabajador;
import com.mycompany.obligatorio_dda.Dominio.Fachada.Fachada;
import com.mycompany.obligatorio_dda.Dominio.Repositorios.IObserverLlamada;
import com.mycompany.obligatorio_dda.Dominio.Repositorios.IObserverPuesto;
import java.time.LocalDateTime;

/**
 *
 * @author Usuario
 */
public class AppTrabajadorController implements IObserverLlamada, IObserverPuesto{
    private VentanaTrabajador ventana;
    private Puesto puesto;
    private Trabajador trabajador;
    
    public AppTrabajadorController(VentanaTrabajador ventana, Trabajador trabajador) {
        this.ventana = ventana;
        this.trabajador = trabajador;
        puesto = trabajador.getSector().obtenerPuestoTrabajador(trabajador);
        trabajador.getSector().obtenerPuestoTrabajador(trabajador).agregarObservador(this);
        System.out.println(puesto.getObservadoresPuesto().size());
        Llamada llamadaPrueba = new Llamada(EstadoLLamada.PENDIENTE, LocalDateTime.now(), Fachada.getInstancia().obtenerCliente(1));
        puesto.setLlamadaEnAtencion(llamadaPrueba);
        
    }

    public VentanaTrabajador getVentana() {
        return ventana;
    }

    public void setVentana(VentanaTrabajador ventana) {
        this.ventana = ventana;
    }
    
    public void getTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    public void salirAplicacion() {
        //Controlar setVisibule en frm
        if (puesto.getLlamadaEnAtencion().getEstado() == EstadoLLamada.CURSO) {
            //Preguntar si desea finalizar llamada
        } else {
            trabajador.getSector().dejarPuesto(puesto);
        } 
    }
    
    public void finalizarLlamada(){
       puesto.getLlamadaEnAtencion().setEstado(EstadoLLamada.FINALIZADA);
    }
    
    @Override
    public void update(Llamada llamada) {
        //No esta funcionando
        if(llamada.getEstado() == EstadoLLamada.FINALIZADA){
            llamada.removerObservador(this);
            llamada.setDescripcion(ventana.getDescripcion());
            this.ventana.limpiarPantalla();
            this.ventana.mostrarMensajeLlamadaEnCurso("Llamada finalizada...");
            this.ventana.mostrarTiempoPromedioLlamadas(34); //VALOR PARA PROBAR QUE FUNCIONA
        }
        
        //llamada.getPuesto().setLlamadaEnAtencion(null);
    }  

    @Override
    public void update(Puesto puesto) {
        ventana.mostrarMensajeLlamadaEnCurso("Llamada en curso...");
        ventana.mostrarNombreCliente(puesto.getLlamadaEnAtencion().getCliente().getNombreCompleto());
        ventana.mostrarCantidadLlamadasAtendidas(puesto.getCantidadLlamadasAtendidas());
    }
}
