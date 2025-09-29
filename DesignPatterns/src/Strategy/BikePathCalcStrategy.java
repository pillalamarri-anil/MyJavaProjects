package DesignPatterns.src.Strategy;

public class BikePathCalcStrategy implements PathCalcStrategy{
    @Override
    public void findPath() {
        System.out.println("Finding path for bike");
    }
}
