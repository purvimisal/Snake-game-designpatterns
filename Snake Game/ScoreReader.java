
/**
 * Write a description of class ScoreReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ScoreReader.
 */
public class ScoreReader implements IScoreReader {

    /**
     * Constructor for objects of class ScoreReader.
     */
    public ScoreReader() {
    }

    /**
     * Read file.
     *
     * @return the hash map
     */
    public HashMap<String, Integer> readFile() {
        String line;
        HashMap<String, Integer> scores = new HashMap();
        File file = new File("scores.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                scores.put(s[0], Integer.parseInt(s[1]));
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return scores;
    }
}
