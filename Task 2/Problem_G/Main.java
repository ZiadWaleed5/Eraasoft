import java.util.Scanner;

class Sum {
    public long n;

     long sum() {
        // القانون دا بدل م نعمل for loop و عشان ال Time complexity يبقي قليل O(1)
        return (n * (n + 1)) / 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Sum s1 = new Sum();

            s1.n = s.nextLong();
        
        System.out.println(s1.sum());

        s.close();
    }
}