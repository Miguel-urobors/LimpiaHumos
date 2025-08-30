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
@Table(name = "objetivos")
public class Objetivos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_objetivos;

    private String nombre_objetivo;
    
    private String diario;
    
    private String tipo_objetivo;

    @Temporal(TemporalType.DATE)
    private Date fecha_inicio_objetivo;

    @Temporal(TemporalType.DATE)
    private Date fecha_fin_objetivo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Getters y Setters

    public Long getId_objetivos() {
        return id_objetivos;
    }

    public void setId_objetivos(Long id_objetivos) {
        this.id_objetivos = id_objetivos;
    }

    public String getNombre_objetivo() {
        return nombre_objetivo;
    }

    public void setNombre_objetivo(String nombre_objetivo) {
        this.nombre_objetivo = nombre_objetivo;
    }

    public String getDiario() {
        return diario;
    }

    public void setDiario(String diario) {
        this.diario = diario;
    }

    public String getTipo_objetivo() {
        return tipo_objetivo;
    }

    public void setTipo_objetivo(String tipo_objetivo) {
        this.tipo_objetivo = tipo_objetivo;
    }

    public Date getFecha_inicio_objetivo() {
        return fecha_inicio_objetivo;
    }

    public void setFecha_inicio_objetivo(Date fecha_inicio_objetivo) {
        this.fecha_inicio_objetivo = fecha_inicio_objetivo;
    }

    public Date getFecha_fin_objetivo() {
        return fecha_fin_objetivo;
    }

    public void setFecha_fin_objetivo(Date fecha_fin_objetivo) {
        this.fecha_fin_objetivo = fecha_fin_objetivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
