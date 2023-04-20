import greenfoot.*;
/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class rocket extends Actor
{
    private int plasmaLimiter = 0;

    public void act() 
    {
        if (Greenfoot.isKeyDown("right"))
            setLocation(getX()+4, getY());
        if (Greenfoot.isKeyDown("left"))
            setLocation(getX()-4, getY());
        if (Greenfoot.isKeyDown("up")&&(getY()>=100))
            setLocation(getX(), getY()-4);
        if (Greenfoot.isKeyDown("down"))
            setLocation(getX(), getY()+4);
        if (Greenfoot.isKeyDown("shift")){
            if (Greenfoot.isKeyDown("right"))
                setLocation(getX()+6, getY());
            if (Greenfoot.isKeyDown("left"))
                setLocation(getX()-6, getY());
            if (Greenfoot.isKeyDown("up")&&(getY()>=100))
                setLocation(getX(), getY()-6);
            if (Greenfoot.isKeyDown("down"))
                setLocation(getX(), getY()+6);
        }
        fire();
        if(getWorld()!=null)
        {
            Actor enemy = getOneIntersectingObject(Enemy.class);
            if(enemy!=null)
            {
                SpaceWorld spaceWorld = (SpaceWorld) getWorld();
                Bar bar2 = spaceWorld.getBar2();
                getWorld().removeObject(enemy);
                Greenfoot.playSound("explosionSFX.mp3");
                bar2.subtract(20);
                if(bar2.getValue()<=0)
                {
                    Actor dead = new dead();
                    getWorld().addObject(dead, getX(), getY());
                    getWorld().removeObject(this);
                    return;
                }
            }
        }
        if(getWorld()!=null)
        {
            Actor asteroid = getOneIntersectingObject(asteroid.class);
            if(asteroid!=null)
            {
                SpaceWorld spaceWorld = (SpaceWorld) getWorld();
                Bar bar2 = spaceWorld.getBar2();
                getWorld().removeObject(asteroid);
                Greenfoot.playSound("explosionSFX.mp3");
                bar2.subtract(30);
                if(bar2.getValue()<=0)
                {
                    Actor dead = new dead();
                    getWorld().addObject(dead, getX(), getY());
                    getWorld().removeObject(this);
                    return;
                }
            }
        }
        if(getWorld()!=null)
        {
            Actor fries = getOneIntersectingObject(fries.class);
            if (fries!=null)
            {
                SpaceWorld spaceWorld = (SpaceWorld) getWorld();
                Bar bar2 = spaceWorld.getBar2();
                getWorld().removeObject(fries);
                Greenfoot.playSound("healSFX.mp3");
                bar2.add(40);
            }
        }
        if(getWorld()!=null)
        {
            Actor potato = getOneIntersectingObject(potato.class);
            if(potato!=null)
            {
                SpaceWorld spaceWorld = (SpaceWorld) getWorld();
                Bar bar2 = spaceWorld.getBar2();
                getWorld().removeObject(potato);
                Greenfoot.playSound("explosionSFX.mp3");
                bar2.subtract(30);
                if(bar2.getValue()<=0)
                {
                    Actor dead = new dead();
                    getWorld().addObject(dead, getX(), getY());
                    getWorld().removeObject(this);
                    return;
                }
            }
        }
        if(getWorld()!=null)
        {
            Actor boss = getOneIntersectingObject(AlienBoss.class);
            if(boss!=null)
            {
                SpaceWorld spaceWorld = (SpaceWorld) getWorld();
                Bar bar2 = spaceWorld.getBar2();
                bar2.subtract(100);
                if(bar2.getValue()<=0)
                {
                    Actor dead = new dead();
                    getWorld().addObject(dead, getX(), getY());
                    getWorld().removeObject(this);
                    return;
                }
            }
        }
    }    

    public void fire()
    {
        if (plasmaLimiter > 0) {
            plasmaLimiter = plasmaLimiter - 1;
        }
        else if (Greenfoot.isKeyDown("space")) {
            getWorld().addObject(new plasma(), getX()+50, getY());
            Greenfoot.playSound("87402^LASER.mp3");
            plasmaLimiter = 10;
        }
    }
}
