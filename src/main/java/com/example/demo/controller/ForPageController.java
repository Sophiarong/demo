package com.example.demo.controller;

import com.example.demo.entity.ExpPastForPage;
import com.example.demo.entity.ExpRunningForPage;
import com.example.demo.service.ExpPastForPageService;
import com.example.demo.service.ExpRunningForPageService;
import com.example.demo.service.ExpSaveForPageService;
import com.example.demo.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ForPageController {
    @Autowired
    private ExpPastForPageService expPastForPageService;
    @Autowired
    private ExpSaveForPageService expSaveForPageService;
    @Autowired
    private ExpRunningForPageService expRunningForPageService;
    @ResponseBody
    @RequestMapping("/pageexp")
    public Page showPage(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size,@RequestParam(value = "target") String target){
        if(target.equals("endexp")){
            return expPastForPageService.getPage(page,size);
        }else if(target.equals("saveexp")) {
            return expSaveForPageService.getPage(page, size);
        }else if(target.equals("runningexp")) {
            return expRunningForPageService.getPage(page, size);
        }
        return null;
    }
}
