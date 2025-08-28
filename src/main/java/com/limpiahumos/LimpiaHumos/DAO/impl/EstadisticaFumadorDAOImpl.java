/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO.impl;

import com.limpiahumos.LimpiaHumos.DAO.EstadisticaFumadorDAO;
import com.limpiahumos.LimpiaHumos.entity.EstadisticaFumador;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EstadisticaFumadorDAOImpl extends GenericDAOImpl<EstadisticaFumador, Long> implements EstadisticaFumadorDAO {
    public EstadisticaFumadorDAOImpl() {
        super(EstadisticaFumador.class);
    }
    
     @Override
    public EstadisticaFumador findUltimaEstadistica() {
        try {
            return em.createQuery(
                    "SELECT e FROM EstadisticaFumador e ORDER BY e.fecha_estadistica DESC",
                    EstadisticaFumador.class
            )
            .setMaxResults(1)
            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
    public EstadisticaFumador findUltimaEstadisticaPorUsuario(Long idUsuario) {
    try {
        return em.createQuery(
                "SELECT e FROM EstadisticaFumador e WHERE e.usuario.id_usuario = :idUsuario ORDER BY e.fecha_estadistica DESC",
                EstadisticaFumador.class
        )
        .setParameter("idUsuario", idUsuario)  // Establecer el parámetro del ID de usuario
        .setMaxResults(1)  // Limitar la consulta a un solo resultado (la última estadística)
        .getSingleResult();  // Obtener el resultado
    } catch (NoResultException e) {
        return null;  // Si no se encuentran estadísticas, devolver null
    }
}
}