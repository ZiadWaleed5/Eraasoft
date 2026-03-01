

public class Player extends BaseEntity {
    private int number;

    void setNumber(int number){
        if( number > 0 && number <=99)
            this.number = number;
        else
            System.out.println("Number length must be <= 2 (0 to 99 only)");
    }

    int getNumber(){
        return number;
    }

}
