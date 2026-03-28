import java.util.Scanner;


class Main {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        int n=s.nextInt();
        int even = 0, odd = 0, pos = 0, neg = 0;
        for(int i=0;i<n;i++){

            int x = s.nextInt();

            if(x%2==0)
                even++;
            else if(x%2!=0)
                odd++;
            
            if(x>0)
                pos++;
            else if(x<0)
                neg++;
        }

        System.out.println("Even: "+even);
        System.out.println("Odd: "+odd);
        System.out.println("Positive: "+pos);
        System.out.println("Negative: "+neg);
        s.close();
    }
}
