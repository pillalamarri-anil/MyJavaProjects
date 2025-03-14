public class Developer extends Employee{

    public Developer() {
        super("Developer");
    }

    public Developer(Developer developer) {
        super(developer);
    }

    @Override
    public Developer clone() {
        return new Developer(this);
    }

}
