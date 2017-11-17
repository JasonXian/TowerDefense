import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Controls the spawning of lobsters
 * 
 * @Jason Xian
 * @June 6
 */
public class LobsterSpawner extends Actor{
    private LobsterEnemy[] lobsters;
    private FastLobsterEnemy[] fastLobsters;
    private TankyLobsterEnemy[] tankyLobsters;
    //Array lobsterWaves storing the number of lobsters per wave i.e.) index 0 = 5, 5 lobsters in wave 1, index 1 = 10, 10 lobsters in wave 2, etc.
    private int[] lobsterWaves, fastLobsterWaves, tankyLobsterWaves;
    private int spawnSpeed, fastSpawnSpeed, tankySpawnSpeed;
    private int spawnedAmount, fastSpawnedAmount, tankySpawnedAmount;
    private int spawnCounter, fastSpawnCounter, tankySpawnCounter;
    private int startLocationX, startLocationY;
    private int waveNumber;
    private Money money;
    private Score score;

    //Creates a new lobster spawner, requires an array containing the amount of lobsters of this type per wave, spawn health for the lobsters and a start location
    public LobsterSpawner(int[] initLobsterWaves,int[] initFastLobsterWave, int[] initTankyLobsterWave, int initStartLocationX, int initStartLocationY){
        lobsterWaves = initLobsterWaves;
        startLocationX = initStartLocationX;
        startLocationY = initStartLocationY;
        fastLobsterWaves = initFastLobsterWave;
        tankyLobsterWaves = initTankyLobsterWave;
    }

    //Creates a new array full of new lobsters for the wave, requires the wave number and the speeds of spawning for all lobsters
    public void newLobsterWave(int initWaveNumber, int initSpawnSpeed, int initFastSpawnSpeed, int initTankySpawnSpeed){
        waveNumber = initWaveNumber;
        spawnSpeed = initSpawnSpeed;
        fastSpawnSpeed = initFastSpawnSpeed;
        tankySpawnSpeed = initTankySpawnSpeed;
        spawnedAmount = 0;
        spawnCounter = 0;
        fastSpawnedAmount = 0;
        fastSpawnCounter = 0;
        tankySpawnedAmount = 0;
        tankySpawnCounter = 0;
        //Creates the normal lobster enemies with 2 move speed
        lobsters = new LobsterEnemy[lobsterWaves[waveNumber]];
        for(int i = 0; i < lobsterWaves[waveNumber]; i++){
            lobsters[i] = new LobsterEnemy(startLocationX, startLocationY, 4, 2);
        }
        //Creates the faster lobster enemies with 4 move speed
        fastLobsters = new FastLobsterEnemy[fastLobsterWaves[waveNumber]];
        for(int i = 0; i < fastLobsterWaves[waveNumber]; i++){
            fastLobsters[i] = new FastLobsterEnemy(startLocationX, startLocationY, 2, 4);
        }
        //Creates the tanky lobster enemies with 1 move speed, 20 health
        tankyLobsters = new TankyLobsterEnemy[tankyLobsterWaves[waveNumber]];
        for(int i = 0; i < tankyLobsterWaves[waveNumber]; i++){
            tankyLobsters[i] = new TankyLobsterEnemy(startLocationX, startLocationY, 20, 1);
        }
    }

    //Add a new lobster enemy to the world at intervals based on the spawnSpeed
    public void spawnLobster(){
        World world = getWorld();
        //Increase the counter by 1 each loop, if the counter is equal to the "spawnSpeed" it will add a lobster to the world
        spawnCounter += 1;
        if(spawnCounter == spawnSpeed && spawnedAmount < lobsterWaves[waveNumber]){
            world.addObject(lobsters[spawnedAmount], lobsters[spawnedAmount].x, lobsters[spawnedAmount].y);
            spawnedAmount += 1;
            spawnCounter = 0;
        }
        fastSpawnCounter += 1;
        if(fastSpawnCounter == fastSpawnSpeed && fastSpawnedAmount < fastLobsterWaves[waveNumber]){
            world.addObject(fastLobsters[fastSpawnedAmount], fastLobsters[fastSpawnedAmount].x, fastLobsters[fastSpawnedAmount].y);
            fastSpawnedAmount += 1;
            fastSpawnCounter = 0;
        }
        tankySpawnCounter += 1;
        if(tankySpawnCounter == tankySpawnSpeed && tankySpawnedAmount < tankyLobsterWaves[waveNumber]){
            world.addObject(tankyLobsters[tankySpawnedAmount], tankyLobsters[tankySpawnedAmount].x, tankyLobsters[tankySpawnedAmount].y);
            tankySpawnedAmount += 1;
            tankySpawnCounter = 0;
        }
    }

    //Lobster Types: 0 = normal lobster, 1 = fast lobster, 2 = tanky lobster
    //Tower Types: 0 = castle, 1 = wizard, 2 = robot, 3 = fire, slow the lobsters hit by tower type 1 (wizard), stop the lobsters hit by tower type 2(robot)
    //Decrease the health of the lobster based on how much damage the tower does, removes the lobster object if the lobster's health is below 0
    public void hitLobster(int lobsterNum, int attack, int lobsterType, int towerType){
        World world = getWorld();
        if(lobsterType == 0){
            lobsters[lobsterNum].hit(attack);
            if(towerType == 1){
                lobsters[lobsterNum].setFrozen();
            }else if(towerType == 2){
                lobsters[lobsterNum].setParalyzed();
            }
            if(lobsters[lobsterNum].getHealth() <= 0){
                Background refWorld = (Background) getWorld();
                money = refWorld.getMoney();
                money.setMoney(10);
                score = refWorld.getScore();
                score.setScore(10);
                world.removeObject(lobsters[lobsterNum]);
                lobsters[lobsterNum].setDead();
            }
        }else if(lobsterType == 1){
            fastLobsters[lobsterNum].hit(attack);
            if(towerType == 1){
                fastLobsters[lobsterNum].setFrozen();
            }else if(towerType == 2){
                fastLobsters[lobsterNum].setParalyzed();
            }
            if(fastLobsters[lobsterNum].getHealth() <= 0){
                Background refWorld = (Background) getWorld();
                money = refWorld.getMoney();
                money.setMoney(10);
                score = refWorld.getScore();
                score.setScore(20);
                world.removeObject(fastLobsters[lobsterNum]);
                fastLobsters[lobsterNum].setDead();
            } 
        }else if(lobsterType == 2){
            tankyLobsters[lobsterNum].hit(attack);
            if(towerType == 1){
                tankyLobsters[lobsterNum].setFrozen();
            }else if(towerType == 2){
                tankyLobsters[lobsterNum].setParalyzed();
            }
            if(tankyLobsters[lobsterNum].getHealth() <= 0){
                Background refWorld = (Background) getWorld();
                money = refWorld.getMoney();
                money.setMoney(30);
                score = refWorld.getScore();
                score.setScore(30);
                world.removeObject(tankyLobsters[lobsterNum]);
                tankyLobsters[lobsterNum].setDead();
            } 
        }
    }

    //Checks to see if the lobster's reach the end location/secret formula, if it does, decrease a life from the player and remove the lobster object
    public void endLocation(){
        World world = getWorld();
        Background refWorld = (Background) getWorld();
        SecretFormula secret = refWorld.getSecret();
        int secretX = secret.getX();
        int secretY = secret.getY();
        int lobsterX, lobsterY;
        Lives live = refWorld.getLives();
        for(int i = 0; i < spawnedAmount; i++){
            lobsterX = lobsters[i].getLobsterX();
            lobsterY = lobsters[i].getLobsterY();
            if(lobsterX >= secretX - 10 && lobsterX <= secretX + 10 && lobsterY >= secretY - 10 && lobsterY <= secretY + 10){
                world.removeObject(lobsters[i]);
                lobsters[i].setDead();
                live.setLives(-1);
            }
        }
        for(int i = 0; i < fastSpawnedAmount; i++){
            lobsterX = fastLobsters[i].getLobsterX();
            lobsterY = fastLobsters[i].getLobsterY();
            if(lobsterX >= secretX - 5 && lobsterX <= secretX + 5 && lobsterY >= secretY - 5 && lobsterY <= secretY + 5){
                world.removeObject(fastLobsters[i]);
                fastLobsters[i].setDead();
                live.setLives(-1);
            }
        }
        for(int i = 0; i < tankySpawnedAmount; i++){
            lobsterX = tankyLobsters[i].getLobsterX();
            lobsterY = tankyLobsters[i].getLobsterY();
            if(lobsterX >= secretX - 5 && lobsterX <= secretX + 5 && lobsterY >= secretY - 5 && lobsterY <= secretY + 5){
                world.removeObject(tankyLobsters[i]);
                tankyLobsters[i].setDead();
                live.setLives(-1);
            }
        }
    }

    //Returns how many lobsters have been added to the world
    public int getAlive(int lobsterType){
        if(lobsterType == 0){
            return spawnedAmount;
        }else if(lobsterType == 1){
            return fastSpawnedAmount;
        }else if(lobsterType == 2){
            return tankySpawnedAmount;
        }
        return 0;
    }

    //Returns the specific X coordinate of lobster number lobsterNum based on it's lobster type
    public int getLobsterX(int lobsterNum, int lobsterType){
        if(lobsterType == 0){
            return lobsters[lobsterNum].getLobsterX();
        }else if(lobsterType == 1){
            return fastLobsters[lobsterNum].getLobsterX();
        }else if(lobsterType == 2){
            return tankyLobsters[lobsterNum].getLobsterX();
        }
        return 0;
    }

    //Returns the specific Y coordinate of lobster number lobsterNum based on it's lobster type
    public int getLobsterY(int lobsterNum, int lobsterType){
        if(lobsterType == 0){
            return lobsters[lobsterNum].getLobsterY();
        }else if(lobsterType == 1){
            return fastLobsters[lobsterNum].getLobsterY();
        }else if(lobsterType == 2){
            return tankyLobsters[lobsterNum].getLobsterY();
        }
        return 0;
    }

    //Returns wether or not the lobster is alive based on it's lobster type, true = alive, false = dead
    public boolean getLobsterStatus(int lobsterNum, int lobsterType){
        if(lobsterType == 0){
            return lobsters[lobsterNum].getStatus();
        }else if(lobsterType == 1){
            return fastLobsters[lobsterNum].getStatus();
        }else if(lobsterType == 2){
            return tankyLobsters[lobsterNum].getStatus();
        }
        return false;
    }
    
    //Gets the status of the last lobsters of each array, true = alive, false = dead, if all three last lobsters are dead, return true meaning the wave has ended
    public boolean waveEnd(){
        boolean alive = false, fastAlive = false, tankyAlive = false;
        if(lobsterWaves[waveNumber] > 0){
            alive = lobsters[lobsterWaves[waveNumber] - 1].getStatus();
        }
        if(fastLobsterWaves[waveNumber] > 0){
            fastAlive = fastLobsters[fastLobsterWaves[waveNumber] - 1].getStatus();
        }
        if(tankyLobsterWaves[waveNumber] > 0){
            tankyAlive = tankyLobsters[tankyLobsterWaves[waveNumber] - 1].getStatus();
        }
        if(!alive && !fastAlive && !tankyAlive){
            return true;
        }
        return false;
    }
    
    //Spawner continues to check if the spawned amount is less than the amount needed per wave, if not enough, spawn more lobsters, also checks to see if any lobsters
    //reach the end of the map, Also checks to see if every lobster has been spawned and the next wave can begin.
    public void act() {
        spawnLobster();
        endLocation();
    }    
}   