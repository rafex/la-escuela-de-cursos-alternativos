package mx.rafex.tutum.school.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/list")
    public String list() {
        return "list";
    }

    @GetMapping("/listStudent")
    public String listStudent() {
        return "listStudent";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
