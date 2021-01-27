package br.com.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home"; //--> Nome da view que sera aberta
        //Essa view TEM QUE estar dentro de: /WEB-INF/views/ e deve deve ter a extensao .jsp
        //Essa regra eh configurada dentro do metodo getViewResolver em MvcConfiguration
    }
}
