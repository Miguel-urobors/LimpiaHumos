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
@RequestMapping(InicioController.INICIO_CONTROLLER)
public class InicioController extends BaseController{
    
     public static final String INICIO_CONTROLLER= BASE_CONTROLLER+"/inicio";

    @GetMapping("")
    public String inicio(Model model) {
        model.addAttribute("mensaje", "¡Has llegado a la página de inicio!");
        return "inicio"; // Mapea a /WEB-INF/jsp/inicio.jsp
    }
}