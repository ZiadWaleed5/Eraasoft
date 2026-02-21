import java.util.Scanner;

public class InfoApp {
    static class Info{
        private String name;
        private int id;
        private int age;
    
    public void s_name(String Name){
        name = Name;
     }
    public String g_name(){
        return name;
     }
    public void s_id(int ID){
        id = ID;
        }
    public int g_id(){
        return id;
        }
    public void s_age(int Age){
        age = Age;
        }
    public int g_age(){
        return age;
        }
    }    

    public static void main(String[]args){
        Scanner s = new Scanner(System.in);

        String Name = s.nextLine();
        int ID = s.nextInt();
        int Age = s.nextInt();

        Info student = new Info();

        student.s_name(Name);
        student.s_id(ID);
        student.s_age(Age);
        
        System.out.println(student.g_name());
        System.out.println(student.g_id());
        System.out.println(student.g_age());

        s.close();
    }
}
