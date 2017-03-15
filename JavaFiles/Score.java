import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Display's the player's score
 * 
 * @Jason Xian
 * @May 30
 */

public class Score extends Actor{
    private int score;
    
    //Displays the score of the player
    public Score(int initScore){
        setImage(new GreenfootImage("Score:" + score, 50, Color.BLACK, Color.WHITE));
        this.score = initScore;
    }
    
    //Increases the player's score by a certain amount
    public void setScore(int amount){
        this.score += amount;
    }
    
    //Return the player's score
    public int getScore(){
        return this.score;
    }
    
    //Continously displays the player's score
    public void act() {
        setImage(new GreenfootImage("Score:" + score, 50, Color.BLACK, Color.WHITE));
    }    
}
