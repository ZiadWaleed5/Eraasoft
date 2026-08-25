


public class Person {
    private String name;
    private int id;

    public Person(String name, int id){
        this.name = name;
        this.id= id;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Person pObj = (Person) obj;

        return this.id == pObj.id;

    }
}
