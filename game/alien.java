import greenfoot.*;
/**
 * @author BuckLe Byhan 
 * @version 2013
 */
public class alien extends Enemy
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
        if ((getX()%4)==0)
            setLocation(getX()-2, getY()+2);
        else
            setLocation(getX()-2, getY()-2);
        if((getOneIntersectingObject(Actor.class)!=null)&&(getOneIntersectingObject(plasma.class)==null)&&(getOneIntersectingObject(rocket.class)==null))
        {
            setLocation(getX()+2, getY());
        }
        removeEnemy();
    }    
}
