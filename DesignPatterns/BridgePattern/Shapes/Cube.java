package DesignPatterns.BridgePattern.Shapes;

public class Cube implements Shape {
    @Override
    public void fill(String color) {
        System.out.println("Filling cube with color: " + color);
    }

    @Override
    public void drawBorder(String color) {
        System.out.println("Drawing cube border with color: " + color);
    }

    @Override
    public void style(String design) {
        System.out.println("Styling cube with design: " + design);
    }

    @Override
    public void tessellate() {
        System.out.println("Tessellating cube");
    }
}
