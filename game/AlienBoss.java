import greenfoot.*;
public class AlienBoss extends Actor
{
    int countdown = 50;
    int countdownTwo = 50;
    int countdownThree = 0;
    private boolean up = true;
    public void act() 
    {
        if(getWorld()!=null)
        {
            moveUp();
            moveDown();
            if(countdown==0)
            {
                setLocation(getX()-3, getY());
                if(up)
                {
                    countdownThree=100;
                    up=false;
                }
                else
                {
                    countdownTwo=100;
                    up=true;
                }
                countdown=100;
            }
            countdown=countdown-1;
        }
    }    

    public void moveUp()
    {
        if(getWorld()!=null)
        {
            if(countdownTwo!=0)
            {
                setLocation(getX(), getY()-2);
                countdownTwo=countdownTwo-1;
            }
        }
    }

    public void moveDown()
    {
        if(getWorld()!=null)
        {
            if(countdownThree!=0)
            {
                setLocation(getX(), getY()+2);
                countdownThree=countdownThree-1;
            }
        }
    }
}
