public class Info {

    private int number;
    private String name;

    void setNumber(int number){
        if(number > 0){
            this.number = number;
            return;
        }
        System.out.println("Please number should be more than 0");
    }

    int getNumber(){
        return number;
    }

    void setName(String name){
        if(name.length() > 5){
            this.name = name;
            return;
        }
        System.out.println("Please name should be more than 5");

    }   

    String getName(){
        return name;
    }
}
