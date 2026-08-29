package task;
import java.util.Objects;

public class StudentByEmail extends Student{

    public StudentByEmail(String email, String id){
        super(email, id);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(email);
    }

    @Override
    public boolean equals(Object obj){

        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        StudentByEmail studentByEmailObj = (StudentByEmail) obj;

        return Objects.equals(this.email, studentByEmailObj.email);
    }
}
