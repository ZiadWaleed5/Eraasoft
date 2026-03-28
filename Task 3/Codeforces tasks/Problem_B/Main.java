import java.util.Scanner;


class Even{
    void eLoop (int n){
        if(n<2)
            System.out.println(-1);
        for(int i=1;i<=n;i++){
            if(i%2==0)
                System.out.println(i);
        }
    }
}


class Main{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        Even e = new Even();
        e.eLoop(s.nextInt());
        s.close();
    }
}