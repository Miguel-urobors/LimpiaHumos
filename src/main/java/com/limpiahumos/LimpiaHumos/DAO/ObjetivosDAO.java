/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO;

import com.limpiahumos.LimpiaHumos.entity.Objetivos;
import java.util.List;

public interface ObjetivosDAO extends GenericDAO<Objetivos, Long> {

        public List<Objetivos> obtenerTodosObjetivos(Long idUsuario);
        public Objetivos obtenerObjetivoPorId(Long id);
        public Objetivos guardarObjetivo(Objetivos objetivo);
        public Objetivos crearObjetivo(Objetivos objetivo);
}
