import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class asteroid extends Rock
{
    public void act() 
    {
        super.act();
        if ((getWorld()!= null)&&(getX()<=10))
        {
            SpaceWorld spaceWorld = (SpaceWorld) getWorld();
            Bar bar = spaceWorld.getBar();
            Score score = spaceWorld.getScore();
            score.increaseScore(10);
            bar.add(10);
            getWorld().removeObject(this);
        }
        if(getWorld()!=null){
            Actor rocket = getOneIntersectingObject(rocket.class);
            if(rocket!=null){
                Actor dead = new dead();
                getWorld().addObject(dead, getX(), getY());
            }
        }
    }
}
