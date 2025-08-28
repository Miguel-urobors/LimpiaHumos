/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO.impl;

import com.limpiahumos.LimpiaHumos.DAO.GenericDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager em;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
    
}

