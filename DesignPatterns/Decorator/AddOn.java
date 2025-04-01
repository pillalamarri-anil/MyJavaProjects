package DesignPatterns.Decorator;

public abstract  class  AddOn implements Beverage {
    
    private  Beverage beverage;

    AddOn(Beverage beverage) {
        this.beverage = beverage;
    }

}
