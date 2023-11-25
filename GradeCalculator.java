import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = sc.nextInt();

        System.out.println("Enter marks obtained in each subject (out of 100):");

        int totalMarks = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");
            int marks = sc.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Marks should be between 0 and 100. Please re-enter.");
                i--; // Decrement i to repeat the input for this subject
                continue;
            }
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;

        String grade;

        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
