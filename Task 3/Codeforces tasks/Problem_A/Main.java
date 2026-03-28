import java.util.Scanner;


class N{

    void loop(int n){ 

    for(int i=1;i<=n;i++)
        System.out.println(i);
    }
}

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        N z = new N();
        z.loop(s.nextInt());
        s.close();
    }    
}
