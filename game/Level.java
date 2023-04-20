import greenfoot.*;
import greenfoot.Color;

public class Level extends Actor
{
    int counter = 100;
    private int totalScore = 0;
    private float fontSize = 18.0f;
    private Color textColor;
    private Color backgroundColor;
    public Level(String refText, int fontSize, Color textColor, Color backgroundColor)
    {
        GreenfootImage levelImg = new GreenfootImage("" + refText, (int) 96, textColor, backgroundColor);
        setImage(levelImg);
    }

    public void act()
    {
        if (counter == 0)
        {
            getWorld().removeObject(this);
        }
        else
        {
            counter--;
        }
    }
}
