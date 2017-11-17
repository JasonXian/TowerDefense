import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Display's the prices of a certain tower
 * 
 * @Jason Xian
 * @May 30
 */

public class TowerPrices extends Actor{
    private int price;
    
    //Creates the text based off of an intial price
    public TowerPrices(int initPrice){
        this.price = initPrice;
        setImage(new GreenfootImage("$" + this.price, 50, Color.BLACK, Color.BLUE));
    }
    
    //Change the price of the tower based on a set amount
    public void changePrice(int amount){
        this.price += amount;
    }
    
    //Returns the price of this specific tower
    public int getPrice(){
        return this.price;
    }
    
    //Continously displays the price of the tower
    public void act() {
        setImage(new GreenfootImage("$" + this.price, 50, Color.BLACK, Color.BLUE));
    }    
}
