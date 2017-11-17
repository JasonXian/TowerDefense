import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end location for all the lobsters, if they reach this the player loses a life
 * 
 * @Jason Xian
 * @June 6
 */
public class SecretFormula extends Actor{
    private int x, y;
    
    public SecretFormula(int initX, int initY){
        this.x = initX;
        this.y = initY;
    }
    
    public int getEndX(){
        return this.x;
    }
    
    public int getEndY(){
        return this.y;
    }
}
