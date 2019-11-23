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
     private GreenfootImage image; 

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

    public List<GreenfootImage> getImages()
    {
        ArrayList<GreenfootImage> images = new ArrayList<GreenfootImage>(this.images.length);
        for(GreenfootImage image : this.images) {
            images.add(image);
        }
        return images;
    }

    public void pause()
    {
        pause = true;
    }

    public void resume()
    {
        pause = false;
        time = System.currentTimeMillis();
    }

    public boolean isRunning()
    {
        return !pause;
    }

    public GreenfootImage getCurrentImage()
    {
        long delta = System.currentTimeMillis() - time;

        while (delta >= delay[currentIndex] && !pause) {
            delta -= delay[currentIndex];
            time += delay[currentIndex];
            currentIndex = (currentIndex+1) % images.length;
        }
        return images[currentIndex];
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

    private static class Rectangle
    {
        public int x;
        public int y;
        public int width;
        public int height;
        
        public Rectangle(int x, int y, int width, int height)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    private class GifFrame {
        public GifFrame(GreenfootImage im, int del) {
            image = im;
            delay = del;
        }

        private GreenfootImage image;

        private int delay;
    }

    private class GifDecoder {

        private int status;
        public static final int STATUS_OK = 0;
        private BufferedInputStream in;
        private int frameCount;

        public int getDelay(int n) {
            //
            delay = -1;
            if ((n >= 0) && (n < frameCount)) {
                delay = (frames.get(n)).delay;
            }
            return delay;
        }
        
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

        public GreenfootImage getFrame(int n) {
            GreenfootImage im = null;
            if ((n >= 0) && (n < frameCount)) {
                im = ((GifFrame) frames.get(n)).image;
            }
            return im;
        }

        public int read(BufferedInputStream is) {
            init();
            if (is != null) {
                in = is;
                readHeader();
                if (!err()) {
                    readContents();
                    if (frameCount < 0) {
                        status = STATUS_FORMAT_ERROR;
                    }
                }
            } else {
                status = STATUS_OPEN_ERROR;
            }
            try {
                is.close();
            } catch (IOException e) {
            }
            return status;
        }

        public int getFrameCount() {
            return frameCount;
        }

        protected void init() {
            status = STATUS_OK;
            frameCount = 0;
            frames = new ArrayList<GifFrame>();
            gct = null;
            lct = null;
        }

        protected void readHeader() {
            String id = "";
            for (int i = 0; i < 6; i++) {
                id += (char) read();
            }
            if (!id.startsWith("GIF")) {
                status = STATUS_FORMAT_ERROR;
                return;
            }

            readLSD();
            if (gctFlag && !err()) {
                gct = readColorTable(gctSize);
                bgColor = colorFromInt(gct[bgIndex]);
            }
        }

        protected boolean err() {
            return status != STATUS_OK;
        }

        protected void readContents() {
            // read GIF file content blocks
            boolean done = false;
            while (!(done || err())) {
                int code = read();
                switch (code) {

                case 0x2C: // image separator
                    readImage();
                    break;

                case 0x21: // extension
                    code = read();
                    switch (code) {
                    case 0xf9: // graphics control extension
                        readGraphicControlExt();
                        break;

                    case 0xff: // application extension
                        readBlock();
                        String app = "";
                        for (int i = 0; i < 11; i++) {
                            app += (char) block[i];
                        }
                        if (app.equals("NETSCAPE2.0")) {
                            readNetscapeExt();
                        } else
                            skip(); // don't care
                        break;

                    default: // uninteresting extension
                        skip();
                    }
                    break;

                case 0x3b: // terminator
                    done = true;
                    break;

                case 0x00: // bad byte, but keep going and see what happens
                    break;

                default:
                    status = STATUS_FORMAT_ERROR;
                }
            }
        }
    }

}