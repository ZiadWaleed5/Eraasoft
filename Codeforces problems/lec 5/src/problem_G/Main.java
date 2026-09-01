package problem_G;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        long eyes = s.nextLong();
        long mouths = s.nextLong();
        long bodies = s.nextLong();

        long total1 = Math.min(eyes, Math.min(mouths, bodies));

        eyes  = eyes - total1;
        bodies = bodies - total1;

        long total2 = Math.min(eyes / 2, bodies);

        long total = total1 + total2;

        System.out.println(total);
    }
}
 /*
      المسالة دي معتمدة ع ال algorithm حاجة اسمها greedy approach
      بتشوف اقل حاجة تحقق المطلوب و هو انك تستعمل عين و بق و جسم واحد بس
      بعد كدا تستعمل الباقي م العينين و الجسم

 */