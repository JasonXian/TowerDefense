import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the Title Screen
 * 
 * @Jason Xian
 * @June 6
 */
public class TitleScreen extends World{
    public TitleScreen()    {    
        // Create a new world with 1050x741 cells with a cell size of 1x1 pixels.
        super(1050, 741, 1); 
    }
    
    //If the user clicks s, start the game, else if they click i go to the instruction screens
    public void act(){
        if(Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("S")){
            Greenfoot.setWorld(new Background());
        }else if(Greenfoot.isKeyDown("i") || Greenfoot.isKeyDown("I")){
            Greenfoot.setWorld(new InstructionScreenMap());
        }
    }
}
