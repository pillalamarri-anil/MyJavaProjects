package DesignPatterns.AbstractFactory2;



import DesignPatterns.AbstractFactory.Components.Button.Button;
import DesignPatterns.AbstractFactory.Components.Button.IOSButton;
import DesignPatterns.AbstractFactory.Components.DropDown.DropDown;
import DesignPatterns.AbstractFactory.Components.DropDown.IOSDropDown;
import DesignPatterns.AbstractFactory.Components.Menu.IOSMenu;
import DesignPatterns.AbstractFactory.Components.Menu.Menu;

public class IOSComponentFactory implements ComponentFactory {

    public IOSComponentFactory() {
    }

    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public DropDown createDropDown() {
        return new IOSDropDown();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }

}
