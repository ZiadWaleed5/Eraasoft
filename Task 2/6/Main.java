import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        School private_school = new School();

        System.out.println("Enter id of student of private school");
        private_school.setId(s.nextInt());
        
        s.nextLine(); 

        System.out.println("Enter name of student of private school");
        private_school.setName(s.nextLine());

        System.out.print("id -> " + private_school.getId() + "\t");
        System.out.print("name -> " + private_school.getName() + "\n");


        School public_school = new School();
        System.out.println("\nEnter id of student of public school");
        public_school.setId(s.nextInt());
        
        s.nextLine(); 

        System.out.println("Enter name of student of public school");
        public_school.setName(s.nextLine());

        System.out.print("id -> " + public_school.getId() + "\t");
        System.out.println("name -> " + public_school.getName());

        s.close();
    }
}