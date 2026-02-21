import java.util.Scanner;

public class Problem_C {

   static class Calc{
        void calculating(long a, long b){
            System.out.println(a + " + " + b + " = " + (a+b) +"\n"+ a + " * " + b + " = "+ (a*b) +"\n"+ a +" - "+b +" = "+ (a-b) );
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner (System.in);
        long a = s.nextInt(); 
        long b = s.nextInt(); 

        Calc c = new Calc();
        c.calculating(a, b);

        s.close();
    }
}
