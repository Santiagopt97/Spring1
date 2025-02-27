package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
    @GetMapping({"/","/index","/home"})
    public String index(Model model) {  //usar siempre el Model de Spring
        model.addAttribute("titulo", "Enviar parametros de la ruta con @PathVariable");
        return "Params/index";
    }

    @GetMapping("/string") //http://localhost:8081/param/string?texto=hola asi se ve un ejemplo
    public String param(@RequestParam String texto, Model model) {
        model.addAttribute("titulo", "Recibir parametros del request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "Params/param";

    }

    @GetMapping("/mix-params") //http://localhost:8081/params/mix-params?texto=hola&&numero=2 asi se ve un ejemplo
    public String variables(@RequestParam (name="saludo", required = false, defaultValue = "ingresa un texto")String texto, @RequestParam Integer numero, Model model) { //en requestparam no se puede usar int, debe ser integer
        model.addAttribute("titulo", "Recibir parametros del request HTTP GET");
        model.addAttribute("resultado", "El texto enviado es: " + texto +" y el numero es: " + numero);
        return "Params/param";

    }
}
