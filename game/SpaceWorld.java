import greenfoot.*;
import java.awt.Color; 
/**
 * @author BuckLe Byhan
 * @version 2013
 */
public class SpaceWorld extends World
{
    GreenfootSound backgroundMusic = new GreenfootSound("05 Les Betes (EM05_B).wav");  
    GreenfootSound finalBackgroundMusic = new GreenfootSound("10 Showdown (EM05_A).wav");
    GreenfootSound celebrationMusic = new GreenfootSound("Celebration.wav");
    public Bar bar = new Bar("Company's Satisfaction", "", 100, 100);
    public Bar bar2 = new Bar("Rocket Health", "", 100, 100);
    public Bar bar3 = new Bar("Boss Health", "", 100, 100);
    public Score score = new Score("Score: 0", 20, Color.CYAN, Color.black);
    public rocket rocket = new rocket();
    public Level levelOne = new Level("LEVEL ONE", 96, Color.RED, Color.black);
    public Level levelTwo = new Level("LEVEL TWO", 96, Color.RED, new Color(33, 33, 133));
    public Level finalLevel = new Level("FINAL LEVEL", 96, Color.black, new Color(133, 33, 33));
    public Congratulations congratulations = new Congratulations("CONGRATULATIONS", 96, Color.white, new Color(133, 33, 33));
    public AlienBoss alienBoss = new AlienBoss();
    public int rate = 90;
    public int timer = 0; 
    public int potatorate = 20;
    public void act()
    {
        if(Greenfoot.getRandomNumber(rate*2) < 1) 
            addObject(new alien(), 1020, Greenfoot.getRandomNumber(83)*8+100); //1 in (rate) chance of spawning a alien 
        if(Greenfoot.getRandomNumber(rate*4) < 1)
            addObject(new alien2(), 1020, Greenfoot.getRandomNumber(83)*8+100);   
        if(Greenfoot.getRandomNumber(rate*10) < 1)
            addObject(new alien3(), 1020, Greenfoot.getRandomNumber(83)*8+100);   
        if(Greenfoot.getRandomNumber(rate) < 1)
        {
            Actor asteroid = new asteroid();
            addObject(new asteroid(), 1020, Greenfoot.getRandomNumber(83)*8+100);  
        }    
        if(Greenfoot.getRandomNumber(rate*potatorate) < 1)
            addObject(new potato(), 1020, Greenfoot.getRandomNumber(83)*8+100);   
        timer++;
        modifyEmployer();
        modifyLevel();
        modifyLevelAgain();
        scrollBackground();
        scrollBackground2();
        scrollBackground3();
        if (((bar.getValue() == bar.getMinimumValue())||(bar2.getValue() == bar2.getMinimumValue()))&&(bar3.getValue()!=bar3.getMinimumValue()))
        {
            if (getObjects(GameOver.class).isEmpty()) 
                showGameOver();
            return;
        }
        if (score.getTotalScore()>=700)
        {
            if(bar3.getValue() == bar3.getMinimumValue())
            {
                removeObject(alienBoss);
                addObject(congratulations, getWidth()/2, getHeight()/2);
                finalBackgroundMusic.stop();
                celebrationMusic.playLoop();
            }
        }
    }  

    public Bar getBar(){ return bar; }

    public Bar getBar2(){return bar2;}
    
    public Bar getBar3(){return bar3;}

    public Score getScore(){ return score; }

    private void showGameOver()
    {
        addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
    }

    public void modifyEmployer()
    {
        if(timer%30 == 0)
        {
            bar.subtract(1);
        }
    }

    public void modifyRates()
    {
        if(timer%2 == 0 && rate > 2) //when timer is 100, 200, 300, 400 etc, and the rate is more than 10  
            rate--; //decrease the rate variable by 1  
        if(timer%4 == 0 && rate > 2) 
            potatorate++;
    }

    public SpaceWorld()
    {     
        super(1024, 768, 1); 
        backgroundMusic.playLoop();  
        addObject(bar, 225, 40);
        addObject(bar2, 500, 40);
        addObject(score, 650, 40);
        GreenfootImage bg = getBackground();
        bg.setColor(Color.CYAN);
        bg.drawString("SAMPLE PROGRESS BAR/HEALTH METER", 140, 12);
        createBackgroundImage();  
        addObject(rocket, 300, 384);
        addObject(levelOne, getWidth()/2, getHeight()/2);
    }
    GreenfootImage bgImg = null; 
    int bgX; 
    final int starCount = 333;
    GreenfootImage bgImg2 = null;
    int bgX2;
    final int starCount2 = 1669;
    GreenfootImage bgImg3 = null;
    int bgX3;
    final int starCount3 = 9999;

    private void createBackgroundImage()  
    {  
        bgImg = new GreenfootImage(getWidth(), getHeight());  
        bgImg.setColor(Color.black);  
        bgImg.fill();  
        bgImg.setColor(Color.WHITE);  
        for (int i = 0; i < starCount; i++)  
        {  
            int x = Greenfoot.getRandomNumber(getWidth());  
            int y = Greenfoot.getRandomNumber(getHeight());  
            bgImg.fillOval(x, y, 2, 2);  
        }  
        setBackground(bgImg);  
    }  

    public void modifyLevel()
    {
        if(score.getTotalScore()==200)
        {
            bgImg2 = new GreenfootImage(getWidth(), getHeight());  
            bgImg2.setColor(new Color(33, 33, 133));  
            bgImg2.fill();  
            bgImg2.setColor(Color.yellow);  
            for (int i = 0; i < starCount2; i++)  
            {  
                int x = Greenfoot.getRandomNumber(getWidth());  
                int y = Greenfoot.getRandomNumber(getHeight());  
                bgImg2.fillOval(x, y, 2, 2);  
            }  
            setBackground(bgImg2);  
            addObject(levelTwo, getWidth()/2, getHeight()/2);
        }
    }
    
    public void modifyLevelAgain()
    {
        if(score.getTotalScore()==700)
        {
            backgroundMusic.stop();
            finalBackgroundMusic.playLoop();
            bgImg3 = new GreenfootImage(getWidth(), getHeight());  
            bgImg3.setColor(new Color(133, 33, 33));  
            bgImg3.fill();  
            bgImg3.setColor(Color.black);  
            for (int i = 0; i < starCount3; i++)  
            {  
                int x = Greenfoot.getRandomNumber(getWidth());  
                int y = Greenfoot.getRandomNumber(getHeight());  
                bgImg3.fillOval(x, y, 2, 2);  
            }  
            setBackground(bgImg3);  
            addObject(finalLevel, getWidth()/2, getHeight()/2);
            addObject(alienBoss, 1000, 384);
            addObject(bar3, 900, 40);
        }
    }

    private void scrollBackground()  
    {  
        if(score.getTotalScore()<200)
        {
            bgX = (bgX - 1) % getWidth();  
            GreenfootImage img = new GreenfootImage(getWidth(), getHeight());  
            img.drawImage(bgImg, bgX, 0);  
            img.drawImage(bgImg, bgX + getWidth(), 0);  
            setBackground(img);
        }
    } 

    private void scrollBackground2()  
    {  
        if((score.getTotalScore()>=200)&&(score.getTotalScore()<700))
        {
            bgX2 = (bgX2 - 1) % getWidth();  
            GreenfootImage img2 = new GreenfootImage(getWidth(), getHeight());  
            img2.drawImage(bgImg2, bgX2, 0);  
            img2.drawImage(bgImg2, bgX2 + getWidth(), 0);  
            setBackground(img2);  
        }
    } 
    
    private void scrollBackground3()
    {
        if(score.getTotalScore()>=700)
        {
            bgX3 = (bgX3 - 1) % getWidth();  
            GreenfootImage img3 = new GreenfootImage(getWidth(), getHeight());  
            img3.drawImage(bgImg3, bgX3, 0);  
            img3.drawImage(bgImg3, bgX3 + getWidth(), 0);  
            setBackground(img3);
        }
    }
}
