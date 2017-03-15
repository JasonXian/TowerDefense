import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for all projectiles the towers shoot
 * 
 * @Jason Xian 
 * @June 6
 */
public class Projectiles extends Actor{
    private int x,y;
    private int speed;
    private int endX, endY, lobsterNum, lobsterType;
    private LobsterSpawner lobster;
    private Background world;
    
    //constructor for an arrow object that the tower shoots, requires an initial position and end position for the arrow and a speed for the projectile
    public Projectiles(int initX, int initY, int initSpeed, int initLobsterNum, int initLobsterType){
        this.x = initX;
        this.y = initY;
        this.speed = initSpeed;
        this.lobsterNum = initLobsterNum;
        this.lobsterType = initLobsterType;
    }
    
    //check to see if arrow reaches it's end location/target
    public boolean checkHit(){
        if((getX() >= this.endX - 20 && getX() <= this.endX + 20) && (getY() >= this.endY - 20 && getY() <= this.endY + 20)){
            return true;
        }
        return false;
    }
    
    //changes the end location the arrows are shot from based on where the location of the enemy is
    public void aim(){
        world = (Background) getWorld();
        lobster = world.getLobster();
        int lobsterX = lobster.getLobsterX(this.lobsterNum, this.lobsterType);
        int lobsterY = lobster.getLobsterY(this.lobsterNum, this.lobsterType);
        this.endX = lobsterX;
        this.endY = lobsterY;
    }
    
    //movement of the arrow and re-adjusts it's angle to make sure it reaches the end location
    public void act(){
        move(this.speed);
        aim();
        turnTowards(this.endX, this.endY);
    }    
}
