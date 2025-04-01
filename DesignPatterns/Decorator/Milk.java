package DesignPatterns.Decorator;

public class Milk extends AddOn {

    public Milk (Beverage b){
        super(b);
    }

    @Override
    public void getDesc() {
        this.beverage.getDesc();
        System.out.println("Milk");
    }

    @Override
    public int getCost() {
        return this.beverage.getCost() + 2;
    }
}
