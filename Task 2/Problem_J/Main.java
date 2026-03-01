import java.util.Scanner;

class MultiplesChecker {
    public int a;
    public int b;

    public void check() {
        if (a % b == 0 || b % a == 0) {
            System.out.println("Multiples");
        } else {
            System.out.println("No Multiples");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        MultiplesChecker checker = new MultiplesChecker();
        
        checker.a = s.nextInt();
        checker.b = s.nextInt();

        checker.check();

        s.close();
    }
}