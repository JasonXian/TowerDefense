import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Superclass for all the other towers
 * 
 * @Jason Xian
 * @June 6
 */
public class Tower extends Actor{
    private int x;
    private int y;
    private int attack, attackSpeed, attackDelay, attackDelayCounter, range;
    private boolean alive, attacking;
    private int lobsterNum, lobsterX, lobsterY;
    //Keeps track of the type of tower: 0 = CastleTower, 1 = WizardTower, 2 = RobotTower, 3 = FireTower
    private int towerType; 
    //Keeps track of the type of lobster being attacked: 0 = normal, 1 = fast, 2 = tanky
    private int lobsterType;
    private Arrow arrow;
    private Snowball snowball;
    private Lightning lightning;
    private Fireball fireball;

    //Default constructor for towers, all of them are set to not "alive" as when they are first created they are waiting to be placed by the player,
    //Requires an intial attack damage, attack speed, type of tower and attack range to create
    public Tower(int initAttack, int initAttackSpeed, int initAttackDelay, int initTowerType, int initRange){
        this.alive = false;
        this.attacking = false;
        this.attack = initAttack;
        this.attackSpeed = initAttackSpeed;
        this.towerType = initTowerType;
        this.range = initRange;
        this.attackDelay = initAttackDelay;
        this.attackDelayCounter = initAttackDelay;
    }

    //Checks for the closest LobsterEnemy to attack
    public void checkAttack(){
        //Creates a refernce to the LobsterSpawner in the main world
        Background world = (Background) getWorld();
        LobsterSpawner lobsters = world.getLobster();
        //Loops through the coordinates of all the fast lobsters, when the coordinates of a lobster is in range, the tower will attack it and break the loop
        for(int i = 0; i < lobsters.getAlive(1); i++){
            lobsterX = lobsters.getLobsterX(i,1);
            lobsterY = lobsters.getLobsterY(i,1);
            if(getDistance(lobsterX, this.x, lobsterY, this.y) <= this.range){      
                this.lobsterNum = i;
                this.lobsterType = 1;
                createProjectile();
                return;
            }
        }
        //Loops through the coordinates of all the tanky lobsters, when the coordinates of a lobster is in range, the tower will attack it and break the loop
        for(int i = 0; i < lobsters.getAlive(1); i++){
            lobsterX = lobsters.getLobsterX(i,2);
            lobsterY = lobsters.getLobsterY(i,2);
            if(getDistance(lobsterX, this.x, lobsterY, this.y) <= this.range){      
                this.lobsterNum = i;
                this.lobsterType = 2;
                createProjectile();
                return;
            }
        }
        //Loops through the coordinates of all the normal lobsters, when the coordinates of a lobster is in range, the tower will attack it and break the loop
        for(int i = 0; i < lobsters.getAlive(0); i++){
            lobsterX = lobsters.getLobsterX(i,0);
            lobsterY = lobsters.getLobsterY(i,0);
            if(getDistance(lobsterX, this.x, lobsterY, this.y) <= this.range){      
                this.lobsterNum = i;
                this.lobsterType = 0;
                createProjectile();
                return;
            }
        }
    }

    //Creates a projectile to be shot by the tower based on the type of tower
    public void createProjectile(){
        if(this.towerType == 0){
            this.arrow = new Arrow(this.x, this.y, this.attackSpeed, this.lobsterNum, this.lobsterType);
            World world = getWorld();
            world.addObject(this.arrow, this.x, this.y);
        }else if(this.towerType == 1){
            this.snowball = new Snowball(this.x, this.y, this.attackSpeed, this.lobsterNum, this.lobsterType);
            World world = getWorld();
            world.addObject(this.snowball, this.x, this.y); 
        }else if(this.towerType == 2){
            this.lightning = new Lightning(this.x, this.y, this.attackSpeed, this.lobsterNum, this.lobsterType);
            World world = getWorld();
            world.addObject(this.lightning, this.x, this.y);
        }else if(this.towerType == 3){
            this.fireball = new Fireball(this.x, this.y, this.attackSpeed, this.lobsterNum, this.lobsterType);
            World world = getWorld();
            world.addObject(this.fireball, this.x, this.y);
        }
        this.attacking = true; 
    }

    //Check to see if the projectile hits the enemy, depends on the type of tower
    public boolean projectileHit(){
        if(this.towerType == 0){
            return this.arrow.checkHit();
        }else if(this.towerType == 1){
            return this.snowball.checkHit();
        }else if(this.towerType == 2){
            return this.lightning.checkHit();
        }else if(this.towerType == 3){
            return this.fireball.checkHit();
        }
        return false;
    }

    //Return the specific projectile that the tower has shot, in order for it to be removed
    public Projectiles getProjectile(){
        if(this.towerType == 0){
            return this.arrow;
        }else if(this.towerType == 1){
            return this.snowball;
        }else if(this.towerType == 2){
            return this.lightning;
        }else if(this.towerType == 3){
            return this.fireball;
        }
        return null;
    }

    //Sets the coordinates of the tower
    public void setCoordinates(int initX, int initY){
        this.x = initX;
        this.y = initY;
    }

    //Sets the tower to being "alive" allowing it to attack
    public void setAlive(){
        this.alive = true;
    }

    //Sets the tower to stop attacking, if this.attacking is true, the tower is in the process of an attack
    public void setAttacking(){
        this.attacking = false;
    }

    //Returns the x coordinate of the tower
    public int getTowerX(){
        return this.x;
    }

    //Returns the y coordinate of the tower
    public int getTowerY(){
        return this.y;
    }

    //Returns the distance between two points, utilizes the distance formula
    public double getDistance(int x1, int x2, int y1, int y2){
        double xBracket = Math.pow((double)(x2 - x1), 2);
        double yBracket = Math.pow((double)(y2 - y1), 2);
        return Math.sqrt(xBracket + yBracket);
    }

    //The tower's continous actions
    public void act() {
        //Checks to see if the tower is alive
        if(this.alive){
            //Checks to see if the tower is in the middle of an attack
            if(this.attacking){
                //Check to see if the projectile has reached it's target
                Background refWorld = (Background) getWorld();
                LobsterSpawner lobsters = refWorld.getLobster();
                if(projectileHit() || !lobsters.getLobsterStatus(this.lobsterNum, this.lobsterType)){
                    //Create a reference to the world in order to decrease the lobster's health and remove the projectile from the world and the tower stops attacking
                    World world = getWorld();
                    //Calls on the getProjectile method in order to get the specific projectile sent out by the specific instance of the tower
                    world.removeObject(getProjectile());
                    lobsters.hitLobster(this.lobsterNum, this.attack, this.lobsterType, this.towerType);
                    this.attacking = false;
                    this.attackDelayCounter = this.attackDelay; 
                }
            }else{
                //If the tower is not attacking, look for the closest enemy to attack through the checkAttack() method
                //The tower delays it's attacks based on it's specific attackDelay number
                if(this.attackDelayCounter == 0){
                    checkAttack();
                }else{
                    this.attackDelayCounter -= 1;  
                }
            }
        }
    }    
}