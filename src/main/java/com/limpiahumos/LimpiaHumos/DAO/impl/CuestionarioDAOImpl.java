/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.DAO.impl;

import com.limpiahumos.LimpiaHumos.DAO.CuestionarioDAO;
import com.limpiahumos.LimpiaHumos.entity.Cuestionario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CuestionarioDAOImpl extends GenericDAOImpl<Cuestionario, Long> implements CuestionarioDAO {
    public CuestionarioDAOImpl() {
        super(Cuestionario.class);
    }
}
