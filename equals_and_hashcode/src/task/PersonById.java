package task;
import java.util.Objects;

public class PersonById extends Person {

    public PersonById(String name, int id){
        super(name, id);
    }


    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        PersonById pObj = (PersonById) obj;

        return this.id == pObj.id;

    }
}
