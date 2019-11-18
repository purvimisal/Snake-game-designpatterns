    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Spider here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Spider extends Powerup
    {
        int timer = 0;
        /**
         * Act - do whatever the Spider wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
    public void act() 
    {
        timer++;
        if(timer % 25 == 0) {
            if (this.getImage().toString().contains("spider.png"))
            {
                setImage(new GreenfootImage(10,10));
            } else {
                setImage(new GreenfootImage("spider.png"));
            }
        }
    
    }    
}
