import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Methods and attributes for the arrow object
 * 
 * @Jason Xian 
 * @June 6
 */
public class Arrow extends Projectiles{
    private int x,y;
    private int speed;
    private int endX, endY, lobsterNum;
    private LobsterSpawner lobster;
    private Background world;
    
    
    //constructor for an arrow object that the tower shoots, requires an initial position and end position for the arrow
    public Arrow(int initX, int initY, int initSpeed, int initLobsterNum, int initLobsterType){
        super(initX, initY, initSpeed, initLobsterNum, initLobsterType);
    }    
}
