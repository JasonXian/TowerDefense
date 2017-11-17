import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ouputs the game over screen to the world, allows the user to restart the game or to return to the title screen
 * 
 * @Jason Xian 
 * @June 13
 */
public class GameOverScreen extends World{
    private Score score;
    
    public GameOverScreen(int initScore){    
        // Create a new world with 1050x741 cells with a cell size of 1x1 pixels.
        super(1050, 741, 1);
        score = new Score(initScore);
    }
    
    //If user clicks r, restart the game, else if they click t go back to the title screen
    public void act(){
        super.addObject(score, 500, 600);
         if(Greenfoot.isKeyDown("r") || Greenfoot.isKeyDown("r")){
            Greenfoot.setWorld(new Background());
        }else if(Greenfoot.isKeyDown("t") || Greenfoot.isKeyDown("T")){
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
