package task_5;

import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("Test.txt");
            System.out.println("File is found successfully");

        } catch (FileNotFoundException e) {
            System.out.println("sorry file is not found");
        }

    }
}

/*
                     هنا بشوف اي فايل عايز افتحه ولو مش موجود هيديني error

                 عشان كدا استعملت FileNotFoundException عشان ميخرجش م ال app و يكمل شغله لو مش موجود
*/