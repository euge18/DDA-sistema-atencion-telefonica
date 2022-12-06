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
            
            this.mensaje = "Para comunicarse con Administracion presione 1\nVentas presione 2 \n Desarrollo presione 3 \n y finalmente presione *";
            this.ventana.mostrarSectores(mensaje);
            cedulaCliente="";
        }
        
        public void buscarSectorYLlamar(){
            if(clienteIdentificado==true){
                int numeroSector = Integer.parseInt(ultimoNumero);
                Sector sector = Fachada.getInstancia().obtenerSector(numeroSector);
                if (sector == null) {
                    this.mensaje = "Numero de Sector Incorrecto, vuelva a intentarlo";
                    this.cedulaCliente = "";
                    this.clienteIdentificado = false;
                    this.cliente = null;
                    this.llamadaPendiente = null;
                    this.ultimoNumero = "";
                    this.ventana.mostrarMensajeSectorOcupado(mensaje);
                    return;
                }
                if(sector.getLlamadasEspera().size()>=5){
                    this.mensaje= "Todas nuestras lineas estan ocupadas, intentelo más tarde";
                    this.cedulaCliente = "";
                    this.clienteIdentificado = false;
                    this.cliente = null;
                    this.llamadaPendiente = null;
                    this.ultimoNumero = "";
                    this.ventana.mostrarMensajeSectorOcupado(mensaje);
                    return;
                }

                this.cliente.hacerLlmada(numeroSector, llamadaPendiente);
                llamadaPendiente.agregarObservador(this);
               
                if(llamadaPendiente.getEstado()==EstadoLLamada.CURSO){
                    this.mensaje = "Llamada en curso...\n usted se esta comunicando con el Sector: " + llamadaPendiente.getSector().getNombre() + "\n y se esta atendido por " + llamadaPendiente.getTrabajador().getNombre() + "\n Su llamada se ha iniciado: " + CalculadoraFechas.formatearFecha(llamadaPendiente.getHoraInicio());
                    this.ventana.mostrarMensajeLlamadaEnCurso(mensaje);               
                } else {
                    this.mensaje = "Aguarde en linea Usted se encentra en la posicion " + sector.getLlamadasEspera().indexOf(llamadaPendiente);
                }
            } else {
                this.mensaje = "No existe un cliente con es cedula vuelva a intentarlo";
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
            long momentoInicial = CalculadoraFechas.calcularMilisegundos(llamada.getHoraInicio().getYear(), llamada.getHoraInicio().getMonthValue(), llamada.getHoraInicio().getDayOfMonth(), llamada.getHoraInicio().getHour(), llamada.getHoraInicio().getMinute(), llamada.getHoraInicio().getSecond());
            long momentoFin = CalculadoraFechas.calcularMilisegundos(llamada.getHoraFin().getYear(), llamada.getHoraFin().getMonthValue(), llamada.getHoraFin().getDayOfMonth(), llamada.getHoraFin().getHour(), llamada.getHoraFin().getMinute(), llamada.getHoraFin().getSecond());
            long difernciaTiempo = CalculadoraFechas.calcularDiferenciaDeTiempo(momentoInicial, momentoFin);           
            this.mensaje = "La llamada ha finalizado...\n Duración: " + difernciaTiempo + " segundos\nha costado: " + llamada.calcularCosto(llamada) + "\ny su saldo ha quedado en: " + llamada.getCliente().getSaldo() + "$\n para volver a comunicarse: Para comunicarse con Administracion presione 1\nVentas presione 2 \n Desarrollo presione 3 \n y finalmente presione *";
            this.ultimoNumero="";
            this.llamadaPendiente=null;
            this.ventana.mostrarMensajeFin(mensaje);
        }
    }


    
}
