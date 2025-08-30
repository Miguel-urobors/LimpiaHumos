/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO;

import com.limpiahumos.LimpiaHumos.entity.Usuario;

 public interface UsuarioDAO extends GenericDAO<Usuario, Long> {
 
     Usuario findByNombreAndContraseña(String nombre, String contraseña);
 }
