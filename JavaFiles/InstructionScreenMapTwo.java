import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the second Instruction map screen, explains the tower buying, lobster spawning, objective
 * 
 * @Jason Xian
 * @June 6
 */
public class InstructionScreenMapTwo extends World{
    
    public InstructionScreenMapTwo(){    
        // Create a new world with 1050x741 cells with a cell size of 1x1 pixels.
        super(1050, 741, 1); 
    }
    
    //If user clicks c, move on to the next instruction screen, else if they click b go back to the last one
    public void act(){
         if(Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("C")){
            Greenfoot.setWorld(new TowerExplanation());
        }else if(Greenfoot.isKeyDown("b") || Greenfoot.isKeyDown("B")){
            Greenfoot.setWorld(new InstructionScreenMap());
        }
    }
}
