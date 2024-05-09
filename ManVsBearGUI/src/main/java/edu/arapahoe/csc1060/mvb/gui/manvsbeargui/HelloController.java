package edu.arapahoe.csc1060.mvb.gui.manvsbeargui;

import edu.arapahoe.csc1060.mvb.bo.Bear;
import edu.arapahoe.csc1060.mvb.bo.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Random;
public class HelloController {
    private static Bear[] bears = new Bear[9];
    private static Bear currentBear;
    private static Player player;
    private static Button[] rooms = new Button[9];

    @FXML
    private Button button00;
    @FXML
    private Button button01;
    @FXML
    private Button button02;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button20;
    @FXML
    private Button button21;
    @FXML
    private Button button22;
    @FXML
    private Button attackButton;
    @FXML
    private Button healButton;
    @FXML
    private TextArea outputBox;
    @FXML
    private TextArea playerName;
    @FXML
    private TextArea bearName;
    @FXML
    private Label playerHealth;
    @FXML
    private Label bearHealth;
    @FXML
    private Label playerHeals;
    @FXML
    private void initialize(){
        outputBox.setText("Welcome to the game select a room to start in!!!");
        player = new Player("Hero", 3000, 3000, 50, 100, 1);
        Bear bear1 = new Bear("Derek", 300, 300, 50, 135);
        Bear bear2 = new Bear("Devin", 200, 200, 125, 200);
        Bear bear3 = new Bear("David", 100, 100, 135, 250);
        Bear bear4 = new Bear("Daniel", 300, 300, 50, 135);
        Bear bear5 = new Bear("Dylan", 200, 200, 125, 200);
        Bear bear6 = new Bear("Dominic", 100, 100, 135, 250);
        Bear bear7 = new Bear("Delilah", 300, 300, 50, 135);
        Bear bear8 = new Bear("Declan", 200, 200, 125, 200);
        Bear bear9 = new Bear("Diego", 100, 100, 135, 250);
        playerName.setText(player.getName());
        playerHeals.setText("Heals: "+ player.getHeals());
        Random rand = new Random();
        int bearPlacement = rand.nextInt(9);
        bears[bearPlacement] = bear1;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear2;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear3;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear4;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear5;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear6;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear7;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear8;
        while (bears[bearPlacement] != null){
            bearPlacement = rand.nextInt(9);
        }
        bears[bearPlacement] = bear9;

        rooms[0] = button00;
        rooms[1] = button01;
        rooms[2] = button02;
        rooms[3] = button10;
        rooms[4] = button11;
        rooms[5] = button12;
        rooms[6] = button20;
        rooms[7] = button21;
        rooms[8] = button22;
    }

    @FXML
    protected void button00Pressed(){
        currentBear = bears[0];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button01Pressed(){
        currentBear = bears[1];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button02Pressed(){
        currentBear = bears[2];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button10Pressed(){
        currentBear = bears[3];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button11Pressed(){
        currentBear = bears[4];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button12Pressed(){
        currentBear = bears[5];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button20Pressed(){
        currentBear = bears[6];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button21Pressed(){
        currentBear = bears[7];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    @FXML
    protected void button22Pressed(){
        currentBear = bears[8];
        attackModeSetup();
        outputBox.setText("You are now fighting "+ currentBear.getName()+ ".");
    }
    private void attackModeSetup(){
        bearName.setText(currentBear.getName());
        bearHealth.setText("HP:"+currentBear.getCurrentHitPoints());
        for (int i=0;i< rooms.length;i++){
            rooms[i].setDisable(true);
        }
        attackButton.setDisable(false);
        if (player.canHeal() == true){
            healButton.setDisable(false);
        }
    }
    private void attackModeFinish(){
        int bearsLeftAlive = 0;
        for (int i=0;i< rooms.length;i++){
            if (bears[i].getCurrentHitPoints() > 0) {
                rooms[i].setDisable(false);
                bearsLeftAlive++;
            }
        }
        bearName.setText(currentBear.getName()+" Deceased.");
        attackButton.setDisable(true);
        healButton.setDisable(true);
        if (bearsLeftAlive == 0){
            outputBox.setText("You defeated all the bears!!! You Win!!!");
        }
    }
    @FXML
    protected void attackButtonPressed(){
        int pAttackStrength = player.attack();
        currentBear.setCurrentHitPoints(pAttackStrength);
        outputBox.setText("The player bit the bear with a strength of " + pAttackStrength + " the bear has " + currentBear.getCurrentHitPoints() + " health.\n");
        int bAttackStrength = currentBear.attack();
        player.setCurrentHitPoints(bAttackStrength);
        outputBox.appendText("The bear bit the player with a strength of " + bAttackStrength + " the player has " + player.getCurrentHitPoints() + " health.\n");
        bearHealth.setText("HP: "+currentBear.getCurrentHitPoints());
        playerHealth.setText("HP: "+player.getCurrentHitPoints());
        if(currentBear.getCurrentHitPoints()<=0){
            outputBox.appendText("You won!!! chose your next bear.\n");
            attackModeFinish();

        }
        if(player.getCurrentHitPoints() <= 0) {
            outputBox.setText("YOU DIED... moron.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }
    }
    @FXML
    protected void healButtonPressed(){
        player.heal();
        outputBox.setText("You ate a whole pinapple in 5 milliseconds! You're now full health!\n");
        int bAttackStrength = currentBear.attack();
        player.setCurrentHitPoints(bAttackStrength);
        outputBox.appendText("The bear bit the player with a strength of " + bAttackStrength + " the player has " + player.getCurrentHitPoints() + " health.\n");
        bearHealth.setText("HP: "+currentBear.getCurrentHitPoints());
        playerHealth.setText("HP: "+player.getCurrentHitPoints());
        if (player.canHeal() == false){
            healButton.setDisable(true);
        }
        playerHeals.setText("Heals: "+ player.getHeals());
    }
}