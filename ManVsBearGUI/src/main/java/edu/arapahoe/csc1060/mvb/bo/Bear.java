package edu.arapahoe.csc1060.mvb.bo;

import java.util.Random;

public class Bear {
    private String name;
    private int starterHitPoints;
    private int currentHitPoints;
    private int minAttackStrength;
    private int maxAttackStrength;

    public Bear(String n, int shp, int chp, int minas, int maxas){
        name = n;
        starterHitPoints = shp;
        currentHitPoints = chp;
        minAttackStrength = minas;
        maxAttackStrength = maxas;
    }
    public int attack(){
        Random random = new Random();
        int attackStrength = random.nextInt(minAttackStrength, maxAttackStrength+1);
        return attackStrength;
    }
    public void setCurrentHitPoints(int strength){
        currentHitPoints = currentHitPoints - strength;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public String getName(){
        return name;
    }
}
