/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sthakkar.baristamatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Sarah
 */
public class Machine {
    
      private static List<Drink> drinkList = new ArrayList<Drink>();
    private static List<Ingredient> ingredientList = new ArrayList<Ingredient>();

    public static void main(String[] args) {
        addAllIngredients();
        addAllDrinks();
        updateCosts();
        updateMakeable();
        display();
        startProgram();
    }

    public static void startProgram(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        
        while(true){            
            try {
               
                input = reader.readLine().toLowerCase();

                if(input.equals("")){
                    continue;
                }else if (input.equals("q")){ 
                    System.exit(0); 
                }else if(input.equals("r")){ 
                    restockIngredients();
                    updateMakeable();
                }else if(Integer.parseInt(input) > 0 && Integer.parseInt(input) <= drinkList.size()){ 
                    makeDrink(drinkList.get(Integer.parseInt(input)-1));
                }else{
                    throw new IOException();//legal, but invalid input
                }
            } catch (Exception e) {
                System.out.println("Invalid selection: " + input + "\n");
            }
        }    
    }

    public static void display(){
        System.out.println("Inventory:\n");
        ingredientList.forEach((i) -> {
            System.out.println(i.getIngredientName() + "," + i.getStock() + "\n");
          });

        System.out.println("Menu:\n");
        int count = 1;
          for (Iterator<Drink> it = drinkList.iterator(); it.hasNext();) {
              Drink d = it.next();
              System.out.printf("%d,%s,$%.2f," + d.getCanMake() + "\n\n", count, d.getDrinkName(), d.getCost());
              count++;
          }
    }

    public static void updateMakeable(){
        for (Drink d : drinkList){
            Map<String, Integer> currRecipe = d.getRecipe();
            for (Ingredient i : ingredientList){
                if (currRecipe.containsKey(i.getIngredientName()) && i.getStock() < currRecipe.get(i.getIngredientName())){
                    d.setCanMake(false);
                    break;
                }
                d.setCanMake(true);
            }
        }
    }

    public static void updateCosts(){
        drinkList.forEach((d) -> {
            double currCost = 0;
            Map<String, Integer> currRecipe = d.getRecipe();
            for (Ingredient i : ingredientList){
                if (currRecipe.containsKey(i.getIngredientName())){
                    currCost += i.getCost()*currRecipe.get(i.getIngredientName());
                }
            }
            d.setCost(currCost);
          }); 
    }

    public static void makeDrink(Drink drink){
        if(drink.getCanMake()){
            System.out.println("Dispensing: " + drink.getDrinkName() + "\n");
            for (Ingredient ingredient : ingredientList){
                if(drink.getRecipe().containsKey(ingredient.getIngredientName())){
                    ingredient.setStock(ingredient.getStock()-drink.getRecipe().get(ingredient.getIngredientName()));
                }
            }
        }else{
            System.out.println("Out of stock: " + drink.getDrinkName() + "\n");
        }
        updateMakeable();
        display();
    }

    public static void restockIngredients(){
        for(Ingredient ingredient : ingredientList){
            ingredient.setStock(10);
        }
        updateMakeable();
        display();
    }

    public static void addIngredient(Ingredient ingredient){
        ingredientList.add(ingredient);
    }
    
    public static void addDrink(String drinkName, String[] recipe){
        drinkList.add(new Drink(drinkName, recipe));
    }

    public static void addAllIngredients(){
        addIngredient(new Ingredient("Coffee", 0.75));
        addIngredient(new Ingredient("Decaf Coffee", 0.75));
        addIngredient(new Ingredient("Sugar", 0.25));
        addIngredient(new Ingredient("Cream", 0.25));
        addIngredient(new Ingredient("Steamed Milk", 0.35));
        addIngredient(new Ingredient("Foamed Milk", 0.35));
        addIngredient(new Ingredient("Espresso", 1.10));
        addIngredient(new Ingredient("Cocoa", 0.90));
        addIngredient(new Ingredient("Whipped Cream", 1.00));   

        Collections.sort(ingredientList);
    }

    public static void addAllDrinks(){  
        addDrink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"});
        addDrink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"});
        addDrink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"});
        addDrink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});
        addDrink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"});
        addDrink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"});

        Collections.sort(drinkList);
    }


}
