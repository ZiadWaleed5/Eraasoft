package task_4;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter num of elements");
        int size = s.nextInt();

        int []a = new int[size];

        System.out.println("Enter the value, and its index");
        int v = s.nextInt();
        int p = s.nextInt();

        try{
            a[p] = v;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index error");
        }
    }
}

/*                                     انا هنا عايز اشوف ال error بتاع الاندكس

        ف بعمل ايه عملت ال array بتاعتي و بخلي ال user يحط ال value اللي عايزها ف ال index اللي عايزه

          و لو الاندكس اكبر م ال size اللي ال user برضه حاطه بيعمل ArrayIndexOutOfBoundsException

*/
