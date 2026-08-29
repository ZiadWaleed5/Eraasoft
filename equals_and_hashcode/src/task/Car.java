package task;
import java.util.Objects;


public class Car {
    private String plateNumber;
    private String color;

    public Car(String plateNumber, String color){
        this.plateNumber = plateNumber;
        this.color = color;
    }

    @Override
    public String toString(){
        return "( Plate number: " + plateNumber + ", Color: " + color + " ) ";
    }

    @Override
    public int hashCode(){
        return Objects.hash(plateNumber, color);
    }

    @Override
    public boolean equals(Object obj){

        if (this == obj)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Car carObj = (Car) obj;

        return Objects.equals(this.plateNumber, carObj.plateNumber) && Objects.equals(this.color, carObj.color) ;
    }
}
