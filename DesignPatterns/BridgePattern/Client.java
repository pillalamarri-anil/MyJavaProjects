package DesignPatterns.BridgePattern;

import DesignPatterns.BridgePattern.Painters.BasicPainter;
import DesignPatterns.BridgePattern.Painters.Designer;
import DesignPatterns.BridgePattern.Painters.Painter;
import DesignPatterns.BridgePattern.Shapes.Cone;
import DesignPatterns.BridgePattern.Shapes.Cube;

public class Client {

    public static void main(String[] args) {

        Painter basicPainter = new BasicPainter(new Cube());

        basicPainter.fillShape("Red");
        ((BasicPainter) basicPainter).drawShapeBorder("Black");

        Painter designer = new Designer(new Cone());

        designer.fillShape("Blue");
        ((Designer) designer).drawShapeBorder("White");
        ((Designer) designer).styleShape("Modern");
        ((Designer) designer).tessellateShape();
    }
}
