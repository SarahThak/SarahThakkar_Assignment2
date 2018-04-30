/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sthakkar.baristamatic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sarah
 */
public class IngredientTest {

    Ingredient testIngredient = null;

    public IngredientTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testIngredient = new Ingredient("Espresso", 1.10);

    }

    @Test
    public void testCompareToPos() {
        System.out.println("compareTo");
        Ingredient testIngredient2 = new Ingredient("Espresso", 1.10);
        assertEquals("comparable", 0, testIngredient2.compareTo(testIngredient));
        // assertTrue(testIngredient2.compareTo(testIngredient) == 0);

    }

    @Test
    public void testSetIngredientNameNull() {
        System.out.println("setIngredientName Null");
        testIngredient.setIngredientName(null);
        assertNull(testIngredient.getIngredientName());
    }

    @Test
    public void testSetCost() {
        System.out.println("setCost to value 1.10");
        assertEquals(1.10, testIngredient.getCost(), 1.10);
    }

    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 10;
        testIngredient.setStock(10);
        assertEquals(10, testIngredient.getStock(), 10);
    }

    @Test
    public void testGetIngredientNamePos() {
        System.out.println("getIngredientName");
        assertEquals("Espresso", testIngredient.getIngredientName(), "Espresso");

    }

    @Test
    public void testGetIngredientNameNeg() {
        System.out.println("getIngredientName");
        assertFalse("Cocao".equals(testIngredient.getIngredientName()));

    }

    @Test
    public void testGetCost() {
        System.out.println("getCost");
        assertEquals(1.10, testIngredient.getCost(), 1.10);
    }

    @Test
    public void testGetStock() {
        System.out.println("getStock");
        testIngredient.setStock(10);
        assertEquals(10, testIngredient.getStock(), 10);
    }

}
