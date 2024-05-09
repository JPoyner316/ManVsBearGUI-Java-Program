package edu.arapahoe.csc1060.mvb.bo;

import java.util.Random;
public class Player {
    private String name;
    private int starterHitPoints;
    private int currentHitPoints;
    private int minAttackStrength;
    private int maxAttackStrength;
    private int numOfHeals;

    public Player(String n, int shp, int chp, int minas, int maxas,int heals){
        name = n;
        starterHitPoints = shp;
        currentHitPoints = chp;
        minAttackStrength = minas;
        maxAttackStrength = maxas;
        numOfHeals = heals;
    }
    public int attack(){
        Random random = new Random();
        int attackStrength = random.nextInt(minAttackStrength, maxAttackStrength+1);
        return attackStrength;
    }
    public boolean canHeal(){
        if (numOfHeals > 0){
            return true;
        }else{
            return false;
        }
    }
    public int getHeals(){
        return numOfHeals;
    }
    public void heal(){
        numOfHeals = numOfHeals - 1;
        currentHitPoints = starterHitPoints;
    }
    public void setCurrentHitPoints(int strength){
        //calls bears attack class to calculate damage
        currentHitPoints = currentHitPoints - strength;
    }
    public int getCurrentHitPoints() {
        return currentHitPoints;
    }
    public String getName(){
        return name;
    }
}
