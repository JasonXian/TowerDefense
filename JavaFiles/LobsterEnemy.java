	import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Attributes for all Lobster Enemies and the default red one
 * 
 * @Jason Xian
 * @June 6
 */
public class LobsterEnemy extends Actor{
    public int x;
    public int y;
    private int moveSpeed;
    private int moveRotation;
    private int health;
    private int mapDirection;
    private boolean alive;
    
    //Create a lobster enemy, requires an initial x and y position, health and move speed. It is given a random direction 1 or 2 to follow on the map
    public LobsterEnemy(int initX, int initY, int initHealth, int initMoveSpeed){
        this.x = initX;
        this.y = initY;
        this.moveRotation = 90;
        this.health = initHealth;
        this.moveSpeed = initMoveSpeed;
        this.alive = true;
        Random r = new Random();
        if(r.nextInt(2) == 0){
            this.mapDirection = 1;
        }else{
            this.mapDirection = 2;
        }
    }

    //This controls the movement of the lobster towards the left if it is assigned pattern one when it is created
    public void movementPatternOne(){
        if(getY() < 100){
            this.moveRotation = 90;
        }else if(getY() >= 100 && getY() <= 105){
            this.moveRotation = 180;
            if(getX() <= 50){
                this.moveRotation = 90;
            }
        }else if(getY() >= 650){
            this.moveRotation = 0;
        }
    }

    //This controls the movement of the lobster towards the btoom if it is assigned pattern two when it is created
    public void movementPatternTwo(){
        if(getY() < 100){
            this.moveRotation = 90;
        }else if(getX() <= 500){
            this.moveRotation = 270;
        }else if(getY() >= 650){
            this.moveRotation = 180;
        }
    }

    //When hit by the RobotTower, sets the lobster's movement to 0 permanently so it cannot move
    public void setParalyzed(){
        this.moveSpeed = 0;
    }
    
    //When hit by the WizardTower, sets the lobster's movement to be -1, cannot reduce the lobster's speed to less than 1
    public void setFrozen(){
        if(this.moveSpeed > 1){
            this.moveSpeed -= 1;
        }
    }
    
    //Returns the X coordinate of the lobster, 1500 if it is "dead"
    public int getLobsterX(){
        if(!this.alive){
            return 1500;
        }
        return getX();
    }
    
    //Returns the Y coordinate of the lobster, 1500 if it is "dead"
    public int getLobsterY(){
        if(!this.alive){
            return 1500;
        }
        return getY();
    }

    //Returns the health of this lobster
    public int getHealth(){
        return this.health;
    }

    //Reduce the health of this lobster by int "attack"
    public void hit(int attack){
        this.health -= attack;
    }

    public void setDead(){
        this.alive = false;
    }

    //Returns the status of this lobster, true = alive, false = dead
    public boolean getStatus(){
        return this.alive;
    }
    
    //Continously moves and re-adjusts the direction of the lobster based on the movement pattern it was assigned
    public void act() {
        if(this.mapDirection == 1){
            movementPatternOne();
        }else{
            movementPatternTwo();
        }
        setRotation(this.moveRotation);
        move(this.moveSpeed); 
    }    
}
