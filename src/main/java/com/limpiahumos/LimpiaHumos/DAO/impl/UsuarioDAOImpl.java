/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO.impl;

import com.limpiahumos.LimpiaHumos.DAO.UsuarioDAO;
import com.limpiahumos.LimpiaHumos.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class UsuarioDAOImpl implements UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario findById(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        return entityManager.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @Override
    public void save(Usuario usuario) {
        if (usuario.getId_usuario() == null) {
            entityManager.persist(usuario);
        } else {
            entityManager.merge(usuario);
        }
    }

    @Override
    public void update(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
        @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario findByNombreAndContraseña(String nombre, String contraseña) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.contraseña = :contraseña", Usuario.class)
                    .setParameter("nombre", nombre)
                    .setParameter("contraseña", contraseña)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
