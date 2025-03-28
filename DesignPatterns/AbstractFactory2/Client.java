package DesignPatterns.AbstractFactory2;

import DesignPatterns.AbstractFactory2.AnroidComponentFactory;
import DesignPatterns.AbstractFactory2.ComponentFactory;
import DesignPatterns.AbstractFactory2.IOSComponentFactory;
public class Client {

    static ComponentFactory CreateComponentFactory(String platForm)
    {
        if(platForm == "Anroid")
        {
            return new AndroidComponentFactory();
        }
        else if(platForm == "IOS")
        {
            return new IOSComponentFactory();
        }
        else
        {
            return null;
        }
    }

    public static void Main(String[] args) {
        ComponentFactory componentFactory = CreateComponentFactory("Anroid");
        componentFactory.createButton().render();
        componentFactory.createDropDown().render();
        componentFactory.createMenu().render();
    }
    
}
