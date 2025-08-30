/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.controller;

import com.limpiahumos.LimpiaHumos.DAO.UsuarioDAO;
import static com.limpiahumos.LimpiaHumos.controller.BaseController.BASE_CONTROLLER;
import com.limpiahumos.LimpiaHumos.entity.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(InicioController.INICIO_CONTROLLER)
public class InicioController extends BaseController{
    
     public static final String INICIO_CONTROLLER= BASE_CONTROLLER+"/inicio";
     
     @Autowired
     UsuarioDAO usarioDao;

    @GetMapping("")
    public String inicio(Model model) {
        model.addAttribute("mensaje", "¡Has llegado a la página de inicio!");
        model.addAttribute("usuarioLogin", new Usuario());
        return "inicio";
    }
    
       @PostMapping("/login")
    public String login(@RequestParam("nombre") String correo,
                        @RequestParam("contraseña") String contraseña,
                        Model model,
                        HttpSession session) {

        Usuario usuario = usarioDao.findByNombreAndContraseña(correo, contraseña);

        if (usuario != null) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:"+BASE_CONTROLLER+"/datos?id_usuario=" + usuario.getId_usuario();
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            model.addAttribute("mensaje", "¡Has llegado a la página de inicio!");
            return "inicio";
        }
    }
}