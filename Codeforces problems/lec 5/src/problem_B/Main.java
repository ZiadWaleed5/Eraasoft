package problem_B;

import java.util.Scanner;


public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        long a = s.nextInt();
        long b = s.nextInt();
        long k = s.nextInt();

        if (a % k == 0 && b % k == 0)
            System.out.println("Both");


        if (a % k == 0 && b % k != 0)
            System.out.println("Memo");


        if (a % k != 0 && b % k == 0)
            System.out.println("Momo");


        if (a % k != 0 && b % k != 0)
            System.out.println("No One");



    }
}
