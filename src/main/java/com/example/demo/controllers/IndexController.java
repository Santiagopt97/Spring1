package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.userModel;

@Controller
@RequestMapping("/app") //ruta base
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

    @GetMapping("/listar")
    public String listar(Model model) {
        List<userModel> usuarios = new ArrayList<>();
        usuarios.add(new userModel("Andres", "Guzman", "jp@correo.com"));
        usuarios.add(new userModel("John", "Doe", "js@correo.com"));
        usuarios.add(new userModel("Valeria", "Piedrahita", "vp@correo.com"));

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("titulo", "Lista de usuarios");

        
        return "listar";
    }
}
