/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "metas")
public class Metas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_metas;

    private String nombre;
    
    private String condición;
    
    private Boolean desbloqueada;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_desbloqueo;

    @ManyToMany(mappedBy = "metas")
    private List<Usuario> usuarios;

    // Getters y Setters

    public Boolean getDesbloqueada() {
        return desbloqueada;
    }

    public void setDesbloqueada(Boolean desbloqueada) {
        this.desbloqueada = desbloqueada;
    }

    public Long getId_metas() {
        return id_metas;
    }

    public void setId_metas(Long id_metas) {
        this.id_metas = id_metas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondición() {
        return condición;
    }

    public void setCondición(String condición) {
        this.condición = condición;
    }

    public Date getFecha_desbloqueo() {
        return fecha_desbloqueo;
    }

    public void setFecha_desbloqueo(Date fecha_desbloqueo) {
        this.fecha_desbloqueo = fecha_desbloqueo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
