
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
        String name, score;
        String line;
        String text = "";
        scores = new HashMap();
        background = new GreenfootImage(getWidth(), getHeight());
        background.setColor(new Color(0, 0, 0));
        background.fillRect(0, 0, getWidth(), getHeight());
        showText("HIGH SCORES", 15, 3);
        showText("Player    |    Score", 15, 5);

        try {
            File file = new File("scores.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                name = s[0];
                score = s[1];
                scores.put(name, Integer.parseInt(score));
                line = br.readLine();

            }
            showText(getTopTen(scores), 15, 15);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getTopTen(HashMap<String, Integer> map) {
        StringBuilder names = new StringBuilder();
        Object[] a = map.entrySet().toArray();
        int count = 0;
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        for (Object e : a) {
            if (count == 10)
                break;
            names.append(((Map.Entry<String, Integer>) e).getKey() + "  " + ((Map.Entry<String, Integer>) e).getValue()
                    + "\n");
            count++;
        }
        return names.toString();
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
