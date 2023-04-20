import greenfoot.*;
import greenfoot.Color;
public class Score extends Actor
{
    private int totalScore = 0;
    private float fontSize = 18.0f;
    private Color textColor;
    private Color backgroundColor;
    public Score(String refText, int fontSize, Color textColor, Color backgroundColor)
    {
        GreenfootImage scoreImg = new GreenfootImage(refText + "", (int) fontSize, textColor, backgroundColor);
        setImage(scoreImg);
    }

    public int getTotalScore()
    {
        return totalScore;
    }

    public void increaseScore(int amount)
    {
        totalScore += amount;
        if(totalScore<200)
        {
            setImage(new GreenfootImage("Score:" + totalScore, 18, Color.CYAN, Color.BLACK));
        }
        if((totalScore>=200)&&(totalScore<700))
        {
            setImage(new GreenfootImage("Score:" + totalScore, 18, Color.CYAN, new Color(33, 33, 133)));
        }
        if(totalScore>=700)
        {
            setImage(new GreenfootImage("Score:" + totalScore, 18, Color.CYAN, new Color(133, 33, 33)));
        }
    }
}