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

//  Code with correct calculation
/*    @PostMapping(value = "/add")
    public String add(@RequestParam(value = "op1") int op1, @RequestParam(value = "op2") int op2){
        int result = op1 + op2;
        return  String.valueOf(result);
    }
*/

//  Code with incorrect calculation
/*
    @PostMapping(value = "/add")
    public String add(@RequestParam(value = "op1") int op1, @RequestParam(value = "op2") int op2){
        int result = op1 + op2 + 1;
        return  String.valueOf(result);
    }

*/

//  Code with compilation error

    @PostMapping(value = "/add")
    public String add(@RequestParam(value = "op1") int op1, @RequestParam(value = "op2") int op2){
        int result = op1 + op2
        return  String.valueOf(result);
    }

}


