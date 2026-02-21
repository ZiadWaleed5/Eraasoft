import java.util.Scanner;

class Problem_B{

    static class Display {
        void display(int a, long b, char c, float d, double e){
            System.out.println(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e);
        }

    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        long b = s.nextLong();
        char c = s.next().charAt(0);
        float d = s.nextFloat();
        double e = s.nextDouble();

        Display dis = new Display();
        dis.display(a,b,c,d,e); 
        s.close();
    }


}