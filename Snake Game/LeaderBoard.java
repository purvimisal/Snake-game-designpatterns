
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
import java.util.*;

/**
 * Write a description of class LeaderBoard here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class LeaderBoard extends World {
    GreenfootImage background;
    HashMap<String, Integer> scores;

    public HashMap<String,Integer> getScoreMap(){
        return scores;
    }

    LeaderBoard() {
        super(30, 30, 20, false);
        showText("HIGH SCORES", 15, 3);
        showText("Player    |    Score", 15, 5);
        ScoreDecorator sc = new ScoreDecorator(new ScoreReader());
        sc.decorate(this);

    }



    /**
     * Act - do whatever the LeaderBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new SelectionScreen());
        }
    }

}
