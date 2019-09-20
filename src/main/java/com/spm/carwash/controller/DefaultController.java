package com.spm.carwash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Controller
public class DefaultController {
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}
