

public class Sum{
    private int num1;
    private int num2;
    private int num3;
    private int sum;

    void setSum(int num1, int num2, int num3){
        if(num1%2==0 && num2%2==0 && num3%2==0 )
            sum=num1+num2+num3;
        else
            System.out.println("3 number must be even");
    }

    int getSum(){
        return sum;
    }

}