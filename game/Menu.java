import greenfoot.*;

/**
 * Actor Class Menu: A backdrop for the menu that also sets up the menu objects
 * 
 * Author: danpost
 * Version: 2.1  June 23, 2012
 */
public class Menu extends Actor
{
    private boolean canCancel = false; // to determine if the menu may be cancelled by clicking on the title object
    private String[] buttonText; // to hold the array of Strings to be the text of the menu items
    private Button[] button; // to hold the array of Buttons created for this menu
    private boolean wasSizedSame = false; // flag indicating if the buttons were sized the same
    private int menuAlpha = 96; // the background alpha value (min: 0 'transparent'; max: 255 'opaque')
    
    /**
     * Menu Constructor: saves the variables and creates a base backdrop image for the menu object;
     *                   this constructor must be used if exiting the menu is to be allowed without
     *                   selecting an option button
     *
     * @param 'items': the String array of menu object text
     * @param 'cancelOn': a flag determining if the user can cancel the menu or not
     */
    public Menu(String[] txtArray, boolean cancelFlag)
    {
        // save the variables; to be used when Menu object is added to the world
        buttonText = txtArray;
        canCancel = cancelFlag;
        // Create the initial backdrop image for the menu; to be re-sized and framed when added to world
        initializeImage();
    }
    
    /**
     * Menu Constructor: calls the constructor above with the default values for the background color and cancel flag
     *
     * @param 'items': the String array of menu object text
     */
    public Menu(String[] txtArray)
    {
        this(txtArray, false);
    }
    
    /**
     * Method 'initializeImage': creates a base image for the menu object (the window tint)
     */
    private void initializeImage()
    {
        GreenfootImage img = new GreenfootImage(1,1);
        img.setColor(new Color(255, 255, 255, menuAlpha));
        img.fill();
        setImage(img);
    }
    
    /**
     * Method 'finalizeImage': uses the base image from 'initializeImage' to create the "window tint" menu image
     */
    private void finalizeImage()
    {
        GreenfootImage img = getImage();
        img.scale(getWorld().getWidth(), getWorld().getHeight());
        img.setColor(new Color(0, 0, 0, menuAlpha));
        for (int i = 0; i < 5; i++) img.drawRect(i, i, img.getWidth() - 1 - i * 2, img.getHeight() - 1 - i * 2);
        setImage(img);
    }
    
    /**
     * Method 'addedToWorld': adds the menu objects into the world
     *
     * @param 'world': the world the Menu object was added to
     */
    public void addedToWorld(World world)
    {
        // compute the distance between menu items and the size of those items
        int gap = world.getHeight() / (buttonText.length + 1);
        int holdDefaultHeight = Button.defaultButtonHeight;
        Button.defaultButtonHeight = Math.min(72, gap * 9 / 10);
        // re-size and frame the initial backdrop image
        finalizeImage();
        // add the option buttons to the world and save them to the button array
        button = new Button[buttonText.length];
        for (int i = 0; i < buttonText.length; i++)
        {
            button[i] = new Button(buttonText[i], i);
            world.addObject(button[i], world.getWidth() / 2, gap * (i + 1));
        }
        if (!canCancel) button[0].deactivate();
        Button.defaultButtonHeight = holdDefaultHeight;
    }
    
    /**
     * Method 'deactivateButton': deactivates the specified menu button
     *
     * @param 'btnNum': the button number
     */
    public void deactivateButton(int btnNum)
    {
        if (btnNum >= 0 && btnNum < button.length) button[btnNum].deactivate();
    }
    
    /**
     * Method 'activateButton': activates the specified active menu button that is not a title button
     *
     * @param 'btnNum': the button number
     */
    public void activateButton(int btnNum)
    {
        if ((btnNum != 0 || canCancel) && btnNum >= 0 && btnNum < button.length) button[btnNum].activate();
    }
    
    /**
     * Method 'setButtonAlpha': sets all menu button image alphas to the specified value
     *
     * @param 'alfa': the alpha value
     */
    public void setButtonAlpha(int alfa)
    {
        for (int i = 0; i < button.length; i++) button[i].setImageAlpha(alfa);
    }
    
    /**
     * Method 'setSameSizeButtons': sets the width of all menu buttons to that of the largest width
     */
    public void setSameSizeButtons()
    {
        int maxWide = 0;
        for (int i = 0; i < button.length; i++) maxWide = Math.max(maxWide, button[i].getButtonWidth());
        for (int i = 0; i < button.length; i++) button[i].setButtonWidth(maxWide);
        wasSizedSame = true;
    }
    
    /**
     * Method 'setTextColor': sets the text color of all menu buttons
     *
     * @param 'txtColor': the new menu buttons text color
     */
    public void setTextColor(Color txtColor)
    {
        for (int i = 0; i < button.length; i++) button[i].setTextColor(txtColor);
    }
    
    /**
     * Method 'setButtonColor': sets the background color of all menu buttons
     *
     * @param 'btnColor': the new menu button background color
     */
    public void setButtonColor(Color btnColor)
    {
        for (int i = 0; i < button.length; i++) button[i].setButtonColor(btnColor);
    }
    
    /**
     * Method 'setButtonText': changes the text of the specified menu button
     *
     * @param 'btnNum': the button number
     * @param 'newText': the new menu button text
     */
    public void setButtonText(int btnNum, String newText)
    {
        buttonText[btnNum] = newText;
        if (!wasSizedSame)
        {
            button[btnNum].setText(buttonText[btnNum]);
            return;
        }
        for (int i = 0; i < button.length; i++) button[i].setText(buttonText[i]);
       setSameSizeButtons();
    }
    
    
    /**
     * Method 'setMenuAlpha': sets the alpha for the menu image (window tint)
     *
     * @param alfa': the new menu image alpha
     */
    public void setMenuAlpha(int alfa)
    {
        if (alfa < 128 || alfa > 255) return;
        menuAlpha = alfa;
        initializeImage();
        finalizeImage();
    }
    
    /**
     * Method 'setRoundButtons': sets the style of the all menu button images (rounded off or squared off)
     *
     * @param 'areRound': the menu buttons images rounded/not rounded state
     */
    public void setRoundButtons(boolean areRound)
    {
        for (int i = 0; i < button.length; i++) button[i].setRounded(areRound);
    }
    
    /**
     * Method 'setButtonCircleFactor': sets the straightness factor for the circular edges of all menu buttons
     *
     * @param 'circFactor':  the new straightness factor
     */
    public void setButtonCircleFactor(int circFactor)
    {
        for (int i = 0; i < button.length; i++) button[i].setCircleFactor(circFactor);
    }
    
    /**
     * Method 'removeMenu': removes this Menu and all its Button objects from the world
     */
    public void removeMenu()
    {
        for (int i = 0; i < button.length; i++) getWorld().removeObject(button[i]);
        getWorld().removeObject(this);
    }
}
