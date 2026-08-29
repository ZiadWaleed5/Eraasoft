package task;

public class Person {
    protected String name;
    protected int id;

    public Person(String name, int id){
        this.name = name;
        this.id= id;
    }

    @Override
    public String toString() {
        return ("(name: "+name +" id: "+id+" ) ");
    }
}
