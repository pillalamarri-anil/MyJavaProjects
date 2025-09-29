package VisitorPattern;

public class PriceVisitor implements Visitor{

    @Override
    public int visit(Book book) {

        return book.getPrice();
    }

    @Override
    public int visit(Fruit fruit) {

        return fruit.getPricePerKg() * fruit.getWeight();
    }

}
