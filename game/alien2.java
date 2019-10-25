import greenfoot.*;
/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class alien2 extends Enemy
{
    //     private int health = 1; 
    //     
    //     public void setHealth(int points) 
    //     {  
    //         health += points;  
    //     }  
    // 
    //     public int getHealth() 
    //     {  
    //         return health;  
    //     }  

    public void act() 
    {
        //setLocation(getX()-3, getY());
        //if (getX()%18==0)
        //    setLocation(getX()+9, getY());
        if (getX()%6==0)
            setLocation(getX()-3, getY()+6);
        else
            setLocation(getX()-3, getY()-6);
        if((getOneIntersectingObject(Actor.class)!=null)&&(getOneIntersectingObject(plasma.class)==null)&&(getOneIntersectingObject(rocket.class)==null))
        {
            setLocation(getX(), getY()+3);
        }
        removeEnemy();
    }    
}
