/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Fachada;

import com.mycompany.obligatorio_dda.Controladores.Interfaces.IFachada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Cliente;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Llamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Sector;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Puesto;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Trabajador;
import com.mycompany.obligatorio_dda.Dominio.Servicios.ServicioLlamada;
import com.mycompany.obligatorio_dda.Dominio.Servicios.ServicioSector;
import com.mycompany.obligatorio_dda.Dominio.Servicios.ServicioTrabajador;
import com.mycompany.obligatorio_dda.Dominio.Servicios.ServicioCliente;
import com.mycompany.obligatorio_dda.Dominio.Servicios.ServicioPuesto;
import com.mycompany.obligatorio_dda.Dominio.Utilitarias.CalculadoraFechas;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */


//Arreglar Fachada y Aplicarle un Patron Observer para que los Controlers lo usen

public class Fachada {
    
    private ArrayList<IFachada> observadores; 
    
     private static Fachada instancia = null; //Singleton 
    
    public static Fachada getInstancia(){
       if(instancia == null){
           instancia = new Fachada();
       }
       return instancia;
    }
    
    private Fachada(){
        observadores = new ArrayList<IFachada>();
    }
    
    public void notificarObserversDeFachada() {
        for (IFachada o : observadores) {
            o.update(this);
        }
    }
    
    public void agregarObservador(IFachada o) {
        observadores.add(o);
    }
    
    public ArrayList<Llamada> obtenerLlamadas() {
        return ServicioLlamada.getInstancia().obtenerLlamadas();
    }

    public void agregarLlamada(Llamada llamada) {
        ServicioLlamada.getInstancia().agregarLlamada(llamada);
        notificarObserversDeFachada();
    }

    public Llamada obtenerLlamada(int idLlamada) {
        return ServicioLlamada.getInstancia().obtenerLlamada(idLlamada);
    }

    public ArrayList<Llamada> obtenerLlamadasTrabajador(int idTrabajador) {
        return ServicioLlamada.getInstancia().obtenerLlamadasTrabajador(idTrabajador);
    }

    public int calcularCantLlamadasTrabajador(int id) {
       return ServicioLlamada.getInstancia().calcularCantLlamadasTrabajador(id);
    }

    public ArrayList<Llamada> obtenerLlamadasSector(int numeroSector) {
       return ServicioLlamada.getInstancia().obtenerLlamadasPorSector(numeroSector);
    }

    public ArrayList<Sector> obtenerSectores() {
       return ServicioSector.getInstancia().obtenerSectores();
    }

    public Sector obtenerSector(int numeroSector) {
        return ServicioSector.getInstancia().ObtenerSector(numeroSector);
    }

    public ArrayList<Trabajador> obtenerTrabajares() {
       return ServicioTrabajador.getInstancia().ObtenerTrabajadores();
    }

    public ArrayList<Trabajador> obtenerTrabajadoresPorSector(int numeroSector) {
       return ServicioTrabajador.getInstancia().ObtenerTrabajadoresPorSector(numeroSector);
    }

    public Trabajador obtenerTrabajador(int idTrabajador) {
       return ServicioTrabajador.getInstancia().obtenerTrabajador(idTrabajador);
    }
    
    public Trabajador obtenerTrabajadorLogin(String ci, String pass){
        return ServicioTrabajador.getInstancia().obtenerTrabajadorLogin(ci, pass);
    }

    public ArrayList<Puesto> obtenerPuestos() {
       return ServicioPuesto.getInstancia().obtenerPuestos();
    }

    public Puesto obtenerPuesto(int numeroPuesto) {
       return ServicioPuesto.getInstancia().obtenerPuesto(numeroPuesto);
    }

    public ArrayList<Cliente> obtenerClientes() {
       return ServicioCliente.getInstancia().obtenerClientes();
    }

    public Cliente obtenerCliente(int idCliente) {
        return ServicioCliente.getInstancia().ObtenerCliente(idCliente);
    }
    
    public Cliente ObtenerClientePorCedula(String cedulaCliente) {
        return ServicioCliente.getInstancia().ObtenerClientePorCedula(cedulaCliente);
    }
    
    public long calcularMilisegundos(int anio, int mes, int dia, int hora, int minuto, int segundo){
        return CalculadoraFechas.calcularMilisegundos(anio, mes, dia, hora, minuto, segundo);
    }
    
    public long calcularDiferenciaDeTiempo(long atencion, long fin){
        long tiempo = CalculadoraFechas.calcularDiferenciaDeTiempo(atencion, fin);
        return tiempo;
    }
    
    

}
