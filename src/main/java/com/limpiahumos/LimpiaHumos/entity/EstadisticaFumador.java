/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "estadistica_fumador")
public class EstadisticaFumador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estadistica_fumador;

    private Long tiempo_sin_fumar;
    
    private Long dinero_ahorrado;
    
    private Long cigarillos_no_fumados;

    @Temporal(TemporalType.DATE)
    private Date fecha_estadistica;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Long getId_estadistica_fumador() {
        return id_estadistica_fumador;
    }

    public void setId_estadistica_fumador(Long id_estadistica_fumador) {
        this.id_estadistica_fumador = id_estadistica_fumador;
    }

    public Long getTiempo_sin_fumar() {
        return tiempo_sin_fumar;
    }

    public void setTiempo_sin_fumar(Long tiempo_sin_fumar) {
        this.tiempo_sin_fumar = tiempo_sin_fumar;
    }

    public Long getDinero_ahorrado() {
        return dinero_ahorrado;
    }

    //A la hora de representar dividir entre 100
    public void setDinero_ahorrado(Long dinero_ahorrado) {
        this.dinero_ahorrado = dinero_ahorrado;
    }

    public Long getCigarillos_no_fumados() {
        return cigarillos_no_fumados;
    }

    public void setCigarillos_no_fumados(Long cigarillos_no_fumados) {
        this.cigarillos_no_fumados = cigarillos_no_fumados;
    }

    public Date getFecha_estadistica() {
        return fecha_estadistica;
    }

    public void setFecha_estadistica(Date fecha_estadistica) {
        this.fecha_estadistica = fecha_estadistica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
}


