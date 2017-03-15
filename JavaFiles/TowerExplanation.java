import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the information explaining all of the towers
 * 
 * @Jason Xian
 * @June 6
 */
public class TowerExplanation extends World{

    public TowerExplanation(){    
        // Create a new world with 1050x741 cells with a cell size of 1x1 pixels.
        super(1050, 741, 1);  
    }
    
    //If user clicks c, move on to the next instruction screen, else if they click on b go back to the last one
    public void act(){
         if(Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("C")){
            Greenfoot.setWorld(new LobsterExplanation());
        }else if(Greenfoot.isKeyDown("b") || Greenfoot.isKeyDown("B")){
            Greenfoot.setWorld(new InstructionScreenMapTwo());
        }
    }
}
