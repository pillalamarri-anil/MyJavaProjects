package DesignPatterns.BridgePattern.Shapes;

public class Cone implements Shape{
    @Override
    public void fill(String color) {
        System.out.println("Filling cone with color: " + color);
    }

    @Override
    public void drawBorder(String color) {
        System.out.println("Drawing cone border with color: " + color);
    }

    @Override
    public void style(String design) {
        System.out.println("Styling cone with design: " + design);
    }

    @Override
    public void tessellate() {
        System.out.println("Tessellating cone");
    }
}
