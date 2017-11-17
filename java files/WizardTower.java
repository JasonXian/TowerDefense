import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;


/**
 * Attributes of the Wizard Tower
 * 
 * @Jason Xian
 * @June 6
 */
public class WizardTower extends Tower{
    private int x;
    private int y;
    private int attack;
    private boolean alive, attacking;
    private int lobsterNum, lobsterX, lobsterY;
    
    //when creating a new wizard tower, it will not attack, as it is being held by the cursor, default damage of the tower 2;
    public WizardTower(){
        super(2, 5, 13, 1, 150);
    } 
}
