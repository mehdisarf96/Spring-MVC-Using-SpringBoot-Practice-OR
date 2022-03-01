package com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/")
    public String greeting() {
        return "hello"; // specifying the template name
    }
}
