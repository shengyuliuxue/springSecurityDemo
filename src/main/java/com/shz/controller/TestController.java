package com.shz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/security")
    public String hello(){
        return "hello spring security";
    }

    @GetMapping("/hellob")
    @PreAuthorize(value = "hasAnyRole('admin','user')")
    public String helloUserAndAdmin(){
        return "user和admin角色都可以访问";
    }

    @GetMapping("/admin")
    @PreAuthorize(value = "hasAnyRole('admin')")
    public String helloAdmin(){
        return "只有admin可以访问";
    }
}
