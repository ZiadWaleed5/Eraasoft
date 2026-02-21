import java.util.Scanner;

public class Problem_E {
    
    static class Area{
        double area(double r){
            double power = Math.pow(r,2);
            return (3.141592653*(power));
        }
    }
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        double r = s.nextDouble();
        Area a = new Area();
        System.out.printf("%.9f",a.area(r));

        s.close();
    }
}
