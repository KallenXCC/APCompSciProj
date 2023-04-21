import greenfoot.*;

/**
 * Actor Class Marquiss: A subclass of the Button class used to create an inactive scrolling Text object.
 * 
 * Author: danpost
 * Version: 1.0  August 18, 2012
 */
public class Marquiss extends Button
{
    int scrollPosition = 0; // the horizontal location on the button where the text is to start
    int rate = 3; // the speed at which to text scrolls across the button (pixels per move)
    GreenfootImage buttonImage = null; // to hold the button background image
    GreenfootImage textImage = null; // to hold the text image
    /**
     * Marquiss Constructor:  Creates an inactive Button object by calling the Button
     * constructor with a button number of -1.  Also, saves the speed of scrolling.
     * 
     * @param 'txt':  The text to scroll on the Text object
     * @param 'speed': The number of pixel to move each act cycle
     */
    public Marquiss(String txt, int speed)
    {
        super(txt, -1);
        rate = speed;
    }
    
    /**
     * Marquiss Constructor: Creates an inactive Button object using the given parameters by
     * calling the Button constructor with the given parameters and a button number of -1.
     * Also, saves the speed of scrolling.
     *
     * @param 'txt':  The text to scroll in the Text object
     * @param 'txtSize':  The font size of the text
     * @param 'txtColor':  The color of the text
     * @param 'bgColor':  The color of the background of the Text object
     * @param 'speed': The number of pixel to move each act cycle
     */
    public Marquiss(String txt, int txtSize, Color txtColor, Color bgColor, int speed)
    {
        super(txt, -1, txtSize, txtColor, bgColor);
        rate = speed;
    }

    /**
     * Method 'act':  Over-rides the 'act' of the Button superclass.
     * Creates a new image and advances the scroll position
     */
    public void act()
    {
        updateImage();
        scrollPosition = (scrollPosition + rate) % (getButtonWidth() * 2);
    }
    
    /**
     * Method 'updateImage': Over-rides the 'updateImage' of the Button superclass.
     * Simplified version of the method, eliminating all extraneous code related to mouse actions
     * and saving the background button image so it does not have to be created each cycle.
     * This was done for expedience, because it is called every act cycle.
     */
    private void updateImage()
    {
        // create the button background image for the button, if has not been done yet
        if (buttonImage == null)
        {
            // create the image of the text for the button image
            textImage = new GreenfootImage(text, fontSize, textColor, new Color(0, 0, 0, 0));
            GreenfootImage image = new GreenfootImage(buttonHeight - circleFactor, buttonHeight);
            image.setColor(buttonColor);
            if (rounded)
            {
                image.fillOval(0, 0, buttonHeight - circleFactor - 1, buttonHeight - 1); // the background color (circle)
                image.setColor(frameColor);
                if (frameLineCount > 1) image.drawOval(2, 2, buttonHeight - circleFactor - 5, buttonHeight - 5); // inner border line of circle
                if (frameLineCount > 0) image.drawOval(0, 0, buttonHeight - circleFactor - 1, buttonHeight - 1); // outer border line of circle
                if (solidFrame && frameLineCount > 0) image.drawOval(1, 1, buttonHeight - circleFactor - 3, buttonHeight - 3); // fill between outer and inner border lines
            }
            else
            {
                image.fill();
                image.setColor(frameColor);
                if (frameLineCount > 1) image.drawRect(2, 2, buttonHeight - 5, buttonHeight - 5); // inner border line of box
                if (frameLineCount > 0) image.drawRect(0, 0, buttonHeight - 1, buttonHeight - 1); // outer border line of box
                if (solidFrame && frameLineCount > 0) image.drawRect(1, 1, buttonHeight - 3, buttonHeight - 3); // fill between outer and inner border lines
            }
            int newW = initialButtonWidth == 0 ? buttonHeight + textImage.getWidth() : buttonWidth; // target width of object image
            while (image.getWidth() < newW) image.scale(image.getWidth() + 1, image.getHeight()); // stretches image width
            while (image.getWidth() > newW) image.scale(image.getWidth() - 1, image.getHeight()); // shrinks image width
            buttonImage = new GreenfootImage(image); // saves the background button image
        }
        // applies the text image to the main image
        GreenfootImage image = new GreenfootImage(buttonImage);
        image.drawImage(textImage, (image.getWidth() - textImage.getWidth()) / 2 - scrollPosition + getButtonWidth(), (image.getHeight() - textImage.getHeight()) / 2);
        image.setTransparency(imageAlpha);
        setImage(image);
    }
    
    public void setButtonColor(Color btnColor)
    {
        buttonColor = btnColor;
        buttonImage = null;
        updateImage();
    }
    
    public void setButtonHeight(int btnHeight)
    {
        if (btnHeight < fontSize) return;
        buttonHeight = btnHeight;
        buttonImage = null;
        updateImage();
    }
    
    public void setButtonWidth(int btnWidth)
    {
        if (btnWidth < initialButtonWidth) return;
        buttonWidth = btnWidth;
        buttonImage = null;
        updateImage();
    }
    
    public void setCircleFactor(int circFactor)
    {
        
        circleFactor = circFactor;
        buttonImage = null;
        updateImage();
    }
    
    public void setFrameColor(Color frmColor)
    {
        frameColor = frmColor;
        buttonImage = null;
        updateImage();
    }
    
    public void setFrameLineCount(int lineCt)
    {
        if (lineCt < 0 || lineCt > 2) return;
        frameLineCount = lineCt;
        buttonImage = null;
        updateImage();
    }
    
    public void setFontSize(int fSize)
    {
        fontSize = fSize;
        buttonImage = null;
        updateImage();
    }
    
    public void setImageAlpha(int alfa)
    {
        if (alfa < 128 || alfa > 255) return;
        imageAlpha = alfa;
        updateImage();
    }
    
    public void setRounded(boolean isRound)
    {
        rounded = isRound;
        buttonImage = null;
        updateImage();
    }
    
    public void setSolidFrame(boolean isSolid)
    {
        solidFrame = isSolid;
        buttonImage = null;
        updateImage();
    }
    
    public void setText(String txt)
    {
        text = txt;
        buttonImage = null;
        updateImage();
    }
    
    public void setTextColor(Color txtColor)
    {
        textColor = txtColor;
        buttonImage = null;
        updateImage();
    }
}