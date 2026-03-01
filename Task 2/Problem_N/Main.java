import java.util.Scanner;

class CharConverter {
    public char x;

    public void convertAndPrint() {
        if (x >= 'a' && x <= 'z') {
            char upper = (char) (x - 32);
            System.out.println(upper);
        } 
        else {
            char lower = (char) (x + 32);
            System.out.println(lower);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        CharConverter converter = new CharConverter();

        String input = s.next();
        converter.x = input.charAt(0);

        converter.convertAndPrint();

        s.close();
    }
}