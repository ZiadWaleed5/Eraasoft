package problem_I;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int a = n % 10;

        int b = (n - a) / 10;

        if (a % b == 0 || b % a == 0)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
