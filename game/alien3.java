import greenfoot.*;
/**
 * @author BuckLe Byhan 
 * @version 2013
 */
public class alien3 extends Enemy
{    
    //     private int health = 3; 
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
        setLocation(getX()-4, getY());
        Actor enemy = getOneIntersectingObject(Enemy.class);  
        if((getOneIntersectingObject(Actor.class)!=null)&&(getOneIntersectingObject(plasma.class)==null)&&(getOneIntersectingObject(rocket.class)==null))
        {
            if(getY()>=384)
                setLocation(getX(), getY()-8);
            else
                setLocation(getX(), getY()+8);
        }
        removeEnemy();
    }    
}
