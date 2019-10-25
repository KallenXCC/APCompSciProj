import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class StartButton extends Actor
{
    String caption = "";  

    public void Button(String text)  
    {  
        caption = text;  
        updateImage();  
    }  

    private void updateImage()  
    {  
        setImage(java.lang.String);
    }  

    public void act()  
    {  
        if (Greenfoot.mouseClicked(this))  
        {  
            World mw = (World) getWorld();  
            // mw.menuItem = caption;  
            // the last line     OR    the next line  
            // mw.setMenuItem(caption);  
        }  
    }  
}  