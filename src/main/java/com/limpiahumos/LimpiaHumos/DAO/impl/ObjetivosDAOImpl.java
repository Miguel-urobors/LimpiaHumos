/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO.impl;

import com.limpiahumos.LimpiaHumos.DAO.ObjetivosDAO;
import com.limpiahumos.LimpiaHumos.entity.Objetivos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ObjetivosDAOImpl extends GenericDAOImpl<Objetivos, Long> implements ObjetivosDAO {

    public ObjetivosDAOImpl() {
        super(Objetivos.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Objetivos> obtenerTodosObjetivos(Long idUsuario) {
        // Crear la consulta JPQL para obtener todos los objetivos de un usuario específico
        String jpql = "SELECT o FROM Objetivos o WHERE o.usuario.id_usuario = :idUsuario";
        return entityManager.createQuery(jpql, Objetivos.class)
                .setParameter("idUsuario", idUsuario) // Pasar el ID del usuario como parámetro
                .getResultList();
    }

    @Override
    public Objetivos obtenerObjetivoPorId(Long id) {
        return entityManager.find(Objetivos.class, id);
    }

    @Override
    public Objetivos crearObjetivo(Objetivos objetivo) {
        // Usar persist() para guardar un nuevo objetivo en la base de datos
        entityManager.persist(objetivo);
        return objetivo; // Retorna el objeto guardado (con ID asignado si es nuevo)
    }

    @Override
    public Objetivos guardarObjetivo(Objetivos objetivo) {

        return entityManager.merge(objetivo);
    }
    

}
