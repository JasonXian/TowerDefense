import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Controls the creation and deletion of the Fire Towers
 * 
 * @Jason Xian
 * @June 6
 */
public class FireSpawner extends Actor{
    private int price;
    private boolean spawningFire = false;
    //Creates an array of the 50 towers, to limit the amount of towers the player can create
    private FireTower[] fire = new FireTower[50];
    private int numFire = 0;
    private int mX, mY;
    private Money money;
    
    //Constructor for the fire spawner, sets it so that it's price is always 200 dollars
    public FireSpawner(){
        this.price = 1000;
    }

    //Controls the movement of the Fire Tower when first clicked, makes the tower follow the cursor until clicked again
    public void spawnFire(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mX = mouse.getX();
        mY = mouse.getY();
        fire[numFire].setLocation(mX,mY);
    }
    
    //When the tower is placed, it will no longer follow the cursor
    public void towerPlaced(){
        spawningFire = false;
    }
    
    //Sets the tower to "attack" mode, so it cannot attack more than one enemy at a time
    public void setAttcking(int towerNum){
        fire[towerNum].setAttacking();
    }
   
    //Object keeps checking on the creation of the tower
    public void act(){
        //Look for mouse information
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            mX = mouse.getX();
            mY = mouse.getY();
        }
        //If the spawner is currently busy with the spawning of a fire tower, meaning that a tower is following the cursor
        if(spawningFire){
            //Continue to re-adjust the postion of the tower following the cursor
            spawnFire();
            //If the mouse is clicked again while the tower is following the cursor
            if(Greenfoot.mouseClicked(null)){
                //Check to see that the tower is within the boundries of where it can be placed
                if(mX >= 200 && mX <= 850 && mY >= 150 && mY <= 600){
                    //Set the location of the Fire Tower, allow it to attack, and reduce money by the cost of the tower
                    fire[numFire].setLocation(mX,mY);
                    fire[numFire].setCoordinates(mX,mY);
                    fire[numFire].setAlive();
                    numFire += 1;
                    spawningFire = false;
                    Background world = (Background) getWorld();
                    money = world.getMoney();
                    money.setMoney(-1 * this.price);
                }else{
                    spawningFire = false;
                    World world = getWorld();
                    world.removeObject(fire[numFire]);
                }
            }    
        }else if(Greenfoot.mouseClicked(this)){
            //If the spawner is not currently placing a tower, and a click is registered, it will check for if the player has enough money to buy a tower
            Background refWorld = (Background) getWorld();
            money = refWorld.getMoney();
            if(money.getMoney() >= this.price){
                //If the player has enougn money, it will create a tower that will follow the cursor around until the player clicks again and places it
                fire[numFire] = new FireTower();
                World world = getWorld();
                world.addObject(fire[numFire], mX, mY);
                spawningFire = true;
            }
        }
    }
}
