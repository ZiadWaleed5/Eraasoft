import java.util.Scanner;

class Sum {
    public long n;
    public long m;

     long sum() {
        long lastN = n % 10;
        long lastM = m % 10;
        return lastN + lastM;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Sum d = new Sum();
        
         d.n = s.nextLong();

        d.m = s.nextLong();
        
        
        System.out.println(d.sum());
        
        s.close();
    }
}