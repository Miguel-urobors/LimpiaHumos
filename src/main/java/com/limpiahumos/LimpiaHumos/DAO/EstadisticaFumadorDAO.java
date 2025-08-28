/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO;

import com.limpiahumos.LimpiaHumos.entity.EstadisticaFumador;

public interface EstadisticaFumadorDAO extends GenericDAO<EstadisticaFumador, Long> {

    EstadisticaFumador findUltimaEstadistica();
    
    EstadisticaFumador findUltimaEstadisticaPorUsuario(Long idUsuario);
}

