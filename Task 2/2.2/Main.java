import java.util.Scanner;

class Main{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your id");
        long id = s.nextLong();
        s.nextLine(); //  enter اللي كاتبيه تحت عشان كدة السطر دا هو اللي بياخد الstring بعد م نكتب الرقم بتخزن ف ال  enter دي يا زوز بنعملها عشان لما بندوس  
        System.out.println("Enter your name");
        String name = s.nextLine();
        System.out.println("Enter your age");
        float age = s.nextFloat();
        System.out.println("Enter your phone number");
        String phoneNumber = s.next();
        System.out.println("Enter your salary");
        float salary = s.nextFloat();

        Teacher t = new Teacher();
        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setPhoneNumber(phoneNumber);
        t.setSalary(salary);

        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getPhoneNumber());
        System.out.println(t.getSalary());

        s.close();
    }
}