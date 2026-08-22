package task_11;
import java.util.Scanner;


public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner (System.in);
        System.out.println("enter the num as string");
        String t = s.next();

        try{
            int num = Integer.parseInt(t);
            System.out.println("No exception is occured :"+t);
        }
        catch(NumberFormatException e){
            System.out.println("you should enter number as text only");
        }
        finally{
            System.out.println("like \"10\"");
        }
    }
}


/*
      هنا عايز يقولك سواء الاكسبشن اشتغل او لا ال finnaly ملهاش دعوة و هتعمل اللي جواه عادي جدا ملهاش دعوة

*/