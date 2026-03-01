import java.util.Scanner;

class CharacterAnalyzer {
    public char x;

    public void analyze() {
        if (x >= '0' && x <= '9') {
            System.out.println("IS DIGIT");
        } 
        else {
            System.out.println("ALPHA");
            if (x >= 'A' && x <= 'Z') {
                System.out.println("IS CAPITAL");
            } else {
                System.out.println("IS SMALL");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        CharacterAnalyzer analyzer = new CharacterAnalyzer();

        String input = s.next();
        analyzer.x = input.charAt(0);

        analyzer.analyze();

        s.close();
    }
}