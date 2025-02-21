package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.userModel;

@Controller
public class IndexController {
    @GetMapping({"/","/index","/home"})
    
    public String index(Model model){
        
        model.addAttribute("titulo", "Hola Spring");
        
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        userModel usuario = new userModel();
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setEmail("juan.perez@example.com");

        model.addAttribute("usuario", usuario);

        return "perfil";
    }
}
