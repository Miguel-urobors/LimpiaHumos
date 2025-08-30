/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.controller;

import com.limpiahumos.LimpiaHumos.DAO.ObjetivosDAO;
import static com.limpiahumos.LimpiaHumos.controller.BaseController.BASE_CONTROLLER;
import com.limpiahumos.LimpiaHumos.entity.Objetivos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(ObjetivosController.OBEJTIVO_CONTROLLER)
public class ObjetivosController extends BaseController {

    public static final String OBEJTIVO_CONTROLLER = BASE_CONTROLLER + "/objetivos";

    @Autowired
    ObjetivosDAO objetivoDAO;

    @GetMapping("")
    public String mostrarObjetivos(@RequestParam("id_usuario") Long idUsuario, Model model) {
        List<Objetivos> objetivos = objetivoDAO.obtenerTodosObjetivos(idUsuario);
        model.addAttribute("objetivosList", objetivos);
        return "objetivosConsulta";
    }

    @GetMapping("/editar/{id}")
    public String editarObjetivo(@PathVariable Long id, Model model) {
        Objetivos objetivo = objetivoDAO.obtenerObjetivoPorId(id);
        model.addAttribute("objetivo", objetivo);
        return "editarObjetivo"; // Redirige a la página de edición
    }
    // Método para mostrar la página de creación de objetivos

    @GetMapping("/crear")
    public String crearObjetivoForm(Model model) {
        // Crear un nuevo objeto objetivo vacío
        Objetivos objetivo = new Objetivos();
        // Pasar el objeto vacío al modelo para que se pueda vincular en el formulario
        model.addAttribute("objetivo", objetivo);
        return "objetivosDetalle"; // Nombre de la vista para el formulario de creación
    }

    // Método para guardar el objetivo después de completar el formulario
    @PostMapping("/guardar")
    public String guardarObjetivo(@ModelAttribute Objetivos objetivo) {
        objetivoDAO.guardarObjetivo(objetivo);
        return "redirect:/objetivosConsulta"; // Redirigir a la página de consulta después de guardar
    }

}
