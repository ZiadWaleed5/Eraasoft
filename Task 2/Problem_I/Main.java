import java.util.Scanner;

class Comparison {
    public int a;
    public int b;

    public void checkAndPrint() {
        if (a >= b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Comparison check = new Comparison();

            check.a = s.nextInt();
        
            check.b = s.nextInt();
        

        check.checkAndPrint();

        s.close();
    }
}