package task_9;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void number() throws InputMismatchException{
        System.out.println("enter the number");
        int num = s.nextInt();
    }

    public static void main(String[]args){
        try{
            number();
        }
        catch(InputMismatchException e){
            System.out.println("you should enter just an integer");
        }
    }

}

/*
                   هنا انابقول لل methods خلي بالك ممكن تلاقي اكسبشن جوة عن طريق اني بكتب throws جمب اسم ال method

                واحد هنا هيجي يقولي و ايه لازمتها بقي منا كدا كدا عارف ان في جوة اكسبشن ممكن يحصل

             مش مهم انت عارف ولا لا المهم التيم اللي معاك يبقي عارف و ان دي بتنظم الكود عشان لو نسيت مثلا ان في اكسبشن

*/