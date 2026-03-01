import java.util.Scanner;

class Main{
public static void main(String[]args){
    Scanner s = new Scanner(System.in);
    
    System.out.println("Please Enter your num");
    int n = s.nextInt();

    s.nextLine();

    System.out.println("Please Enter your name");
    String l = s.nextLine();

    Info player = new Info();

    player.setNumber(n);
    player.setName(l);

    System.out.println(player.getNumber());
    System.out.println(player.getName());
    s.close();
    }
}