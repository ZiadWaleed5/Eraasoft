package task;

import java.util.Objects;

public class PersonByIdAndName extends Person{

    public PersonByIdAndName(String name, int id){
        super(name, id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj){

        if( this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        PersonByIdAndName personByIdAndNameObj = (PersonByIdAndName) obj;

        return this.id == personByIdAndNameObj.id && Objects.equals(personByIdAndNameObj.name, this.name);
    }
}
