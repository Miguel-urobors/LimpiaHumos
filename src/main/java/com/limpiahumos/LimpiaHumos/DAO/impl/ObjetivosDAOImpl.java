/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO.impl;

import com.limpiahumos.LimpiaHumos.DAO.ObjetivosDAO;
import com.limpiahumos.LimpiaHumos.entity.Objetivos;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ObjetivosDAOImpl extends GenericDAOImpl<Objetivos, Long> implements ObjetivosDAO {
    public ObjetivosDAOImpl() {
        super(Objetivos.class);
    }
}

