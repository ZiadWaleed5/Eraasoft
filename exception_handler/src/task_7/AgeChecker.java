package task_7;


public class AgeChecker {
    public static void ageChecker(int age) throws InvalidAgeException{
        if (age < 18)
            throw new InvalidAgeException("Your age is not suitable ");
        else
            System.out.println(age + " is suitable age");
    }
}
