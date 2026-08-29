package task;
import java.util.Objects;

public class Product {
    private String code;
    private double price;

    public Product(String code, double price){
        this.code = code;
        this.price = price;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(code);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Product productObj = (Product) obj;

        return Objects.equals(this.code, productObj.code);
    }

    @Override
    public String toString(){
        return "( Code = "+ this.code + ", price = " + this.price +")";
    }
}
