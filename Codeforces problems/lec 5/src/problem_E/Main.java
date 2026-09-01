package problem_E;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            int a = s.nextInt();
            int b = s.nextInt();

            if (a == 0 && b == 0)
                System.out.println("NO");

            else if (Math.abs(a - b) <= 1)
                System.out.println("YES");

            else
                System.out.println("NO");

        }
    }
