import java.util.Scanner;

public class PreludeSwitch {
    public static void main(String[] args) {
        String grade;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input your grade: ");
        grade = scanner.next();

        switch (grade) {
            case "A":
                System.out.println("Perfect");
                break;
            case "B":
                System.out.println("Great");
                break;
            case "C":
                System.out.println("Cool");
                break;
            case "D":
                System.out.println("Bad");
                break;
            case "F":
                System.out.println("Fail");
                break;
            default:
                System.out.println("Invalid grade");
        }
        System.out.println("Your grade is: " + grade);
    }
}
