package com.example.servingwebcontent;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String voidPage(Map<String, Object> model){
        model.put("echo","void");
        return "void";

    }

    @GetMapping("/allusers")
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "main";
    }

    @PostMapping("/allusers")
    public String addNewUser (
            @RequestParam String name,
            @RequestParam String email,
            Map<String, Object> model
    ) {
        User n = new User(name, email);
        userRepository.save(n);

        Iterable<User> users = userRepository.findAll();
        model.put("users", users);

        return "main";
    }
}