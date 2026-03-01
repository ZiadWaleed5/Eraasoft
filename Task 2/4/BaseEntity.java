

public class BaseEntity {
    private int id;
    private String name;

    void setId(int id){
        if(id > 0)
            this.id = id;
        else
            System.out.println("ID must be more than 0");
    }

    int getId(){
        return id;
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }
}
