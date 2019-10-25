import greenfoot.*;
/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class fries extends Actor
{
    public void act() 
    {
        setLocation(getX()-2, getY());
        if ((getWorld()!=null)&&(getX()<=10))
        {
            SpaceWorld spaceWorld = (SpaceWorld) getWorld();
            Bar bar = spaceWorld.getBar();
            Score score = spaceWorld.getScore();
            score.increaseScore(10);
            bar.add(30);
            getWorld().removeObject(this);
        }
    }    
}
