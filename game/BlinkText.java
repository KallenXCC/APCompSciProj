import greenfoot.*;

/**
 * Actor Class BlinkText: A subclass of the Button class used to create an inactive blinking Text object.
 * 
 * Author: danpost
 * Version: 1.0  August 18, 2012
 */
public class BlinkText extends Button
{
    int delay = 10; // number of act cycles between on and off blink states
    int state = 0; // the current blink state ('0' is off and '1' is on)
    int counter = 0; // the act cycle counter; when equal to 'delay', changes blink state and resets to zero
    Color[] textColors = { null, null }; // the two color for the text to alternate between
    
    /**
     * BlinkText Constructor:  Creates an inactive Button object by calling the Button
     * constructor with a button number of -1.  Also, sets up the blink variables.
     * This method uses the background color of the button for the alternate text color,
     * giving a text on / text off look.
     * 
     * @param 'txt':  The text to blink in the Text object
     * @param 'delayAmt':  The number of act cycles between changes in the text color
     */
    public BlinkText(String txt, int delayAmt)
    {
        super(txt, -1);
        delay = (int) Math.abs(delayAmt); // delay must be a positive integer
        if (delay == 0) delay = 1; // delay must be greater than zero
        textColors[0] = textColor; // one of the colors to be used for the text
        textColors[1] = buttonColor; // the other color to be used for the text
    }
    
    /**
     * BlinkText Constructor: Creates an inactive Button object using the given parameters by
     * calling the Button constructor with the given parameters and a button number of -1.
     * Also, sets up the blink variables. Uses button color for alternate color of text.
     *
     * @param 'txt':  The text to blink in the Text object
     * @param 'txtSize':  The font size of the text
     * @param 'txtColor':  One of the text colors
     * @param 'bgColor':  The color of the background of the Text object; also used as the other text color 
     * @param 'delayAmt':  The number of act cycles between changes in the text color
     */
    public BlinkText(String txt, int txtSize, Color txtColor, Color bgColor, int delayAmt)
    {
        super(txt, -1, txtSize, txtColor, bgColor);
        delay = (int) Math.abs(delayAmt); // delay must be a positive integer
        if (delay == 0) delay = 1; // delay must be greater than zero
        textColors[0] = textColor;
        textColors[1] = buttonColor;
    }

    /**
     * BlinkText Constructor:  Creates an inactive Button object by calling the Button
     * constructor with a button number of -1.  Also, sets up the blink variables.
     * 
     * @param 'txt':  The text to blink in the Text object
     * @param 'delayAmt':  The number of act cycles between changes in the text color
     * @param 'altColor':  The alternate text color of the text
     */
    public BlinkText(String txt, int delayAmt, Color altColor)
    {
        super(txt, -1);
        if (delay < 1) delay = 1; // delay must be greater than zero
        textColors[0] = textColor;
        textColors[1] = altColor;
    }
    
    /**
     * BlinkText Constructor: Creates an inactive Button object using the given parameters by
     * calling the Button constructor with the given parameters and a button number of -1.
     * Also, sets up the blink variables. 
     *
     * @param 'txt':  The text to blink in the Text object
     * @param 'txtSize':  The font size of the text
     * @param 'txtColor':  The color of the text
     * @param 'bgColor':  The color of the background of the Text object
     * @param 'delayAmt':  The number of act cycles between changes in the text color
     * @param 'altColor':  The alternate text color of the text
     */
    public BlinkText(String txt, int txtSize, Color txtColor, Color bgColor, int delayAmt, Color altColor)
    {
        super(txt, -1, txtSize, txtColor, bgColor);
        if (delay < 1) delay = 1; // delay must be greater than zero
        textColors[0] = textColor;
        textColors[1] = altColor;
    }
    /**
     * Method act:  Over-rides the 'act' of the Button superclass.
     * Runs the counter and alternates the text colors for the blinking or flashing action.
     */
    public void act()
    {
        counter = (counter + 1) % delay; // runs counter
        if (counter != 0) return; // returns if not yet time to change
        state = (state + 1) % 2; // changes the 'state' variable (from '0' to '1'; or from '1' to '0')
        setTextColor(textColors[state]); // changes the text color
    }
}
