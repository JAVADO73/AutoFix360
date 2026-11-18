package com.example.appGestionPedidos.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.appGestionPedidos.data.User;
import com.example.appGestionPedidos.service.UserService;
import org.springframework.ui.Model;


import java.util.Optional;

@Slf4j
@Controller
public class LogController {

    private final UserService userService;

    public LogController(UserService userService){this.userService = userService;}


    @GetMapping("/login")
    public String getLogIn() {
        return "login";
    }

    // Model es la bolsa donde dejamos datos para que la plantilla los lea
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, HttpSession session, Model model){

        Optional<User> encontrado = userService.findByUsername(username);

        if (encontrado.isEmpty()){
            model.addAttribute("error","not found");
            return "login" ;
        }
        session.setAttribute("user", encontrado.get());
        return "redirect:/userhome";
    }


    @GetMapping("/logout")
    public String logoutGet(HttpSession session){
        return doLogout(session);
    }

    private String doLogout(HttpSession session){
        if (session != null){
            try{
                session.invalidate();
                log.info("Session invalidated successfully on logout.");
            }catch (IllegalStateException e){
                log.warn("La sesión fue invalidada", e);
            }
        }
        return "redirect:/";
    }
}
