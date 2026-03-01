import java.util.Scanner;


public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        Player t1 = new Player();

        System.out.println("Information of player");
        System.out.println("Enter player name");
        t1.setName(s.nextLine());
        System.out.println("Enter your id");
        t1.setId(s.nextInt());
        System.out.println("Enter your number");
        t1.setNumber(s.nextInt());

        System.out.println(t1.getName());
        System.out.println(t1.getId());
        System.out.println(t1.getNumber());

        Student t2 = new Student();

        System.out.println("Information of teacher");
        s.nextLine();
        System.out.println("Enter student name");
        t2.setName(s.nextLine());
        System.out.println("Enter your id");
        t2.setId(s.nextInt());
        System.out.println("Enter your age");
        t2.setAge(s.nextInt());

        System.out.println(t2.getName());
        System.out.println(t2.getId());
        System.out.println(t2.getAge());

        s.close();
    }    
}
