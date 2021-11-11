package com.qiuye.see.mini.controllers;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SEEMini
 * @description:
 * @author: qiu ye
 * @create: 2021-09-29 21:54
 */
@RestController
public class CalcController {


    @GetMapping("/test")
    public String test(){
        return "hello";
    }

//    @PostMapping(value = "/add")
//    public String add(@RequestParam(value = "op1") String op1, @RequestParam(value = "op2") String op2){
//        int result = Integer.parseInt(op1) + Integer.parseInt(op2);
//        return  String.valueOf(result);
//    }


    @PostMapping(value = "/add")
    public String add(@RequestParam(value = "op1") int op1, @RequestParam(value = "op2") int op2){
        int result = op1 + op2;
        return  String.valueOf(result);
    }
}

