/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.controller;

import com.limpiahumos.LimpiaHumos.DAO.EstadisticaFumadorDAO;
import static com.limpiahumos.LimpiaHumos.controller.BaseController.BASE_CONTROLLER;
import com.limpiahumos.LimpiaHumos.entity.EstadisticaFumador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(DatosController.DATOS_CONTROLLER)
public class DatosController {
    
    public static final String DATOS_CONTROLLER= BASE_CONTROLLER+"/datos";
    
    @Autowired
    EstadisticaFumadorDAO estadisticaFumadorDAO;
    
    @GetMapping("")
    public String doInt(@RequestParam Long idUsuario,Model model) {
    
    // Llamar al método para obtener las estadísticas del usuario
    EstadisticaFumador estadistica = estadisticaFumadorDAO.findUltimaEstadisticaPorUsuario(idUsuario);
    
    // Pasar las estadísticas al modelo
    model.addAttribute("estadistica", estadistica);
      
        return "datos";
    }
}
