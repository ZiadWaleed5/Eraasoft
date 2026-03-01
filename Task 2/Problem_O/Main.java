import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();   

        String[] parts = s.split("[+\\-*/=]");
        char op = s.charAt(parts[0].length());

        long a = Long.parseLong(parts[0]);
        long b = Long.parseLong(parts[1]);

        long real = 0;

        if (op == '+') real = a + b;
        else if (op == '-') real = a - b;
        else if (op == '*') real = a * b;
        else if (op == '/') real = a / b;

        if (s.contains("=")) {
            long q = Long.parseLong(parts[2]);

            if (real == q)
                System.out.println("Yes");
            else
                System.out.println(real);
        } else {
            System.out.println(real);
        }

        sc.close();
    }
}