import greenfoot.*;
/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class Enemy extends Actor
{
    public void act() 
    {
    }    

    public void removeEnemy()
    {
        if (getWorld() != null && getX() <= 10)  
        {
            SpaceWorld spaceWorld = (SpaceWorld) getWorld();
            Bar bar = spaceWorld.getBar();
            bar.subtract(20);
            getWorld().removeObject(this);
        }
    }
}
