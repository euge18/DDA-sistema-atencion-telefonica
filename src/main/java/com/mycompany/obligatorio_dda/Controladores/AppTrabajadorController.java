/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores;

import com.mycompany.obligatorio_dda.Dominio.Entidades.Cliente;
import com.mycompany.obligatorio_dda.Dominio.Entidades.EstadoLLamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Llamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Puesto;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Trabajador;
import com.mycompany.obligatorio_dda.Dominio.Fachada.Fachada;
import com.mycompany.obligatorio_dda.Dominio.Repositorios.IObserverLlamada;
import com.mycompany.obligatorio_dda.Dominio.Repositorios.IObserverPuesto;
import com.mycompany.obligatorio_dda.Dominio.Utilitarias.CalculadoraFechas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AppTrabajadorController implements IObserverLlamada, IObserverPuesto{
    private VentanaTrabajador ventana;
    private Puesto puesto;
    private Trabajador trabajador;
    private float tiempoDeAtencion;
    private float tiempoDemora;

    public float getTiempoDemora() {
        return tiempoDemora;
    }

    public void setTiempoDemora(float tiempoDemora) {
        this.tiempoDemora = tiempoDemora;
    }
    private Llamada llamadaEnCurso;

    public float getTiempoDeAtencion() {
        return tiempoDeAtencion;
    }

    public void setTiempoDeAtencion(float tiempoDeAtencion) {
        this.tiempoDeAtencion = tiempoDeAtencion;
    }
    
    public AppTrabajadorController(VentanaTrabajador ventana, Trabajador trabajador) {
        this.ventana = ventana;
        this.trabajador = trabajador;
        puesto = trabajador.getSector().obtenerPuestoTrabajador(trabajador);
        trabajador.getSector().obtenerPuestoTrabajador(trabajador).agregarObservador(this);
        this.tiempoDeAtencion = 0;
        this.tiempoDemora=0;
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
    
    public boolean salirAplicacion() {
        boolean respuesta = false;
        if (puesto.getLlamadaEnAtencion() == null) {
            respuesta = true;
            trabajador.getSector().dejarPuesto(puesto);
            resetearPuesto();
            return respuesta;
        } else if(puesto.getLlamadaEnAtencion().getEstado() == EstadoLLamada.CURSO){
            int resultado = JOptionPane.showConfirmDialog(null,
                    "¿Esta seguro de salir?",
                    "ATENCION", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (resultado == JOptionPane.OK_OPTION) {
                trabajador.getSector().dejarPuesto(puesto);
                respuesta = true;
                resetearPuesto();
                return respuesta;
        }
        
    }
        return respuesta;
    }
    
    public void resetearPuesto() {
        this.puesto=null;
        this.trabajador=null;
        this.tiempoDeAtencion=0;
        this.tiempoDemora=0;
        this.llamadaEnCurso=null;
    }

    public void finalizarLlamada(){
            llamadaEnCurso.setEstado(EstadoLLamada.FINALIZADA);
    }
    
    @Override
    public void update(Llamada llamada) {
        //No esta funcionando
        if (llamada.getEstado() == EstadoLLamada.FINALIZADA) {
            llamada.setHoraFin(LocalDateTime.now());
            long momentoInicio = CalculadoraFechas.calcularMilisegundos(llamada.getHoraInicio().getYear(), llamada.getHoraInicio().getMonthValue(), llamada.getHoraInicio().getDayOfMonth(), llamada.getHoraInicio().getHour(), llamada.getHoraInicio().getMinute(), llamada.getHoraInicio().getSecond());//linea agregada
            long momentoAtencion = CalculadoraFechas.calcularMilisegundos(llamada.getHoraAtencion().getYear(), llamada.getHoraAtencion().getMonthValue(), llamada.getHoraAtencion().getDayOfMonth(), llamada.getHoraAtencion().getHour(), llamada.getHoraAtencion().getMinute(), llamada.getHoraAtencion().getSecond());
            long momentoFin = CalculadoraFechas.calcularMilisegundos(llamada.getHoraFin().getYear(), llamada.getHoraFin().getMonthValue(), llamada.getHoraFin().getDayOfMonth(), llamada.getHoraFin().getHour(), llamada.getHoraFin().getMinute(), llamada.getHoraFin().getSecond());
            long diferenciaMilisegundos = Math.abs(momentoAtencion - momentoFin);
            long tiempoDemoraMilisegundos = Math.abs(momentoInicio - momentoFin);//linea agregada
            float segundos = (float) diferenciaMilisegundos / 1000;
            float minutos = ((float) tiempoDemoraMilisegundos /1000)/60;//linea agregada
            setTiempoDemora(tiempoDemora + minutos);//linea agregada
            setTiempoDeAtencion(tiempoDeAtencion + segundos);
            this.puesto.setTotalTiempoDemora(tiempoDemora);
            this.ventana.mostrarTiempoPromedioLlamadas(getTiempoDeAtencion() + segundos);
            if (llamada.getHoraFin() != null) {
                llamada.setHoraFin(LocalDateTime.now());
            }
            llamada.setEstado(EstadoLLamada.FINALIZADA);
            llamada.setDescripcion(ventana.getDescripcion());
            this.ventana.limpiarPantalla();
            ArrayList<Llamada> llamadas = this.puesto.getLlamadasAtendidas();
            llamadas.add(llamada);
            this.puesto.setLlamadasAtendidas(llamadas);
            llamada.removerObservador(this);
            this.puesto.setLlamadaEnAtencion(null);
        }
        
        //llamada.getPuesto().setLlamadaEnAtencion(null);
    }  

    @Override
    public void update(Puesto puesto) {
        if (this.puesto.getLlamadaEnAtencion() == null) {
            this.ventana.mostrarMensajeLlamadaEnCurso("Llamada finalizada...");

            int cantLlamadas = this.puesto.getCantidadLlamadasAtendidas();
            this.puesto.setCantidadLlamadasAtendidas(++cantLlamadas);
            this.ventana.mostrarCantidadLlamadasAtendidas(cantLlamadas);
        } else {
            llamadaEnCurso = puesto.getLlamadaEnAtencion();
            this.puesto.getLlamadaEnAtencion().agregarObservador(this);
            ventana.mostrarMensajeLlamadaEnCurso("Llamada en curso...");
            ventana.mostrarNombreCliente(puesto.getLlamadaEnAtencion().getCliente().getNombreCompleto());
            ventana.mostrarCantidadLlamadasAtendidas(puesto.getCantidadLlamadasAtendidas());
        }

    }
}
