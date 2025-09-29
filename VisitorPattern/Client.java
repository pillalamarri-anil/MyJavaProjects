package VisitorPattern;

import java.util.jar.JarOutputStream;

public class Client {

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Book( "Book1", 20, "1234", 3),
                new Book("book2", 100, "5678", 5),
                new Fruit("Pineapple", 20, 1, 2),
                new Fruit("Banana", 5, 1, 10)};

        int price = 0;
        PriceVisitor priceVisitor = new PriceVisitor();
        for(Item item : items)
        {
            price += item.accept(priceVisitor);
        }

        System.out.println("Total Cost = " + price);


        int inventory = 0;
        InventoryVisitor inventoryVisitor = new InventoryVisitor();
        for(Item item : items)
        {
            inventory += item.accept(inventoryVisitor);
        }

        System.out.println("Total Inventory = " + inventory);

    }
}
