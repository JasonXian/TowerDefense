import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First Instruction Screen, explains the lives, maps, score and money at the top of the screen
 * 
 * @Jason Xian 
 * @June 6
 */
public class InstructionScreenMap extends World{

    public InstructionScreenMap(){    
        // Create a new world with 1050x741 cells with a cell size of 1x1 pixels.
        super(1050, 741, 1); 
    }
    
    //If user clicks c, move on to the next instruction screen, else if they click b go back to the title screen
    public void act(){
         if(Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("C")){
            Greenfoot.setWorld(new InstructionScreenMapTwo());
        }else if(Greenfoot.isKeyDown("b") || Greenfoot.isKeyDown("B")){
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
