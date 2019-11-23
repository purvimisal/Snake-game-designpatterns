/**
 * Write a description of class ScoreDecorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import greenfoot.*;
// TODO: Auto-generated Javadoc

/**
 * The Class ScoreDecorator.
 */
public class ScoreDecorator 
{
    
    /** The reader. */
    private IScoreReader reader;
    
    /**
     * Instantiates a new score decorator.
     *
     * @param r the r
     */
    public ScoreDecorator(IScoreReader r){
        reader = r;
    }
    
    /**
     * Decorate.
     *
     * @param w the w
     */
    public void decorate(World w){
        Map<String,Integer> topTen = getTopTen(reader.readFile());
        int x = 250;
        int y = 150;
        int dx = 50;
        int dy = 35;
        for (Map.Entry me : topTen.entrySet()) {
          GreenfootImage name = new GreenfootImage(me.getKey().toString(), 20, Color.WHITE, null);
          GreenfootImage score = new GreenfootImage(me.getValue().toString(),20, Color.WHITE, null);
          w.getBackground().drawImage(name,x,y);
          w.getBackground().drawImage(score,x+(2*dx),y);
          y = y +dy;
        }
       
    }
    
    /**
     * Gets the top ten.
     *
     * @param map the map
     * @return the top ten
     */
    public Map<String, Integer> getTopTen(HashMap<String, Integer> map) {
        Map<String, Integer> topTen = new LinkedHashMap();
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
                topTen.put(((Map.Entry<String, Integer>) e).getKey(),((Map.Entry<String, Integer>) e).getValue());
            count++;
        }
        return topTen;
    }


}
