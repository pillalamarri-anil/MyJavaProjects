package DesignPatterns.BridgePattern.Shapes;

public class Sphere implements Shape {
    @Override
    public void fill(String color) {
        System.out.println("Filling sphere with color: " + color);
    }

    @Override
    public void drawBorder(String color) {
        System.out.println("Drawing sphere border with color: " + color);
    }

    @Override
    public void style(String design) {
        System.out.println("Styling sphere with design: " + design);
    }

    @Override
    public void tessellate() {
        System.out.println("Tessellating sphere");
    }
}
