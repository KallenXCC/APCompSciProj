import greenfoot.*;

/**
 * World Class 'MenuWorld': A world to demonstrate the usage of the Support Actor Classes 
 * 'Button' and 'Menu'
 * 
 * Author: danpost
 * Version: 2.1  June 23, 2012
 */
public class MenuWorld extends World
{
    static final int WIDE = 1024, HIGH = 768;
    // The following are arrays of String text for the menu items
    // (the first is the title (which is programatically changed); the rest are the menu options)
    String[] menu1 = { "FIRST MENU", "One", "Two", "Three", "Four", "Five", "Six" };
    String[] menu2 = { "SECOND MENU", "First", "Second", "Third" };
    final int MAX_MENU_CT = 7; // number of example menus displayed in this world
    int menuNumber = MAX_MENU_CT - 1; // used to rotate through the menus
    Menu menu = null; // to hold the current menu object

    /**
     * Constructor MenuWorld: create a world of specified width (WIDE) and height (HIGH)
     * with a grid-size of 1; also adds an Instruct object giving instructions
     */
    public MenuWorld()
    {    
        super(WIDE, HIGH, 1);
        Text text = new Text("Rock\nCollector", 84, Color.BLACK, new Color(160, 160, 160));
        addObject(text, WIDE / 2, HIGH / 2);
        // example of making the sides less rounded
        text.setCircleFactor(200);
    }

    /**
     * Method 'started': removes the Instruct object (or Menu object with Button objects)
     * from the world, and places several non-menu buttons in the world
     */
    public void started()
    {
        menuNumber = MAX_MENU_CT - 1;
        Button.defaultButtonHeight = 30;
        Button.defaultRounded = false;
        Button.defaultTextColor = Color.RED;
        Button.defaultButtonColor = Color.CYAN;
        Button.defaultSolidFrame = true;
        int maxWide = 0;
        Button start = new Button("Start", 1);
        addObject(start, WIDE / 2, HIGH - 50);
        start.setButtonWidth(50);
    }

    /**
     * Method 'act': re-acts to button clicks and displays a new menu if all objects were removed from the world
     */
    public void act()
    {
        int selection = Button.getSelected(); // saving the button number so we can display it
        // The following should be placed in your world 'act' method
        switch (selection)
        {
            case -1:
                break; // no action required (no button was clicked)
            case -2:
                removeObjects(getObjects(Button.class));
                break; // 'New menu' (non-menu) button object was clicked
            default:
                removeObjects(getObjects(null));
                if(menu != null) menu.removeMenu();
                menu = null;
                Greenfoot.setWorld(new SpaceWorld());
        }
    }
}
