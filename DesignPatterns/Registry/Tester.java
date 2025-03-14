public class Tester extends Employee{

    public Tester() {
        super("Tester");
    }

    public Tester(Tester tester) {
        super(tester);
    }

    @Override
    public Tester clone() {
        return new Tester(this);
    }
}
