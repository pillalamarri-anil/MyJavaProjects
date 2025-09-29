package VisitorPattern;

public class Book implements Item{
    private String name;
    private int price;
    private String isbnNumber;

    private int inventoryCount;

    public Book(String name, int price, String isbnNumber, int inventoryCount) {
        this.name = name;
        this.price = price;
        this.isbnNumber = isbnNumber;
        this.inventoryCount = inventoryCount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
