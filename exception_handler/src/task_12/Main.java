package task_12;


public class Main {
    public static void main(String[]args){

        try{
            try{
                int i = 10/0;
            } catch(NullPointerException e){
                System.out.println(e.getMessage());
            }
        } catch(ArithmeticException e){
            System.out.println("division on zerooo is not allowed");
        }
    }
}


// هنا بيقولك لو عامل nested try and catch ف اول try هيقابلك و يبقي في مشكلة
// هيخرج علطول م ال try و يقعد يدور ع سبب الاكسبشن ف ال catch من اول اللي جوا لحد اللي برا
// و خد بالك لو اول try اتنفذت و دخل ف التانية اللي هي ال outer و طلع فيها مشكلة
// ف هيدور ف ال outer catch مش اللي جوا ليه لان ال inner try خلاص خلصت تمام ف محتجناش نشوف ال catch بتاعتها