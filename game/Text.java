import greenfoot.*;

/**
 * Actor Class Text: A subclass of the Button class used to create an inactive Text object.
 * 
 * Author: danpost
 * Version: 1.1  August 7, 2012
 */
public class Text extends Button
{
    /**
     * Text Constructor:  Creates an inactive Button object by calling the Button
     * constructor with a button number of -1.
     * 
     * @param 'txt':  The text to display in the Text object
     */
    public Text(String txt)
    {
        super(txt, -1);
    }
    
    /**
     * Text Constructor: Creates an inactive Button object using the given parameters by
     * calling the Button constructor with the given parameters and a button number of -1.
     *
     * @param 'txt':  The text to display in the Text object
     * @param 'txtSize':  The font size of the text
     * @param 'txtColor':  The color of the text
     * @param 'bgColor':  The color of the background of the Text object
     */
    public Text(String txt, int txtSize, Color txtColor, Color bgColor)
    {
        super(txt, -1, txtSize, txtColor, bgColor);
    }

    /**
     * Method act:  Over-rides the 'act' of the Button superclass.
     */
    public void act()
    {
    }
}
