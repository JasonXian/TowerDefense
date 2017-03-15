import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Controls the creation and deletion of the Wizard Towers
 * 
 * @Jason Xian
 * @June 6
 */
public class WizardSpawner extends Actor{
    private int price;
    private boolean spawningWizard = false;
    //Creates an array of the 50 towers, to limit the amount of towers the player can create
    private WizardTower[] wizards = new WizardTower[50];
    private int numWizards = 0;
    private int mX, mY;
    private Money money;
    
    //Constructor for the wizard spawner, sets it so that it's price is always 200 dollars
    public WizardSpawner(){
        this.price = 200;
    }

    //Controls the movement of the Wizard Tower when first clicked, makes the tower follow the cursor until clicked again
    public void spawnWizard(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mX = mouse.getX();
        mY = mouse.getY();
        wizards[numWizards].setLocation(mX,mY);
    }
    
    //When the tower is placed, it will no longer follow the cursor
    public void towerPlaced(){
        spawningWizard = false;
    }
    
    //Sets the tower to "attack" mode, so it cannot attack more than one enemy at a time
    public void setAttcking(int towerNum){
        wizards[towerNum].setAttacking();
    }
   
    //Object keeps checking on the creation of the tower
    public void act(){
        //Look for mouse information
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            mX = mouse.getX();
            mY = mouse.getY();
        }
        //If the spawner is currently busy with the spawning of a wizard tower, meaning that a tower is following the cursor
        if(spawningWizard){
            //Continue to re-adjust the postion of the tower following the cursor
            spawnWizard();
            //If the mouse is clicked again while the tower is following the cursor
            if(Greenfoot.mouseClicked(null)){
                //Check to see that the tower is within the boundries of where it can be placed
                if(mX >= 200 && mX <= 850 && mY >= 150 && mY <= 600){
                    //Set the location of the Wizard Tower, allow it to attack, and reduce money by the cost of the tower
                    wizards[numWizards].setLocation(mX,mY);
                    wizards[numWizards].setCoordinates(mX,mY);
                    wizards[numWizards].setAlive();
                    numWizards += 1;
                    spawningWizard = false;
                    Background world = (Background) getWorld();
                    money = world.getMoney();
                    money.setMoney(-1 * this.price);
                }else{
                    spawningWizard = false;
                    World world = getWorld();
                    world.removeObject(wizards[numWizards]);
                }
            }    
        }else if(Greenfoot.mouseClicked(this)){
            //If the spawner is not currently placing a tower, and a click is registered, it will check for if the player has enough money to buy a tower
            Background refWorld = (Background) getWorld();
            money = refWorld.getMoney();
            if(money.getMoney() >= this.price){
                //If the player has enougn money, it will create a tower that will follow the cursor around until the player clicks again and places it
                wizards[numWizards] = new WizardTower();
                World world = getWorld();
                world.addObject(wizards[numWizards], mX, mY);
                spawningWizard = true;
            }
        }
    }
}
