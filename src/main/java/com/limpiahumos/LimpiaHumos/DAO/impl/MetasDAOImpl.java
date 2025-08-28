/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO.impl;

import com.limpiahumos.LimpiaHumos.DAO.MetasDAO;
import com.limpiahumos.LimpiaHumos.entity.Metas;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MetasDAOImpl extends GenericDAOImpl<Metas, Long> implements MetasDAO {
    public MetasDAOImpl() {
        super(Metas.class);
    }
}

