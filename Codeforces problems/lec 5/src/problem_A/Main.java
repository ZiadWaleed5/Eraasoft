package problem_A;
import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        int discount = s.nextInt();
        int priceAfter = s.nextInt();

        double priceBefore = (priceAfter * 100) / (double)(100 - discount);
        System.out.printf("%.2f", priceBefore);
    }
}

/*
 المسالة هنا بسيطة بتديلك السعر بعد الخصم و الخصم و عايزة السعر قبل الخصم ليها حل تاني بس عملت دا عشان اول حاجة جه ف بالي

   يعني لو مثلا معايا حاجة ب 80 جنيه و عليها خصم 20 ف المية بعمل كدا

   نسبة السعر (100 - 20)           السعر بعد الخصم
        80                            80
        X                             100

*/