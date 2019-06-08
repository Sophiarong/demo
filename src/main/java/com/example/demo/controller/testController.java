package com.example.demo.controller;

import com.example.demo.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {
    @Autowired
    private InstructionService instructionService;
    @ResponseBody
    @RequestMapping(value = "/k")
    public void test(String expId){
        instructionService.queryChangeInsStatus(expId);
    }
}
