package DesignPatterns.BridgePattern.Painters;

import DesignPatterns.BridgePattern.Shapes.Shape;

public class Designer extends Painter{

    public Designer(Shape shape) {
        super(shape);
    }

    public void styleShape(String design) {
        shape.style(design);
    }

    public void tessellateShape() {
        shape.tessellate();
    }

    @Override
    public void fillShape(String color) {
        shape.fill(color);
    }

    public void drawShapeBorder(String color) {
        shape.drawBorder(color);
    }
}
