import java.util.Scanner;

class Problem_D{

static class Difference{
    long dif (long a,long b,long c,long d){
        return (a*b)-(c*d);
    }
}

public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    
    long a = s.nextLong();
    long b = s.nextLong();
    long c = s.nextLong();
    long d = s.nextLong();

    Difference diff = new Difference();
    System.out.println(diff.dif(a,b,c,d));
    
    s.close();
    } 
}

