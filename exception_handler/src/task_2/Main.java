package task_2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number");
        String num = s.next();

        try{
            int a = Integer.parseInt(num);
            System.out.println("the number is "+ a);
        }
        catch(NumberFormatException e){
            System.out.println("pls enter a number not letter");
        }
    }
}

/*
     بص يا معلم احنا هنا عايزين ندخل رقم ك string و يتحول ل int ف المفروض ندخل الحروف كارقام فاهمني

           لو حصل بقي غير كدا و كتبنا حروف ف الاكسبشن بتاع NumberFormatException هيشتغل
* */
