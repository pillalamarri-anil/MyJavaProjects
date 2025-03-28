package DesignPatterns.AbstractFactory2.Compontent.Button;

public class IOSButton extends  Button {

    @Override
    public void render() {
        System.out.println("Rendering IOS Button");
    }

}
