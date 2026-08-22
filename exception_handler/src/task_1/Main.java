package task_1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("Enter num 1");
            int num1 = s.nextInt();
            System.out.println("Enter num 2");
            int num2 = s.nextInt();

            double result = num1 / num2;
            System.out.println(result);

        }catch(ArithmeticException e){
            System.out.println("you can't divide 0");

        }catch(InputMismatchException e){
            System.out.println("enter an integer number pls");

        }

    }
}
/*
                       فهمت م التاسك دا ازاي اتعامل مع try و catch

     ال ArithmeticException بيحصل لما العملية الحسابية تكون غير منطقية زي اني احاول اقسم ع ال 0

 ع فكرة انا لو كنت عامل casting double الاكسبشن مكنش هيشتغل و كان هيديني infinity

     ال InputMismatchException بيحصل لما ادخل input غلط غير اللي محدده زي اني ادخل string و انا عايز int


*/