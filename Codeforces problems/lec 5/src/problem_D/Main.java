package problem_D;


import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        long a = s.nextLong();
        long b = s.nextLong();
        long c = s.nextLong();
        long d = s.nextLong();

        if (a + b - c == d ||
                a + b * c == d ||
                a - b + c == d ||
                a - b * c == d ||
                a * b + c == d ||
                a * b - c == d)

            System.out.println("YES");

         else
            System.out.println("NO");
    }
}
