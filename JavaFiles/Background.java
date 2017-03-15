import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controller for the main game, adds all the spawners and towers to the world
 * 
 * @Jason Xian
 * @June 6
 */
public class Background extends World{
    //Creates private variables to store the various objects needed to run the game
    private LobsterSpawner lobsters;
    private CastleSpawner castles;
    private WizardSpawner wizards;
    private RobotSpawner robots;
    private FireSpawner fire;
    private Money money;
    private Lives lives;
    private Score score;
    private SecretFormula secret;
    private Pause pause;
    private Wave wave;

    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background(){
        // Create a new world with 1050x741cells with a cell size of 1x1 pixels.
        super(1050, 741, 1);
        int[] one  = {100, 20, 30};
        //Create all the text object's that carry the player's information and adds it to the world Intial lives of 10, money of $100, score of 0, wave 1
        score = new Score(0);
        lives = new Lives(10);
        money = new Money(200);
        wave = new Wave(0);
        addObject(wave, 550, 50);
        addObject(lives, 350, 50);
        addObject(score, 100,50);
        addObject(money, 850, 50);
        //Creates all the tower spawners and adds them to the world
        castles = new CastleSpawner();
        wizards = new WizardSpawner();
        robots = new RobotSpawner();
        fire = new FireSpawner();
        addObject(castles, 60, 700);
        addObject(wizards, 260, 700);
        addObject(robots, 460, 690);
        addObject(fire, 660, 700);
        //Method outputs all the of the tower prices onto the world
        setTowerPrices();
        //Method adds the exit/pause button to the world
        pause = new Pause();
        addObject(pause,920, 710);
        //Add the secret formula/endpoint for the lobsters onto the screen
        secret = new SecretFormula(520, 650);
        addObject(secret,520, 650);
        //All the lobsters information, sets up a new wave, arrays for the number of lobsters per wave and adds the lobster spawner to the world
        int[] normalLobsters = {10, 20, 30, 20, 10, 0, 0, 50, 20, 10, 0, 0, 0, 0, 30, 50, 100, 0, 0, 50};
        int[] fastLobsters =   {0, 0, 0, 5, 15, 20, 30, 10, 10, 20, 10, 0, 0, 20, 30, 10, 0, 50, 0, 50};
        int[] tankyLobsters =  {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 4, 10, 20, 10, 10, 10, 10, 0, 20, 25};
        lobsters = new LobsterSpawner(normalLobsters, fastLobsters, tankyLobsters, 1000, 50);
        addObject(lobsters,0,0);
        lobsters.newLobsterWave(wave.getWave(), 100, 90, 80); 
    }

    public void setTowerPrices(){
        TowerPrices castlePrice = new TowerPrices(100);
        TowerPrices wizardPrice = new TowerPrices(200);
        TowerPrices robotPrice = new TowerPrices(500);
        TowerPrices firePrice = new TowerPrices(1000);
        addObject(castlePrice, 150, 710);
        addObject(wizardPrice, 350, 710);
        addObject(robotPrice, 550, 710);
        addObject(firePrice, 750, 710);
    }

    //Getters for all of the objects, allows refrences to the background world's objects to be created, which allows all the Actor classes to interact
    public LobsterSpawner getLobster(){
        return lobsters;
    }

    public CastleSpawner getCastle(){
        return castles;
    }

    public WizardSpawner getWizard(){
        return wizards;
    }

    public RobotSpawner getRobot(){
        return robots;
    }

    public FireSpawner getFire(){
        return fire;
    }

    public Money getMoney(){
        return money;
    }

    public Score getScore(){
        return score;
    }

    public Lives getLives(){
        return lives;
    }

    public SecretFormula getSecret(){
        return secret;
    }

    public Pause getPause(){
        return pause;
    }

    public Wave getWave(){
        return wave;
    }
}