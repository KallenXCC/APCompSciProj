import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
public class Counter  extends Actor
{
    private int totalCount = 0;

    public Counter()
    {
        setImage(new GreenfootImage("Score: 0", 20, Color.CYAN, Color.BLACK));
    }

    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("Score:" + totalCount, 20, Color.CYAN, Color.BLACK));
    }
}
