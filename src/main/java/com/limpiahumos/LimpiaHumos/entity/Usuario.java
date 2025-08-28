/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edad;

    @NotBlank(message = "El genero no puede estar vacío")
    private String genero;

    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    @NotNull(message = "La edad es obligatoria")
    private String contraseña;

    @NotNull(message = "La edad es obligatoria")
    private String correo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstadisticaFumador> estadisticaFumador = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Cuestionario cuestionario;

    @ManyToMany
    @JoinTable(
            name = "usuario_metas",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_metas")
    )
    private List<Metas> metas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Objetivos> objetivos = new ArrayList<>();

    // Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<EstadisticaFumador> getEstadisticaFumador() {
        return estadisticaFumador;
    }

    public void setEstadisticaFumador(List<EstadisticaFumador> estadisticaFumador) {
        this.estadisticaFumador = estadisticaFumador;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public List<Metas> getMetas() {
        return metas;
    }

    public void setMetas(List<Metas> metas) {
        this.metas = metas;
    }

    public List<Objetivos> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List<Objetivos> objetivos) {
        this.objetivos = objetivos;
    }

}
