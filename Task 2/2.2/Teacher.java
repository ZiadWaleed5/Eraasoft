

public class Teacher {
    private long id;
    private String name; 
    private float age; 
    private String phoneNumber; 
    private float salary;  

    void setId(long id){
        if(id > 0)
            this.id=id;
        else
            System.out.println("Please id should be more than 0");
    }

    long getId(){
        return id;
    }

    void setName(String name){
        if((name.length() >= 3) && name.equals(name.toLowerCase())){ 
            
            // small خد بالك يا زوز في حاجة برضو بتتاكد لو كل الحروف 
            // name.matches("[a-z]+")  for small didits
            // name.matches("[A-Z]+")  for capital digits

            this.name = name;
        }
        else
            System.out.println("Please Name should be more than or equal 3, and all digits should be small");
    }

    String getName(){
        return name;
    }

    void setAge(float age){
        if(age >= 25 && age<=60)
            this.age = age;
        else
            System.out.println("Please Age should be between 25 and 60");
    }

    float getAge(){
        return age;
    }

    void setPhoneNumber(String phoneNumber){
        if((phoneNumber.length()==13) && (phoneNumber.startsWith("+20")))
            this.phoneNumber = phoneNumber;
        else
            System.out.println("The phone number format (+20XXXXXXXXXXX)");
    }

    String getPhoneNumber(){
        return phoneNumber;
    }

    void setSalary(float salary){
        if(salary >= 3000)
            this.salary = salary;
        else
            System.out.println("Salary should be more than or equal 3000");
    }

    float getSalary(){
        return salary;
    }
}
