package VisitorPattern;

public class InventoryVisitor implements Visitor {
    @Override
    public int visit(Book book) {
        return book.getInventoryCount();
    }

    @Override
    public int visit(Fruit fruit) {
        return fruit.getInventoryCount();
    }
}
