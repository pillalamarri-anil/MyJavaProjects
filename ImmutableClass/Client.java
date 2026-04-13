package ImmutableClass;

import java.util.Date;

final  class ImmutableClass
{
     final private String name;

     final private Date date;

    public ImmutableClass(String name, Date date) {
        this.name = name;
        this.date = new Date(date.getTime());
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }
}

public class Client {

    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass("Anil", Date.from(java.time.Instant.now()));

        Date date1 = immutableClass.getDate();
        Date date2 = immutableClass.getDate();

        System.out.println(date1);
        System.out.println(date2);

        // add 10min to data
        date1.setTime(date1.getTime() + 10 * 60 * 1000);

        System.out.println(date1);
        System.out.println(date2);

    }
}
