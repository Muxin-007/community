package muxin.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndeController {

    @GetMapping("/")
    public String index() { return "index";}
}