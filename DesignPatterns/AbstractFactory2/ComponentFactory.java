package DesignPatterns.AbstractFactory2;



import DesignPatterns.AbstractFactory.Components.Button.Button;
import DesignPatterns.AbstractFactory.Components.DropDown.DropDown;
import DesignPatterns.AbstractFactory.Components.Menu.Menu;

public interface ComponentFactory {
    Button createButton();
    DropDown createDropDown();
    Menu createMenu();
}
