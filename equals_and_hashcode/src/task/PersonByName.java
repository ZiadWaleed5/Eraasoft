package task;

import java.util.Objects;

public class PersonByName extends Person{

    public PersonByName(String name, int id){
        super(name, id);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj){

        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        PersonByName personByNameObj = (PersonByName) obj;

        return Objects.equals(personByNameObj.name, this.name);
    }
}
