/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sthakkar.baristamatic;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Sarah
 */
public final class Drink implements Comparable<Drink>{
    private Map<String, Integer> recipe = new HashMap<String, Integer>();
    private String name;
    private double totalCost = 0;
    private boolean canMake = false;

    public Drink(String name, String[] recipe){
        this.name = name;
        setRecipe(recipe);
    }

    @Override
    public int compareTo(Drink drink){
        return name.compareTo(drink.getName());
    }

    public void setRecipe(String[] recipe){
        for(String s : recipe){
            if(this.recipe.containsKey(s)){
                this.recipe.put(s, this.recipe.get(s)+1);//increment if multiple units
            }else{
                this.recipe.put(s, 1);//insert first occurrence of ingredient
            }
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCost(double totalCost){
        this.totalCost = totalCost;
    }

    public void setCanMake(boolean canMake){
        this.canMake = canMake;
    }

    public Map<String, Integer> getRecipe(){
        return recipe;
    }

    public double getCost(){
        return totalCost;
    }

    public String getName(){
        return name;
    }

    public boolean getCanMake(){
        return canMake;
    }

}
    

