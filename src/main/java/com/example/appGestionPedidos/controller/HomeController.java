package com.example.appGestionPedidos.controller;

import com.example.appGestionPedidos.data.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping ("/")
    public String home(){
        return "home";
    }

    @GetMapping ("/userhome")
    public String userHome(HttpSession session, Model model){
        Object enSesion = session.getAttribute("user");

        if (enSesion == null){
            return "redirect:/login";
        }
        User usuario = (User) enSesion;
        model.addAttribute("user", usuario);
        return "userhome";
        }

}
