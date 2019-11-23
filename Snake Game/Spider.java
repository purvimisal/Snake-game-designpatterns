    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    // TODO: Auto-generated Javadoc
/**
     * Write a description of class Spider here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Spider extends Powerup
    {
        
        /** The timer. */
        int timer = 0;
        /**
         * Act - do whatever the Spider wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
    public Spider() {
        getImage().scale(30, 30);
    }
    
    /**
     * Act.
     */
    public void act() 
    {
        timer++;
        if(timer % 15 == 0) {
            if (this.getImage().toString().contains("spider.png"))
            {
                setImage(new GreenfootImage(10,10));
                this.getImage().scale(30, 30);
            } else {
                setImage(new GreenfootImage("spider.png"));
                this.getImage().scale(30, 30);
            }
        }
    
    }    
}
