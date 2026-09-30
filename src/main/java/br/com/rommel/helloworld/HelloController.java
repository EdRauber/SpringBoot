package br.com.rommel.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message","Hello World!");

        return "home";
    }

    @GetMapping("/message/{msg}")
    public String message(@PathVariable(value = "msg") String msg, Model model){
        model.addAttribute("message",msg);
        return "home";
    }
}