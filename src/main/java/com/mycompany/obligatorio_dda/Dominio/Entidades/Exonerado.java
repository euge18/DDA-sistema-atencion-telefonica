/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatorio_dda.Dominio.Entidades;

import com.mycompany.obligatorio_dda.Dominio.Repositorios.ITipoCliente;

/**
 *
 * @author zeek2
 */
public class Exonerado implements ITipoCliente {
    @Override
    public float calcularCostoLlamada(Llamada llamada) {
        llamada.setCosto(0);
        return 0;
    }
}
