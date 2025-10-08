package DesignPatterns.BridgePattern.Painters;

import DesignPatterns.BridgePattern.Shapes.Shape;

public class BasicPainter extends Painter{

    public BasicPainter(Shape shape) {
        super(shape);
    }

    @Override
    public void fillShape(String color) {
        shape.fill(color);
    }

    public void drawShapeBorder(String color) {
        shape.drawBorder(color);
    }

}
