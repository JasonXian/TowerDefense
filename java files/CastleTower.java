import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Attributes of the CastleTower
 * 
 * @Jason Xian
 * @June 6
 */
public class CastleTower extends Tower {
    private int x;
    private int y;
    private int attack;
    private boolean alive, attacking;
    private int lobsterNum, lobsterX, lobsterY;
    
    //Constructor for the tower, by default it is not "alive" as when it is first created it is waiting to be placed, default attack is 1
    public CastleTower(){
        super(1, 5, 2, 0, 200);
    }
}
