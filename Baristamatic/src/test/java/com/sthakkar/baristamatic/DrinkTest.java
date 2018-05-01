/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sthakkar.baristamatic;

import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Sarah
 */
public class DrinkTest {

    Drink testDrink = null;

    public DrinkTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        testDrink = new Drink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});

    }

    @org.junit.Test
    public void testCompareToFalse() {
        System.out.println("compareTo");
        Drink testDrink2 = new Drink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"});
        assertNotEquals("comparable", -1, testDrink2.compareTo(testDrink));
    }

    public void testCompareToTrue() {
        System.out.println("compareTo");
        Drink testDrink3 = new Drink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});
        assertEquals("comparable", 0, testDrink3.compareTo(testDrink));
    }

    @org.junit.Test
    public void testSetRecipe() {
        System.out.println("setRecipe");
        testDrink.setRecipe(new String[]{"Espresso", "Espresso", "Espresso"});
        //  assertArrayEquals(String[]{"Espresso", "Espresso", "Espresso"}, testDrink.getRecipe(), String[]{"Espresso", "Espresso", "Espresso"});
    }

    @org.junit.Test
    //Null Test
    public void testSetDrinkNameNull() {
        System.out.println("setNameNull");
        testDrink.setDrinkName(null);
        assertNull(testDrink.getDrinkName());

    }

    //Empty Test 
    public void testSetDrinkNameEmpty() {
        System.out.println("setNameEmpty");
        testDrink.setDrinkName("");
        assertEquals(testDrink.getDrinkName(), "");

    }

    @org.junit.Test
    public void testSetCostPosValue() {
        System.out.println("setCost to value five");
        assertEquals(5.0, testDrink.getCost(), 5.0);
        assertEquals(0.0, testDrink.getCost(), 0.0);

    }

    @org.junit.Test
    public void testSetcanMake() {
        System.out.println("setMakeable False");
        boolean canMake;
        canMake = false;
        assertFalse(testDrink.getCanMake());
    }
    

    @org.junit.Test
    public void testGetRecipe() {
        System.out.println("getRecipe Americano");
       String[] recipe = {"Espresso", "Espresso", "Espresso"};
       testDrink.setRecipe(recipe);
       assertNotNull(testDrink.getRecipe());

   
        
    }

    @org.junit.Test
    public void testGetCost() {
        System.out.println("getCost Zero");
        assertEquals(testDrink.getCost(), 0, 0);

    }

    public void testGetCostNegative() {
        System.out.println("getCost Negative");
        testDrink.setCost(-1);
        assertTrue(testDrink.getCost() < 0);
    }

    @org.junit.Test
    public void testGetDrinkName() {
        System.out.println("get Drink Name");
        assertTrue(testDrink.getDrinkName(), true);
    }

    @org.junit.Test
    public void testGetCanMake() {
        System.out.println("getCanMake False");
        Drink instance = null;
        boolean expResult = false;
        assertFalse(testDrink.getCanMake());
    }

    @org.junit.Test
    public void testGetCanMakeTrue() {
        System.out.println("getCanMake True");
        Drink instance = null;
        boolean expResult = true;
        testDrink.setCanMake(true);
        assertTrue(testDrink.getCanMake());
    }

}
