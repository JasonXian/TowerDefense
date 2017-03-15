import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Allows the player to exit the game to the title screen
 * 
 * @Jason Xian
 * @May 30
 */

public class Pause extends Actor{
    private int mX, mY;
    private boolean paused;
    
    //Creates the pause button on screen
    public Pause(){
        setImage(new GreenfootImage("Exit", 50, Color.BLACK, Color.BLUE));
        paused = false;
    }
    
    //Continously displays the pause
    public void act() {
        setImage(new GreenfootImage("Exit", 50, Color.BLACK, Color.BLUE));
        //Returns to the title screen if the player clicks this button
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new TitleScreen());
        }
    }    
}
