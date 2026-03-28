import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);


        PublicClub pub = new PublicClub();

        System.out.println("enter Number of player in public club");
        pub.num = s.nextInt();
        s.nextLine();
        System.out.println("enter Name of player in public club");        
        pub.name = s.nextLine();
        pub.publicClub();

        PrivateClub pri = new PrivateClub();

        System.out.println("enter Number of player in private club ");
        pri.setNum(s.nextInt());
        s.nextLine();
        System.out.println("enter Name of player in private club ");
        pri.setName(s.nextLine());
        System.out.println(pri.getNum());
        System.out.println(pri.getName());

        s.close();
    }
}