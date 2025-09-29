package VisitorPattern;

public class Fruit implements Item{

    private String name;

    private int pricePerKg;

    private int weight;

    private int inventoryCount;

    public Fruit(String name, int pricePerKg, int weight, int inventoryCount) {
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.inventoryCount = inventoryCount;
    }

    public String getName() {
        return name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    @Override
    public int accept(Visitor visitor) {

        return visitor.visit(this);

    }
}
