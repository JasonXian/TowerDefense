import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Attributes of the Fire Tower
 * 
 * @Jason Xian
 * @June 6
 */
public class FireTower extends Tower{
    private int x;
    private int y;
    private int attack;
    private boolean alive, attacking;
    private int lobsterNum, lobsterX, lobsterY;

    //when creating a new fire tower, it will not attack, as it is being held by the cursor, default damage of the tower 9;
    public FireTower(){
        super(9, 5, 8, 3, 400);
    }       
}
