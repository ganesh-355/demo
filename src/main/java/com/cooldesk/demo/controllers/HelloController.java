package com.cooldesk.demo.controllers;

import com.cooldesk.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloGanesh()
    {
        return "Hi Ganesh, Welcome to spring boot";
    }

    @GetMapping("/users")
    public User getUsers()
    {
        User user = new User();
        user.setId(1);
        user.setName("Ganesh");
        user.setEmail("ganesh@gmail.com");

        return user;
    }

    @GetMapping("/users/{id}/{id2}")
    public String getUser(@PathVariable String id, @PathVariable("id2") String name)
    {
        return "path variable is : "+ id+" name the user is - "+name;
    }

    @GetMapping("/rP")
    public String getUserDetails(@RequestParam String name, @RequestParam(name = "email", defaultValue = "") String emailId)
    {
        return "Name is : "+name+" and Email is : "+emailId;
    }
}
