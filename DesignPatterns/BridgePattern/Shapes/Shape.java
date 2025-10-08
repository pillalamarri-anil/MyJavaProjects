package DesignPatterns.BridgePattern.Shapes;

public interface Shape {

    void fill( String color);

    void drawBorder( String color);

    void style( String design);

    void tessellate();
}
