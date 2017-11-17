import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Displays and keeps track of the player's money
 * 
 * @Jason Xian
 * @May 30
 */

public class Money extends Actor{
    private int money;
    
    //Creates a new moeny object that requires and intial amount of money
    public Money(int initMoney){
        this.money = initMoney;
        setImage(new GreenfootImage("Money:$" + this.money, 50, Color.BLACK, Color.WHITE));
    }
    
    //Changes the amount of money the player has
    public void setMoney(int amount){
        this.money += amount;
    }
    
    //Returns how much money the player currently has
    public int getMoney(){
        return this.money;
    }
    
    //Continously displays the amount of money the player has
    public void act() {
        setImage(new GreenfootImage("Money:$" + this.money, 50, Color.BLACK, Color.WHITE));
    }    
}
