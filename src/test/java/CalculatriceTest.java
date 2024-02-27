package com.example.demo;

import static org.junit.Assert.*;
import org.junit.Test;

import com.example.demo.Calculatrice; // Assurez-vous que le chemin d'importation est correct

public class CalculatriceTest {

    @Test
    public void testAdd() {
        assertEquals(Integer.valueOf(5), Calculatrice.add(2, 3));
    }

    @Test
    public void testMulti() {
        assertEquals(Integer.valueOf(6), Calculatrice.multi(2, 3));
    }

    @Test
    public void testDiv() {
        assertEquals(Integer.valueOf(2), Calculatrice.div(6, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivByZero() {
        Calculatrice.div(6, 0);
    }
}
