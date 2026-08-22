package task_7;


import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your age");
        int age = s.nextInt();

        try{
            AgeChecker.ageChecker(age);
        }
        catch(InvalidAgeException e){
            System.out.println(e.getMessage());
        }

    }
}

/*

    هنا بعمل custom exception لان الاكسبشن دا مش موجود ف الجافا و بعمل throw ف الحتة اللي عايزه يظهر فيها ف الكود

*/
