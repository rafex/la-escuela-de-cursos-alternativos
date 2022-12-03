package mx.rafex.tutum.school.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/list")
    public String list() {
        return "list";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }
}
