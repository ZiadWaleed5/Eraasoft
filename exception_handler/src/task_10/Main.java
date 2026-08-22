package task_10;

import java.io.IOException;

public class Main {

    public static void readFile() throws IOException {
        System.out.println("Reading file...");

        throw new IOException("sorry we can't read file");
    }

    public static void main(String[] args) {

        try {
            readFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
   لتاسك دا بيقولك ازاي تستخدم throws و انت بتعرف ال method و انها بترمي مسوؤلية الاكسبشن للمكان اللي بينادي عليها اللي هو ال main يعني

*/