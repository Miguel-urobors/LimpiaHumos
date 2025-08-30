/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.controller;

import static com.limpiahumos.LimpiaHumos.controller.BaseController.BASE_CONTROLLER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ObjetivosController.OBEJTIVO_CONTROLLER)
public class ObjetivosController extends BaseController{
    
     public static final String OBEJTIVO_CONTROLLER= BASE_CONTROLLER+"/objetivos";

    @GetMapping("")
    public String inicio(Model model) {
        model.addAttribute("mensaje", "¡Has llegado a la página de inicio!");
        return "inicio";
    }
}