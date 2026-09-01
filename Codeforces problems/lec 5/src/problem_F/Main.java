package problem_F;

import java.util.Scanner;


public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        long a = s.nextLong();
        long b = s.nextLong();

        System.out.println(a ^ b); // عشان تفهم دي لازم تكون خدت مادة اللوجيك

        // الارقام اللي بندخلها بتتحول ل binary
        // بعدين ال xor بتشوف شغلها لو متشابهين 0 لو مختلفين 1
    }
}
