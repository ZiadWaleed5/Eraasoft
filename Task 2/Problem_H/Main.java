import java.util.Scanner;

class Rounding {
    public double a;
    public double b;

    public void div() {
        double result = a / b;

        int floorResult = (int) Math.floor(result);
        
        int ceilResult = (int) Math.ceil(result);
        
        int roundResult = (int) Math.round(result);

        System.out.println("floor " + (int)a + " / " + (int)b + " = " + floorResult);
        System.out.println("ceil " + (int)a + " / " + (int)b + " = " + ceilResult);
        System.out.println("round " + (int)a + " / " + (int)b + " = " + roundResult);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Rounding r = new Rounding();

        r.a = s.nextDouble();
        r.b = s.nextDouble();
        

        r.div();

        s.close();
    }
}