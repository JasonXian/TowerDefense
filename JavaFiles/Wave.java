import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Displays and keeps track of the amount of waves the player has played through, also increases the wave number at the end of a wave
 * 
 * @Jason Xian
 * @June 13
 */
public class Wave extends Actor{
    private int waveNumber;
    private LobsterSpawner lobsters;
    private Score score;
    
    //Creates a new wave that requires an intial wave number to begin from
    public Wave(int initWaveNumber){
        this.waveNumber = initWaveNumber;
        setImage(new GreenfootImage("Wave:" + (this.waveNumber + 1), 50, Color.BLACK, Color.WHITE));
    }
    
    //Returns the number of waves that have gone by
    public int getWave(){
        return this.waveNumber;
    }
    
    //Increases the wave number by one
    public void increaseWave(){
        this.waveNumber += 1;
    }
    
    //Check to see if the wave has ended
    public void waveEnd(){
        Background refWorld = (Background) getWorld();
        lobsters = refWorld.getLobster();
        score = refWorld.getScore();
        if(lobsters.waveEnd()){
            this.increaseWave();
            if(this.waveNumber == 19){
                Greenfoot.setWorld(new GameWinScreen(score.getScore()));
            }
            lobsters.newLobsterWave(this.waveNumber, 100, 90, 80);
        }
    }
    
    //Continously displays the current wave number
    public void act() {
        setImage(new GreenfootImage("Wave:" + (this.waveNumber + 1), 50, Color.BLACK, Color.WHITE));
        waveEnd();
    }    
}
