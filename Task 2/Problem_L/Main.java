import java.util.Scanner;

class Person {
    public String firstName;
    public String secondName;

    public boolean isBrother(Person other) {
        return secondName.equals(other.secondName);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Person p1 = new Person();
        p1.firstName = s.next();
        p1.secondName = s.next();

        Person p2 = new Person();
        p2.firstName = s.next();
        p2.secondName = s.next();

        if (p1.isBrother(p2)) {
            System.out.println("ARE Brothers");
        } else {
            System.out.println("NOT");
        }

        s.close();
    }
}