package com.limpiahumos.LimpiaHumos.controller;

import com.limpiahumos.LimpiaHumos.entity.Metas;
import org.springframework.ui.Model;
import com.limpiahumos.LimpiaHumos.DAO.MetasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.limpiahumos.LimpiaHumos.controller.BaseController.BASE_CONTROLLER;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(MetasController.METAS_CONTROLLER)
public class MetasController {

    public static final String METAS_CONTROLLER = BASE_CONTROLLER + "/metas";

    @Autowired
    MetasDAO metasDAO;

    @GetMapping("")
    public String metas(@RequestParam("id_usuario") Long idUsuario,Model model) {
        List<Metas> metas = metasDAO.findAll();
        model.addAttribute("id_usuario", idUsuario);
        model.addAttribute("metas", metas);

        return "metas";
    }

}
