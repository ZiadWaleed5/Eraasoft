package task_3;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){

        String n =  null;
        try{
            n = n.toUpperCase();
            System.out.println(n);
        }
        catch(NullPointerException e){
            System.out.println("String should not be null");
        }
    }
}

/*

                         طبعا مينفعش نعمل اي operation ع null عشان كدا هيديك error

                               NulPointerException و عشان اتجنب ال error عملت اكسبشن

     واحد هيقولي دلوقتي ايه الهبل دا م انت شايف انه null اهو صح معاك حق بس شغالين ف داتا بيز

    و باخد الداتا مش هعرف لو فية حاجة null ولا لا فهمت يعم الفزلوك
*/