import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;


/**
 * Attributes of the Robot Tower
 * 
 * @Jason Xian
 * @June 6
 */
public class RobotTower extends Tower{
    private int x;
    private int y;
    private int attack;
    private boolean alive, attacking;
    private int lobsterNum, lobsterX, lobsterY;

    //when creating a new robot tower, it will not attack, as it is being held by the cursor, default damage of the tower 3;
    public RobotTower(){
        super(3, 5, 20, 2, 250);
    }    
}
