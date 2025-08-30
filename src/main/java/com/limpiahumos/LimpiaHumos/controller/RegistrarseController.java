/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limpiahumos.LimpiaHumos.controller;

import com.limpiahumos.LimpiaHumos.DAO.CuestionarioDAO;
import com.limpiahumos.LimpiaHumos.DAO.EstadisticaFumadorDAO;
import com.limpiahumos.LimpiaHumos.DAO.UsuarioDAO;
import com.limpiahumos.LimpiaHumos.entity.EstadisticaFumador;
import com.limpiahumos.LimpiaHumos.entity.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RegistrarseController.REGISTRARSE_CONTROLLER)
public class RegistrarseController extends BaseController{
    
    
    
    
   public static final String REGISTRARSE_CONTROLLER = BASE_CONTROLLER+"/registrarse";
   
   @Autowired
   private UsuarioDAO usarioDAO;
   
   @Autowired
   private EstadisticaFumadorDAO estadisticaFumadorDAO;
   
   @Autowired
   private CuestionarioDAO cuestionarioDAO;
   
    
    @GetMapping("")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }
   
    /**
     *
     * @param usuario
     * @param result
     * @param model
     * @return
     */
   @Transactional
   @PostMapping("/crearUsuario")
    public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,BindingResult result,Model model) {
        
    if (result.hasErrors()) {
        return "registro";
    }
    if (usuario.getCuestionario() != null && usuario.getCuestionario().getId_cuestionario() == null) {
        cuestionarioDAO.save(usuario.getCuestionario());
    }
     usuario.setEstadisticaFumador( iniciarEstadisticas(usuario));
        for (EstadisticaFumador ef : usuario.getEstadisticaFumador()) {
            estadisticaFumadorDAO.save(ef);
        }
    usarioDAO.save(usuario);

    return "redirect:"+BASE_CONTROLLER+"/datos?id_usuario=" + usuario.getId_usuario();
    
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "fecha_nacimiento", new CustomDateEditor(dateFormat, true));
    }
    
    private List<EstadisticaFumador> iniciarEstadisticas(Usuario usaurio){
        
    EstadisticaFumador estadisticasFumador= new EstadisticaFumador();
    estadisticasFumador.setUsuario(usaurio);
    estadisticasFumador.setCigarillos_no_fumados(0L);
    estadisticasFumador.setDinero_ahorrado(0L);
    estadisticasFumador.setTiempo_sin_fumar(0L);
    estadisticasFumador.setFecha_estadistica(new Date());
    List<EstadisticaFumador> ListaEF= new ArrayList<>();
    ListaEF.add(estadisticasFumador);
    return ListaEF;
     
    }
}
