import java.util.Scanner;


class Main{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter number");
        int num1 = s.nextInt();
        System.out.println("Enter number");
        int num2 = s.nextInt();
        System.out.println("Enter number");
        int num3 = s.nextInt();

        Sum t = new Sum();
        t.setSum(num1, num2, num3);

        System.out.print("Sum of numbers is: ");
        System.out.println(t.getSum());
        
        s.close();
    }
}