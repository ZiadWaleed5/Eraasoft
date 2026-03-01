import java.util.Scanner;


class BaseEntity{
    public String name;
    public int id;
}

class ShareDate extends BaseEntity{
    public String phone;
}

class Person extends BaseEntity{
}

class Player extends ShareDate{
    public int number;
}

class Student extends ShareDate{
    public int age;
}


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Player p = new Player();
        System.out.println("Enter Player Data");
        System.out.print("Name: ");    
        p.name = s.nextLine();
        System.out.print("Phone: ");
        p.phone = s.nextLine();
        System.out.print("ID: ");      
        p.id = s.nextInt();
        System.out.print("Number: "); 
         p.number = s.nextInt();
        s.nextLine(); 

        Student s1 = new Student();
        System.out.println(" Enter Student Data");
        System.out.print("Name: ");    
        s1.name = s.nextLine();
        System.out.print("Phone: ");   
        s1.phone = s.nextLine();
        System.out.print("ID: ");      
        s1.id = s.nextInt();
        System.out.print("Age: ");     
        s1.age = s.nextInt();

        System.out.println("Player: " + p.name + "  ID: " + p.id + "  Phone: " + p.phone + "  Number: " + p.number);
        System.out.println("Student: " + s1.name + "  ID: " + s1.id + "  Phone: " + s1.phone + "  Age: " + s1.age);
        
        s.close();
    }
}

