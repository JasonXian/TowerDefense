import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the explanation of the different types of lobsters
 * 
 * @Jason Xian
 * @June 6
 */
public class LobsterExplanation extends World{
    
    public LobsterExplanation(){    
       // Create a new world with 1050x741 cells with a cell size of 1x1 pixels.
       super(1050, 741, 1);  
    }
    
    //If user clicks c, move on to the title screen, else if they click on b go back to the last one
    public void act(){
         if(Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("C")){
            Greenfoot.setWorld(new TitleScreen());
        }else if(Greenfoot.isKeyDown("b") || Greenfoot.isKeyDown("B")){
            Greenfoot.setWorld(new TowerExplanation());
        }
    }
}
