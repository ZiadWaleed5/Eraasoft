package problem_H;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        long n = s.nextLong();
        long k = s.nextLong();
        long a = s.nextLong();

        long mul = n * k;
        long div = 0;

        if (mul % a == 0) {
            div = mul / a;
            if (div <= 2147483647L)
                System.out.println("int");
            else
                System.out.println("long long");
        }
        else
            System.out.println("double");
        }
}
