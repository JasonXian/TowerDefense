import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Spawns Castle Tower.
 * 
 * @Jason Xian 
 * @June 6
 */
public class CastleSpawner extends Actor{
    private int price;
    private boolean spawningCastle = false;

    //Creates an array of the 50 towers, to limit the amount of towers the player can create
    private CastleTower[] castles = new CastleTower[50];
    private int numCastles = 0;
    private int mX, mY;
    private Money money;

    //Constructor for the castle spawner, sets it so that it's price is always 200 dollars
    public CastleSpawner(){
        this.price = 100;
    }

    //Controls the movement of the castle Tower when first clicked, makes the tower follow the cursor until clicked again
    public void spawnCastle(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mX = mouse.getX();
        mY = mouse.getY();
        castles[numCastles].setLocation(mX,mY);
    }

    //When the tower is placed, it will no longer follow the cursor
    public void towerPlaced(){
        spawningCastle = false;
    }

    //Sets the tower to "attack" mode, so it cannot attack more than one enemy at a time
    public void setAttcking(int towerNum){
        castles[towerNum].setAttacking();
    }

    //Object keeps checking on the creation of the tower
    public void act(){
        //Look for mouse information
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            mX = mouse.getX();
            mY = mouse.getY();
        }
        //If the spawner is currently busy with the spawning of a castle tower, meaning that a tower is following the cursor
        if(spawningCastle){
            //Continue to re-adjust the postion of the tower following the cursor
            spawnCastle();
            //If the mouse is clicked again while the tower is following the cursor
            if(Greenfoot.mouseClicked(null)){
                //Check to see that the tower is within the boundries of where it can be placed
                if(mX >= 200 && mX <= 850 && mY >= 150 && mY <= 600){
                    castles[numCastles].setLocation(mX,mY);
                    castles[numCastles].setCoordinates(mX,mY);
                    castles[numCastles].setAlive();
                    numCastles += 1;
                    spawningCastle = false;
                    Background world = (Background) getWorld();
                    money = world.getMoney();
                    money.setMoney(-1 * this.price);
                }else{
                    spawningCastle = false;
                    World world = getWorld();
                    world.removeObject(castles[numCastles]);
                }
            }
        }else if(Greenfoot.mouseClicked(this)){
            //If the spawner is not currently placing a tower, and a click is registered, it will check for if the player has enough money to buy a tower
            Background world2 = (Background) getWorld();
            money = world2.getMoney();
            //If the player has enougn money, it will create a tower that will follow the cursor around until the player clicks again and places it
            if(money.getMoney() >= this.price){
                castles[numCastles] = new CastleTower();
                World world = getWorld();
                world.addObject(castles[numCastles], mX, mY);
                spawningCastle = true;
            }
        }
    }
}    

