package task;
import java.util.Objects;

public class StudentById extends Student{

    public StudentById(String email, String id){
        super(email, id);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj){

        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        StudentById studentByIdObj = (StudentById) obj;

        return Objects.equals(this.id, studentByIdObj.id);
    }
}
