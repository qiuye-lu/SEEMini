package com.qiuye.see.mini.controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcControllerTest {
    private CalcController calcController = new CalcController();

// corect calculation

    @Test
    public void add() {
        int x = 1;
        int y = 2;
        assertEquals("3", calcController.add(x,y));
    }


// incorrect calculation
/*
    @Test
    public void add() {
        int x = 1;
        int y = 2;
        assertEquals("4", calcController.add(x,y));
    }
*/


}
