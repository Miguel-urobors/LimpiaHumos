/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.controller;

import com.limpiahumos.LimpiaHumos.DAO.CuestionarioDAO;
import com.limpiahumos.LimpiaHumos.DAO.EstadisticaFumadorDAO;

import static com.limpiahumos.LimpiaHumos.controller.BaseController.BASE_CONTROLLER;

import com.limpiahumos.LimpiaHumos.entity.Cuestionario;
import com.limpiahumos.LimpiaHumos.entity.EstadisticaFumador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
@RequestMapping(DatosController.DATOS_CONTROLLER)
public class DatosController {

    public static final String DATOS_CONTROLLER = BASE_CONTROLLER + "/datos";

    @Autowired
    EstadisticaFumadorDAO estadisticaFumadorDAO;

    @Autowired
    CuestionarioDAO cuestionarioDAO;

    @GetMapping("")
    public String doInt(@RequestParam("id_usuario") Long idUsuario, Model model) {

        // Llamar al método para obtener las estadísticas del usuario
        EstadisticaFumador estadisticas = estadisticaFumadorDAO.findUltimaEstadisticaPorUsuario(idUsuario);

        Cuestionario cuestionario = cuestionarioDAO.findById(idUsuario);
        estadisticas = calcularAhorro(estadisticas,cuestionario);

        // Pasar las estadísticas al modelo
        model.addAttribute("estadisticas", estadisticas);

        return "datos";
    }

    private EstadisticaFumador calcularAhorro (EstadisticaFumador estadisticas, Cuestionario cuestionario) {
        Date fechaInicio = estadisticas.getFecha_estadistica();
        long cigarrillosDia = cuestionario.getCigarrillos_dia();

        LocalDate temp = new java.sql.Date(fechaInicio.getTime()).toLocalDate();

        long numeroDiasSinFumeque = ChronoUnit.DAYS.between(temp, LocalDate.now());
        estadisticas.setTiempo_sin_fumar(numeroDiasSinFumeque);

        long cigarrillosSinFumar = numeroDiasSinFumeque*cigarrillosDia;
        estadisticas.setCigarillos_no_fumados(cigarrillosSinFumar);

        //A la hora de representar dividir entre 100
        long dineroAhorrado = cigarrillosSinFumar*33;
        estadisticas.setDinero_ahorrado(dineroAhorrado);

        return estadisticas;
    }
}
