import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Displays and keeps track of the player's lives for the level
 * 
 * @Jason Xian
 * @May 30
 */

public class Lives extends Actor{
    private int lives;
    private Score score;
    private int scores;
    
    //Constructor for the lives object, requires an initial amount of lives to create
    public Lives(int initLives){
        setImage(new GreenfootImage("Lives:" + this.lives, 50, Color.BLACK, Color.WHITE));
        this.lives = initLives;
    }
    
    //Change the amount of lives
    public void setLives(int amount){        
        this.lives += amount;
        if(this.lives <= 0){
            Background world = (Background) getWorld();
            score = world.getScore();
            scores = score.getScore();
            Greenfoot.setWorld(new GameOverScreen(scores));
        }
    }
    
    //Returns the amount of lives left
    public int getLives(){
        return this.lives;
    }
    
    //Continously displays the amount of lives the player has left
    public void act() {
        setImage(new GreenfootImage("Lives:" + this.lives, 50, Color.BLACK, Color.WHITE));
    }    
}
