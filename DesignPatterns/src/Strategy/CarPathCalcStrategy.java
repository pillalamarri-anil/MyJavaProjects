package DesignPatterns.src.Strategy;

public class CarPathCalcStrategy implements PathCalcStrategy {
    @Override
    public void findPath() {
        System.out.println("Finding path for Car");
    }
}