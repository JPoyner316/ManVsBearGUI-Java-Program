package edu.arapahoe.csc1060.mvb.bo;

import java.util.Random;
import java.util.Scanner;

public class ManVsBear2Launcher {
    static int i = 0;
    Scanner s = new Scanner(System.in);
    private static Bear[] bears = new Bear[3];
    private static Player player;

    public static void main(String[] args){
        displayAsciiArt();
        player = new Player("Link", 750, 750, 50, 100, 1);
        Bear bear1 = new Bear("Derek", 3000, 3000, 50, 135);
        Bear bear2 = new Bear("Devin", 2000, 2000, 125, 200);
        Bear bear3 = new Bear("David", 1000, 1000, 135, 250);

        int lastindex = -1;
        Random rand = new Random();
        int index = rand.nextInt(3);
        bears[index] = bear1;
        lastindex = index;
        while (index == lastindex){
            index = rand.nextInt(3);
        }
        lastindex = index;
        bears[index] = bear2;
        while (index == lastindex){
            index = rand.nextInt(3);
        }
        bears[index] = bear3;
        displayAsciiArt();
        fight();

        if (player.getCurrentHitPoints() <= 0){
            displayFightResults(bears[i].getName());
        } else if (bears[2].getCurrentHitPoints() <= 0){
            displayFightResults(player.getName());
        }else{
            System.out.println("Everyone Died!!!");
        }

    }
    private static void displayAsciiArt(){
        System.out.println("Welcome to the game.\n");
        System.out.println("WWNWNWWMMMMMMWWWWWWWWMMMMMMWNNWWWWWMMMMMWWNNNWWWMMMMMMMWNWNNWWWMMMMMMWNWWWWWWMMMMMMWWWWNNWWMMMMMWWWN\n" +
                "WWWWWWWMMMMMMWWWWNNWWMMWNNNNWNNWWWMMMMMMWWWWWWWWMMMMMMMWWWWNWNWMMMMMMWWNWWNWWMMMMMMWWWNWNWWMMMMMMWWN\n" +
                "WWWWWWWMMMMMMWWWWWNNKxl:;,;xXNK0xood0KOdodkKNWWWMMMWWWNWWWWWWWWMMMMMMWWWWWWWWMMMMMMWWWNNWWWMMMMMWWWW\n" +
                "MMWWMWWWWWWWWWWMWWKo,'...,..::;,''...''.....;d00xllc:::cdKWWMWWWWWWWWWWMWMMWWWWWWWWWWMWWWWWWWWWWWWWM\n" +
                "MMMMMMWWWWNNWWMMW0;.,;;,..'.';:ccc::;:cccc:,'.....'......,dNMMWWWWWNWWMMMMMMWWNWWWWWMMMMMMWWNWWNWWMM\n" +
                "MMMMMMWWNWWWWWMMNx..::;''',:clc:;,;::cccc::llc;'.....,;,,..dNMWNNWWNNWMMMMMMWWNNNNWWMMMMMMWNNWWNWWMM\n" +
                "WWWWWWWWWWWWWWWWW0:..',,,....;cc,,::,'..;,,clllc:,'..;cc:''xXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n" +
                "WNWWNWWMMMMMMWWNNO:.,:;.........''...;'.',;lollccccc,.';,.cKWNWMMMMMMWWWWNWWWMMMMMMWWNWNWWWMMMMMWWWW\n" +
                "WWWWNWWMMMMMMWWXd'.cl,..........;cc;'..'',coooollcccc:. .,kNWNWMMMMMMWWNNWWWWMMMMMMWWNWWNWMMMMMMWWWW\n" +
                "WWWWWWWMMMMMMWKl.'lo:',;''''''';:cccc,....':loolcllllc:'..,dKNWMMMMMMWWWWWWWWMMMMMWWWWWWWWWMMMMMWWWW\n" +
                "MMMMMMWWWWWWWKc..coo:';c;'';cccccccccc;. ..,cllc:;:clc::::'.;OWWWWWWWWMMMMWWWWWWWWWWMMWWMWWWWWWWWWMM\n" +
                "MMMMMMWNNNNNKl..;llo:.'..,,''',,,;;:ccc'...'cllc;'.'cl,':cc'.'kNWNWWWWMMMMMMWNNWNNWWMMMMMMWNNWNWWWMM\n" +
                "MMMMMMWWNNXx,..';cll,...coddddxx,  ..,c:'..':cl:;. .;l;.'cc:. ,0NNWWWWMMMMMMWNWWNNWWMMMMMMWNNWNNWMMM\n" +
                "WWWWWWWWWXo..'..;:ll:;,:dl;:;';o'     .::...,cc;'. .,:,..:c:;. ;kXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\n" +
                "NWWNNWWMWx..;;..';cc;coc;.           .',:;...::,.  .,,. .:c:,.  .'ckKNNNNWWWWMMMMMMWWNWWNWWMMMMMWWWW\n" +
                "NWWWWWWMK;.,c:. .'cc,,cll,..    .,;',cc',;...;;'..',,. .'c:;'.  ',..':d0NNWWWMMMMMMWNNWWNWWMMMMMWWWN\n" +
                "WWWWWWWMO..;cc,. .;::'.':l,..   .c;'cl;';;'..,,.''.....,;::,.   ,cc:,...:d0NWWMMMMMWWWWWWWWMMMMMWWWW\n" +
                "MMMMMWWNd..;cc:'...,:c,..;:'.  .;c,,l:':c:'..,,,..   .,,;;,.    .;::cc:,'.':kXNWWWWWMMMMMWWWWWWWWWMM\n" +
                "MMMMMMWXl..;:cc;,.  .;c:'';'. .:c::cc,,cc:'.';,...'.',,,,.      .',,;;:ccc;..,dKNWWWMMMMMMWNNNNNWWMM\n" +
                "MMMMMMNo. .',;:c::'...';;,;'. 'l::cl;.;:',,',;'.';;,,,'.  ..     ';,,,'..',;,..'dXWWMMMMMMWNWNNWWMMM\n" +
                "WWWWWNx. .. .';;:::;;,.',,,.. 'cl::dc.;'.,,,,,,,,,,'.......  ..  ........,,,,,'..:OXNWWWWWWWWWWWWWWW\n" +
                "NWWNW0; .,'.  .',,,;;;;,,''cdd::llco;',..',,,,'.......','. ..,'. ...''...'''.......,:d0NWWWMMMMMWWWN\n" +
                "NNWWNx. ';::''..........',,;c:'.''.  ',..,,,'.   .''',,....',,...... ........,,',,;,...lONWMMMMMMWNN\n" +
                "WWWWNo .,;cccccc:;,;;,'...','..      ,'.,,'.   .',,,,'..''',;'..   .........''...':cc:'.'dXMMMMMWWWW\n" +
                "MMMMNc .,;cccccccccccc:;'. .''......,,.',.  .'',,,,,,..,'.',;'''. ...      .....'.',:cc;..oXWWWNWWMM\n" +
                "MMMMX: .,;ccccccccccccccc:;'......'''.';'..',,,,,,,,'',,..,,,,,,. ....  ...''..';;',:ccc;..xNWNNWWMM\n" +
                "MMMM0, .,;:cccccccccccccccccc;'...'',,,,,.',,,,,,,;,,,,'.';,,,,,. .;'...............';ccc, :KNWWWMMM\n" +
                "WWWWx.  ';:cccccccccccccccccccc:. .',,,,,,,,''',,,,,,,;'.',,,,,,. .,.....    .....,;..;cc:..OWWWWWWW\n" +
                "WWWNo....';:cccccccccccccccccccc:.  .,,,,,,,'....',,,,,'.,,,,,,,. .,..',. ...'''..,:c;,:cc..dWMMMWNN\n" +
                "WNWNo..'..';ccccccccccccccccccccc;.  ',,,,,,,,,.. ..,,,,,,,,,,,,. .,,,'....... ..,,;::cccc,.lNMMMWNN\n" +
                "WWWNd..,,...;ccccccccc:;,'........   .,,,,,,,,,,,. .',,,,,,,,,,'..',,,.....  ..',,,,,;;;:c;.:XWWWWWW\n" +
                "MMMMO' ';;;;;:cccc:;'......'','...     ....',,,,,,'.',,,'',,,,,. .,,,,,,'.   .',,,,,'',,,:c.'ONWWWMM\n" +
                "MMMMXc .,;:cccc:;,...',:ccc:,'....'',,,,'....',,'.'.''..'...',...,,,,,..  .'.........',;,;c;.cKWWMMM\n" +
                "MMMMWk. ',;:c:;,..';cccc:,..',:cloooooool:;,. ..,,'.. .;:,. ... .',,,.. .',;,,'.....'',,,,:c..dNWWMM\n" +
                "WWWWWXc .,;,;;'.';::::;'..,clolloooolclol:'...,::;,......',...'....,,'..';,,,,,,,'''',,,,,;c;.;KWWWW\n" +
                "WWWNWNO, .,,,,',;;;;;,..'clooocccllol;,;,,,.....,,,..,,'...'...,,. .';..',,,,,,,,,,,,,,,,,;:,..kWWNN\n" +
                "WWWNNWNd. ',,,,,,,,;,..;cloooolccccll:,,,:c'... ..,...''''.... .',. .,,',,,,,,,,,,,,,,,,,,;;. .dWWNW\n" +
                "WWWWWWWO. .,,,,,,,,,'.;cccclool;;c:,'''';;;'..,'.....  ...'.     .'..,,,,,,,,,,,,,,,,,,,,,;;. ,kNWWW\n" +
                "MMMMMMW0, .,,,,,,,,,',;;;;:ccll:'.''......,,..',,,,....   ...     .  ',,,,,,,,,,,,,,,,,,,,;, .d0NMMM\n" +
                "MMMMMMWXc .,,,,,,,,,,,,,,,;:cccl:,;;....  .,'.  ......     .. .'.    .',;,,,,,,,,,,,,,,,,,;. ;0NWWMM\n" +
                "MMMMMMWNx. ';,,,,,,,,,,,,,,,;;:::;,;'..,'...,,'.    ..   'dOc.cKKk;..  ...''''..',,,,,,,,,'..dNWWMMM\n" +
                "WWWWWWWWK; .,,,,,,,,',,,,,,,,,,,,,,,,. ..'......        :0NWKk0WWWOkOxl;'..  ..',,,,,...,,..lXWWWWWW\n" +
                "WWWWNWWMWx..',',,,,,..,,,,,,,,,,,,,,,'.....'.       .,,.oXWWNNWMMWWWMWNNXKkc........ ..'...oXMMMWWWN\n" +
                "WNWNNWWMMNo..,'..,,;'..,,,,,,,,,;,,,;,,......    ..;kNXO0NNWNNWMMMMMMWNNNWNN0xoc::,.....,l0WMMMMWWNN\n" +
                "WWWWWWWWWWXo..'. ..,,. ',,,,,,,,,,'......,,.   .:kKXWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNKOOOKNWWWWWWWWWWW\n" +
                "MMMMMMWWWWNNk;..   ..'..',,,,,,,,,,,',,,,.. .'.lXWWNNNNWMMMMMMWWNWWNWWMMMMMMWNNWWNWWMMMMMMWNWWNNWWMM\n" +
                "MMMMMMWWWNWWNXx;. ..     .,,,,,,,,,,,,'...,oKXKKNWWWWNWWMMMMMMWWNWWNWWMMMMMMWWWWNNWWMMMMMMWWWWNWWMMM\n" +
                "MMMMMWWWWWWWWWWNOooxdl:,.  ..'.........'ckXWMMMWWWWWWWWWMMMMMMWWWWWWWWWMMMMMWWWWWWWWMMMMMWWWWWWWWMMM\n" +
                "WWWWWWWMMMMMMWWWWWNXWMWNKkl,...  ..'cd0XWWWWWWWWMMWWMMMWWWWWWWWMMMMMMWWWWWWWWMMMMMMWWWWWWWWMMMMMWWWW\n" +
                "WNNNWWWMMMMMMWWWNNNWMMMMMMWXOxooodOXWMMMWWNWWNWWMMMMMMMWWWWNNWWMMMMMMWWWNNWWWMMMMMMWNWWWNWWMMMMMWWNN");
    }
    private static void fight() {
        System.out.println("You are fighting " + bears[i].getName());
        while (true) {
            while (true) {
                System.out.println("press '1' to attack, press '2' to heal.");
                Scanner s = new Scanner(System.in);
                int atkchoice = s.nextInt();
                if (atkchoice == 2) {
                    if (player.canHeal() == true) {
                        player.heal();
                        System.out.println("You ate a whole pinapple in 5 milliseconds! You're now full health!");
                        break;
                    } else {
                        System.out.println("Sorry you do not have any healing items anymore.");
                    }
                } else if (atkchoice == 1) {
                    System.out.println("You chose to attack.");
                    //calculate player damage
                    int pAttackStrength = player.attack();
                    bears[i].setCurrentHitPoints(pAttackStrength);
                    System.out.println("The player bit the bear with a strength of " + pAttackStrength + " the bear has " +
                            bears[i].getCurrentHitPoints() + " health.");int bAttackStrength = bears[i].attack();
                    break;
                } else {
                    System.out.println("Please type '1' or '2'");
                }
            }
            //calculates bear damage
            int bAttackStrength = bears[i].attack();
            player.setCurrentHitPoints(bAttackStrength);
            System.out.println("The bear bit the player with a strength of " + bAttackStrength + " the player has " +
                    player.getCurrentHitPoints() + " health.");
            if (i == 2) {
                if (bears[2].getCurrentHitPoints() <= 0) {
                    break;
                }
            } else if (player.getCurrentHitPoints() <= 0) {
                break;
            } else {
                if (bears[i].getCurrentHitPoints() <= 0) {
                    System.out.println("You've defeated " + bears[i].getName());
                    i += 1;
                    System.out.println("You are now fighting " + bears[i].getName());
                }
            }

        }
    }
    private static void displayFightResults(String nameOfWinner){
        System.out.println("Congrats! "+nameOfWinner+" Wins!");
    }
}