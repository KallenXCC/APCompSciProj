import greenfoot.*;
import greenfoot.Color;

public class Congratulations extends Actor
{
    private float fontSize = 18.0f;
    private Color textColor;
    private Color backgroundColor;
    public Congratulations(String refText, int fontSize, Color textColor, Color backgroundColor)
    {
        GreenfootImage congratulationsImg = new GreenfootImage("" + refText, (int) 96, textColor, backgroundColor);
        setImage(congratulationsImg);
    }

    public void act()
    {
    }
}
