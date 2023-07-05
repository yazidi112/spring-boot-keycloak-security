package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping("/hi")
    public String index(){
        return "hello to unsecured page";
    }
    @PreAuthorize("hasAuthority('user')")
    @GetMapping("/user")
    public String user(){
        return "this data are secured and viewed by user";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/admin")
    public String admin(){
        return "this data are secured and viewed only by admin";
    }
}
