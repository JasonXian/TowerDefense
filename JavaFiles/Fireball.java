import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Methods and attributes for the fireball object
 * 
 * @Jason Xian 
 * @June 6
 */
public class Fireball extends Projectiles{
    private int x,y;
    private int speed;
    private int lobsterNum;
    private LobsterSpawner lobster;
    private Background world;

    //constructor for an fire object that the tower shoots, requires a lobster number to find the initial position and end position for the arrow
    public Fireball(int initX, int initY, int initSpeed, int initLobsterNum,int initLobsterType){
        super(initX, initY, initSpeed, initLobsterNum, initLobsterType);
    }   
}
