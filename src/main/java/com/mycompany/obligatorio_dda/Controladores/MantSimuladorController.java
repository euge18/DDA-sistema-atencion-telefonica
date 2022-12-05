/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Controladores;

import com.mycompany.obligatorio_dda.Dominio.Entidades.Cliente;
import com.mycompany.obligatorio_dda.Dominio.Entidades.EstadoLLamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Llamada;
import com.mycompany.obligatorio_dda.Dominio.Entidades.Sector;
import com.mycompany.obligatorio_dda.Dominio.Fachada.Fachada;
import com.mycompany.obligatorio_dda.Dominio.Repositorios.IObserverLlamada;
import com.mycompany.obligatorio_dda.Dominio.Utilitarias.CalculadoraFechas;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author zeek2
 */
public class MantSimuladorController implements IObserverLlamada{
    
        private MantVentanaSimulador ventana;
        
        private Llamada llamadaPendiente;
        
        private Cliente cliente;
        
        private String cedulaCliente = "";
        
        private boolean clienteIdentificado= false;
        
        private String ultimoNumero;
        
        private String mensaje;
        
        public MantSimuladorController(MantVentanaSimulador ventana){
            this.ventana = ventana;
            this.mensaje = "--BIENVENIDO--\n Para Comunicarse con nosotros presione el botón Iniciar\n Si desea abandonar la seción puede presionar Salir";
            this.ventana.mostrarMensajeBienvenida(mensaje);          
        }
        
        public void iniciarLlamada(Llamada llamada){
            llamadaPendiente = llamada;
            this.mensaje = "Ingrese su cedula y presione # para continuar";
            this.ventana.mostrarPedirCedula(mensaje);
        }
        
        public void recibirNumerosCedula (String numero){
            //Esta linea se puede cambiar pero si ya lo tengo identificado mejor dejarlo asi
            //o en su defecto ofreserle un boton de "reset cedula"
            if(!clienteIdentificado){
                cedulaCliente = cedulaCliente + numero;
                
            } else {
                ultimoNumero = numero;
            }
        }
        
        public void buscarCliente(){
            Cliente cliente = Fachada.getInstancia().ObtenerClientePorCedula(cedulaCliente);
            if(cliente==null){
                this.mensaje = "No existe un cliente con es cedula vuelva a intentarlo"; 
                this.ventana.mostrarMensajeClienteNoEncontrado(mensaje);
                cedulaCliente = "";
                return;
            }
            this.cliente = cliente;
            llamadaPendiente.setCliente(cliente);
            clienteIdentificado=true;
            
            this.mensaje = "Para comunicarse con Administracion presione 1\n Ventas presione 2 \n Desarrollo 3 \n y presione *";
            this.ventana.mostrarSectores(mensaje);
            cedulaCliente="";
        }
        
        public void buscarSectorYLlamar(){
            if(clienteIdentificado==true){
                int numeroSector = Integer.parseInt(ultimoNumero);
                this.cliente.hacerLlmada(numeroSector, llamadaPendiente);
                llamadaPendiente.agregarObservador(this);
               
                if(llamadaPendiente.getEstado()==EstadoLLamada.CURSO){
                    this.mensaje = "Llamada en curso... usted se esta comunicando con el Sector: " + llamadaPendiente.getSector().getNombre() + " y se esta atendido por " + llamadaPendiente.getTrabajador().getNombre() + " Su llamada se ha iniciado: " + llamadaPendiente.getHoraInicio();
                    this.ventana.mostrarMensajeLlamadaEnCurso(mensaje);               
                }
            } else {
                this.mensaje = "No existe un cliente con es cedula vuelva a intentarlo\n porque llega aca???";
                this.ventana.mostrarMensajeClienteNoEncontrado(mensaje);
            }
        }
        
        public void finalizarLlamada(){
            llamadaPendiente.setEstado(EstadoLLamada.FINALIZADA);
        }
        
        

    @Override
    public void update(Llamada llamada) {
        if(llamada.getEstado()==EstadoLLamada.FINALIZADA){
            llamada.removerObservador(this);
            //long momentoInicial = CalculadoraFechas.calcularMilisegundos(llamada.getHoraInicio().getYear(), llamada.getHoraInicio().getMonthValue(), llamada.getHoraInicio().getDayOfMonth(), llamada.getHoraInicio().getHour(), llamada.getHoraInicio().getMinute(), llamada.getHoraInicio().getSecond());
            //long momentoFin = CalculadoraFechas.calcularMilisegundos(llamada.getHoraFin().getYear(), llamada.getHoraFin().getMonthValue(), llamada.getHoraFin().getDayOfMonth(), llamada.getHoraFin().getHour(), llamada.getHoraFin().getMinute(), llamada.getHoraFin().getSecond());
            //long difernciaTiempo = CalculadoraFechas.calcularDiferenciaDeTiempo(momentoInicial, momentoFin);           
            //this.mensaje = "La llamada ha finalizado... Duración: " + difernciaTiempo + " segundos, y su saldo ha quedado en: " + llamada.getCliente().getSaldo() + "$";
            this.mensaje = "finalizo la llamada";
            this.ventana.mostrarMensajeFin(mensaje);
        }
    }


    
}
