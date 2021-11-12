package com.qiuye.see.mini.controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcControllerTest {
    private CalcController calcController = new CalcController();

    @Test
    public void add() {
        int x = 1;
        int y = 2;
        assertEquals("3", calcController.add(x,y));
    }
}