import greenfoot.*;

/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class dead extends Actor
{
    public void act() 
    {
        for(int i = 0; i < 15; ++i) {
            if (i >= 8) {
                getWorld().removeObject(this);
                return;
            }
        }    
    }
}
