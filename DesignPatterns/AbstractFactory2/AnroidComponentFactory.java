package DesignPatterns.AbstractFactory2;

import DesignPatterns.AbstractFactory2.Compontent.Button.AnroidButton;
import DesignPatterns.AbstractFactory2.Compontent.Button.Button;
import DesignPatterns.AbstractFactory2.Compontent.DropDown.AnroidDropDown;
import DesignPatterns.AbstractFactory2.Compontent.DropDown.DropDown;
import DesignPatterns.AbstractFactory2.Compontent.Menu.AnroidMenu;
import DesignPatterns.AbstractFactory2.Compontent.Menu.Menu;

public class AnroidComponentFactory implements ComponentFactory {
    public Button createButton()
    {
        return new AnroidButton();
    }

    public DropDown createDropDown()
    {
        return new AnroidDropDown();
    }
    
    public Menu createMenu()
    {
        return new AnroidMenu();
    }

}
