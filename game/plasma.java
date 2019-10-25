import greenfoot.*;
/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class plasma extends rocket
{
    public void act() 
    {
        if (getWorld()!=null)  
        {
            setLocation(getX()+16, getY());
            destroyEnemy();
            destroyFries();
            destroyRock();
            destroyAlienBoss();
        }
        if(getWorld()!=null&&getX()>=1020)
        {
            getWorld().removeObject(this);
        }
    }    

    public void destroyEnemy() {  
        Actor enemy = getOneIntersectingObject(Enemy.class);  
        if(enemy != null) {  
            getWorld().removeObject(enemy);  
            getWorld().removeObject(this);  
        }  
    }  

    public void destroyRock()
    {
        if(getWorld()!=null){
            Actor rock = getOneIntersectingObject(Rock.class);
            if(rock != null){
                if(getOneIntersectingObject(potato.class)!=null){
                    fries fries = new fries();
                    getWorld().addObject(fries, getX(), getY());
                }
                getWorld().removeObject(rock);
                getWorld().removeObject(this);
            }
        }
    }

    public void destroyFries()
    {
        if(getWorld()!=null){
            Actor fries = getOneIntersectingObject(fries.class);
            if(fries!=null){
                getWorld().removeObject(fries);
                getWorld().removeObject(this);
            }
        }
    }

    public void destroyAlienBoss()
    {
        if(getWorld()!=null)
        {
            Actor boss = getOneIntersectingObject(AlienBoss.class);
            if(boss!=null)
            {
                SpaceWorld spaceWorld = (SpaceWorld) getWorld();
                Bar bar3 = spaceWorld.getBar3();
                getWorld().removeObject(this);
                bar3.subtract(1);
            }
        }
    }
}

