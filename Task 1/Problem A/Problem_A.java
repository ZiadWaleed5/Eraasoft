import java.util.Scanner;
public class Problem_A {

     static class Print{
        Print(String n){
            System.out.println("Hello, "+n);
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String name = s.nextLine();

         new Print(name);

        s.close();
    }
}
