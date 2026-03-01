import java.util.Scanner;

class NumberFinder {
    public int a, b, c;

    public int getMin() {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    public int getMax() {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        NumberFinder finder = new NumberFinder();
        
         finder.a = s.nextInt();
         finder.b = s.nextInt();
         finder.c = s.nextInt();
        
        System.out.println(finder.getMin() + " " + finder.getMax());
        
        s.close();
    }
}