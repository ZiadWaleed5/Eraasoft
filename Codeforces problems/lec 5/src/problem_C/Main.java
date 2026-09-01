package problem_C;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        char a = s.next().charAt(0);

        if (a == 'z')
            System.out.println("a");
        else
            System.out.println((char)(a +1));




    }
}
