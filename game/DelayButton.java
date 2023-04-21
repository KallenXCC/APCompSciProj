import greenfoot.*;

/**
 * Actor Class DelayButton: A subclass of the Button class giving the button the ability
 * to control how quickly it can be clicked on.  It can be in an active state or an
 * inactive state upon creation, and will be put in an inactive state for the delay
 * count if clicked on.
 * 
 * Author: danpost
 * Version: 1.1  August 7, 2012
 */
public class DelayButton extends Button
{
    private int delayTime = 1; // minimum delay time in seconds
    private long lastSelectTime = 0; // when equals to zero, button is active
    
    /**
     * DelayButton Constructor: creates the DelayButton object using the given parameters
     *
     * @param 'txt':  The given text for the button
     * @param 'val':  The number given to represent the button
     * @param 'delayAmt':  The number of seconds to delay, when delaying
     * @param 'delaying':  The beginning delay state of the button
     */
    public DelayButton(String txt, int val, int delayAmt, boolean delaying)
    {
        super(txt, val);
        setDelay(delayAmt, delaying);
    }
    
    /**
     * DelayButton Constructor: creates the DelayButton object using the given parameters
     *
     * @param 'txt':  The given text for the button
     * @param 'val':  The number given to represent the button
     * @param 'txtSize':  The font size to be used for the text
     * @param 'txtColor':  The color to be used for the text
     * @param 'btnColor':  The color to be used for the background of the button
     * @param 'delayAmt':  The number of seconds to delay, when delaying
     * @param 'delaying':  The beginning delay state of the button
     */
    public DelayButton(String txt, int val, int txtSize, Color txtColor, Color btnColor, int delayAmt, boolean delaying)
    {
        super(txt, val, txtSize, txtColor, btnColor);
        setDelay(delayAmt, delaying);
    }
    
    /**
     * Method 'setDelay':  Sets the initial state of the button dependent on given parameters
     *
     * @param 'delayAmt':  The number of seconds to delay, when delaying
     * @param 'delaying':  The beginning delay state of the button
     */
    private void setDelay(int delayAmt, boolean delaying)
    {
        delayTime = delayAmt;
        if (delaying) delay();
    }

    /**
     * Method act':  Calls 'act' in 'Button' class on this object; then, does all the delay
     * checking and processing
     */
    public void act()
    {
        super.act();
        // check to start the delay
        if (Button.selected == getButtonNumber()) delay();
        // check to end the delay
        if (lastSelectTime > 0)
        {
            if (System.currentTimeMillis() - lastSelectTime > delayTime * 1000)
            {
                activate();
                lastSelectTime = 0;
            }
        }
    }
    
    /**
     * Method 'delay':  puts the button in the 'delay' state.  This method is 'public' and
     * can be called from the world or another actor class, but will usually be called from here.
     */
    public void delay()
    {
        deactivate();
        lastSelectTime = System.currentTimeMillis();
    }
}
