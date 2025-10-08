package DesignPatterns.BridgePattern.Painters;

import DesignPatterns.BridgePattern.Shapes.Shape;

public abstract class Painter {

    Shape shape = null;

    Painter(Shape shape){
        this.shape = shape;
    }

    public abstract void fillShape(String color);
}
