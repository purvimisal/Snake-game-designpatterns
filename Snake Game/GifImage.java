import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * 
 * Class to handle GIF images for the game
 */

public class GifImage {

    private String file;
    private boolean pause;
     private GreenfootImage[] images;
     private int[] delay;
     private int currentIndex;
     private long time;

    public GifImage(String file)
    {
        this.file = file;
        pause = false;
        if(file.toLowerCase().endsWith(".gif")) {
            loadImages();
        }
        else {
            images = new GreenfootImage[] {new GreenfootImage(file)};
            delay = new int[] {1000}; // Doesn't matter, as long as it's not zero
            currentIndex = 0;
            time = System.currentTimeMillis();
        }
    }

    private void loadImages()
    {
        GifDecoder decode = new GifDecoder();
        decode.read(file);
        int numFrames = decode.getFrameCount();
        if(numFrames>0) {
            images = new GreenfootImage[numFrames];
            delay = new int[numFrames];
        }
        else {
            images = new GreenfootImage[1];
            images[0] = new GreenfootImage(1, 1);
        }

        for (int i=0 ; i<numFrames ; i++) {
            GreenfootImage image = new GreenfootImage(decode.getFrame(i).getWidth(), decode.getFrame(i).getHeight());
            image.drawImage(decode.getFrame(i), 0, 0);
            delay[i] = decode.getDelay(i);
            images[i] = image;
        }
        time = System.currentTimeMillis();
    }


    private class GifDecoder {

        private int status;
        public static final int STATUS_OK = 0;
        private BufferedInputStream in;
        private int frameCount;

        public int read(String name) {
            status = STATUS_OK;
            InputStream resource = this.getClass().getResourceAsStream(name);
            if (resource == null) {
                name = "images/" + name;
                resource = this.getClass().getResourceAsStream(name);
                if (resource == null) {
                    throw new RuntimeException("The gif file \"" + name + "\" doesn't exist.");
                }
            }
            in = new BufferedInputStream(resource);
            status = read(in);

            return status;
        }

        public int read(BufferedInputStream is) {
            
        }

        public int getFrameCount() {
            return frameCount;
        }
    }

}