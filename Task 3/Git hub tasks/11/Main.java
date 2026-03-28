import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        Order o = new Order();
        o.addOrder();
        o.setId(s.nextInt());
        s.nextLine();

        o.request();
        o.setRequest(s.nextLine());

        System.out.print("Your order is ");
        System.out.println(o.getId());

        System.out.print("Your request is ");
        System.out.println(o.getRequest());
    }
}