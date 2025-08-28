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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Table(name = "cuestionario")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cuestionario;

    @NotNull(message = "La edad en la que empezó a fumar no puede ser nula")
    @Min(value = 0, message = "La edad debe ser un número positivo o cero")
    private Integer edad_empezar;

    @NotNull(message = "El número de cigarrillos al día no puede ser nulo")
    @PositiveOrZero(message = "El número de cigarrillos al día debe ser cero o un número positivo")
    private Integer cigarrillos_dia;

    private String razon_parar;

    @NotNull(message = "El número de intentos para dejar de fumar no puede ser nulo")
    @Min(value = 0, message = "El número de intentos debe ser un número positivo o cero")
    private Integer intentos_parar;

    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Getters y Setters
    public Long getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(Long id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public Integer getEdad_empezar() {
        return edad_empezar;
    }

    public void setEdad_empezar(Integer edad_empezar) {
        this.edad_empezar = edad_empezar;
    }

    public Integer getCigarrillos_dia() {
        return cigarrillos_dia;
    }

    public void setCigarrillos_dia(Integer cigarrillos_dia) {
        this.cigarrillos_dia = cigarrillos_dia;
    }

    public String getRazon_parar() {
        return razon_parar;
    }

    public void setRazon_parar(String razon_parar) {
        this.razon_parar = razon_parar;
    }

    public Integer getIntentos_parar() {
        return intentos_parar;
    }

    public void setIntentos_parar(Integer intentos_parar) {
        this.intentos_parar = intentos_parar;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
