import java.util.Scanner;

class Player {
    public int id;
    public String name;
    public int number;
}

class ClubFC extends Player {
    public String fCode;
}

class ClubReal extends Player {
    public String rCode;
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        
        ClubFC fc = new ClubFC();
        System.out.println(" Enter Club FC Player Data ");
        System.out.print("ID: "); 
        fc.id = s.nextInt();
        s.nextLine(); 
        System.out.print("Name: "); 
        fc.name = s.nextLine();
        System.out.print("Number: "); 
        fc.number = s.nextInt();
        s.nextLine();
        System.out.println("F-Code: "); 
        fc.fCode = s.nextLine();

        ClubReal r = new ClubReal();
        System.out.println("Enter Club r Player Data ");
        System.out.print("ID: "); 
        r.id = s.nextInt();
        s.nextLine();
        System.out.print("Name: "); 
        r.name = s.nextLine();
        System.out.print("Number: ");
        r.number = s.nextInt();
        s.nextLine();
        System.out.print("R-Code: "); 
        r.rCode = s.nextLine();

        System.out.println("Info FC club: " + fc.id + " " + fc.name + " " + fc.number);
        
        System.out.println("Info r club: " + r.id + " " + r.name + " " + r.number +" "+r.rCode);
        
        s.close();
    }
}