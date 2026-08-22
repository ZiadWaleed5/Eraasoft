package task_6;


public class Main {
    public static void main(String[]args){
        String s1 = null;
        String s2 = "";

        try{
            int len1 = s1.length();
            int len2 = s2.length();
            int result = 10/len2;
        }
        catch (NullPointerException e){
            System.out.println("String should not be null");
        }
        catch (ArithmeticException e){
            System.out.println("we cannot devide by zerooo");
        }
    }
}

/*
               بجرب هنا كذااكسبشن مع بعض ف نفس الوقت بحيث اكون عامل حساب كل حاجة ممكن تكون غلط ف الكود

                               التاسك عايز استعمل multiple catch و طبعا مش كل الاكسبشن هتطبع رسالتها

                               اول اكسبشن ال jvm هيقابله هو اللي هيطبع و بس
*/