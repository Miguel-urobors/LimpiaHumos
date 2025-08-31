/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.controller;

import com.limpiahumos.LimpiaHumos.DAO.ObjetivosDAO;
import com.limpiahumos.LimpiaHumos.DAO.UsuarioDAO;
import static com.limpiahumos.LimpiaHumos.controller.BaseController.BASE_CONTROLLER;
import com.limpiahumos.LimpiaHumos.entity.Objetivos;
import com.limpiahumos.LimpiaHumos.entity.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
    
    @Autowired
    UsuarioDAO usuarioDAO;

    @GetMapping("")
    public String mostrarObjetivos(@RequestParam("id_usuario") Long idUsuario, Model model) {
        List<Objetivos> objetivos = objetivoDAO.obtenerTodosObjetivos(idUsuario);
        model.addAttribute("objetivosList", objetivos);
        model.addAttribute("id_usuario", idUsuario);
        model.addAttribute("titulo", "CREAR OBJETIVO");
        return "objetivosConsulta";
    }

    @GetMapping("/editar/{id}")
    public String editarObjetivo(@PathVariable Long id, Model model) {
        Objetivos objetivo = objetivoDAO.obtenerObjetivoPorId(id);
        model.addAttribute("objetivo", objetivo);
        model.addAttribute("titulo", "EDITAR OBJETIVO");
        return "objetivosDetalle"; // Redirige a la página de edición
    }
    // Método para mostrar la página de creación de objetivos

    @GetMapping("/crear")
    public String crearObjetivoForm(@RequestParam("id_usuario")Long idUsuari, Model model) {
        
        model.addAttribute("id_usuario",idUsuari);
        // Crear un nuevo objeto objetivo vacío
        Objetivos objetivo = new Objetivos();
        // Pasar el objeto vacío al modelo para que se pueda vincular en el formulario
        model.addAttribute("objetivo", objetivo);
        return "objetivosDetalle"; // Nombre de la vista para el formulario de creación
    }

    @PostMapping("/guardar")
    public String guardarObjetivo(@RequestParam("id_usuario") Long idUsuario,
                                @ModelAttribute("objetivo") Objetivos objetivo,
                                Model model) {
        // Asignar el usuario con el id_usuario
        Usuario usuario = new Usuario();
        usuario.setId_usuario(idUsuario);
        objetivo.setUsuario(usuario);

        // Guardar el objetivo en la base de datos
        objetivoDAO.guardarObjetivo(objetivo);

        // Redirigir al listado de objetivos
        return "redirect:/limpiaHumos/objetivos?id_usuario="+idUsuario;
    }
    
  // Conversor para las fechas
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
