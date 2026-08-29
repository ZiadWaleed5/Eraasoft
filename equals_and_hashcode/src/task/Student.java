package task;

public class Student {
    protected String email;
    protected String id;

    public Student(String email, String id){
        this.email = email;
        this.id = id;
    }

    @Override
    public String toString(){
        return "( Email = " + email + ", ID = " + id + " )";
    }
}
