import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        Add a = new Add();
        a.addStudent();
        a.showStudent();
        Show sh = new Show();
        sh.addStudent();
        sh.showStudent();
    }
}