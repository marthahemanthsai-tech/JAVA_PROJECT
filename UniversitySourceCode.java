import java.util.Scanner;
import java.util.ArrayList;

public class UniversitySourceCode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Final Keyword: Constants that cannot be modified
        final double MIN_ATTENDANCE = 75.0;
        final double PASSING_GRADE = 60.0;

        // Student Info Input
        System.out.println("=================================");
        System.out.println("     STUDENT REGISTRATION        ");
        System.out.println("=================================");
        
        System.out.print("Enter Student Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Department (e.g., Computer Science): ");
        String department = scanner.nextLine().trim();

        System.out.print("Enter University ID: ");
        String uniId = scanner.nextLine().trim();

        System.out.print("Enter total number of subjects: ");
        int totalSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline character

        // Collection Framework: Replaced double[] array with ArrayList
        ArrayList<Double> grades = new ArrayList<>();
        int[] classesAttended = new int[totalSubjects];
        int[] totalClasses = new int[totalSubjects];

        // Input loop to collect subject details
        for (int i = 0; i < totalSubjects; i++) {
            System.out.println("\n--- Subject " + (i + 1) + " ---");
            
            System.out.print("Enter grade percentage (0 - 100): ");
            grades.add(scanner.nextDouble());

            System.out.print("Enter classes attended: ");
            classesAttended[i] = scanner.nextInt();

            System.out.print("Enter total classes held: ");
            totalClasses[i] = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline character
        }

        // Processing totals
        double totalGradePoints = 0;
        int sumAttended = 0;
        int sumTotalClasses = 0;

        for (int i = 0; i < totalSubjects; i++) {
            totalGradePoints += grades.gets(i);
            sumAttended += classesAttended[i];
            sumTotalClasses += totalClasses[i];
        }

        // Calculations
        double averageGrade = totalGradePoints / totalSubjects;
        double attendancePercentage = ((double) sumAttended / sumTotalClasses) * 100;

        // Grade scale categorization
        int gradeCategory;
        if (averageGrade >= 90) {
            gradeCategory = 4;
        } else if (averageGrade >= 80) {
            gradeCategory = 3;
        } else if (averageGrade >= 70) {
            gradeCategory = 2;
        } else if (averageGrade >= 60) {
            gradeCategory = 1;
        } else {
            gradeCategory = 0;
        }

        // Switch Statement for Letter Grade Assignment
        String letterGrade;
        switch (gradeCategory) {
            case 4:
                letterGrade = "A (Excellent)";
                break;
            case 3:
                letterGrade = "B (Good)";
                break;
            case 2:
                letterGrade = "C (Satisfactory)";
                break;
            case 1:
                letterGrade = "D (Pass)";
                break;
            default:
                letterGrade = "F (Fail)";
                break;
        }

        // Relational and Logical Operators using final variables
        boolean meetsAttendance = attendancePercentage >= MIN_ATTENDANCE;
        boolean passesGrades = averageGrade >= PASSING_GRADE;
        boolean isEligible = meetsAttendance && passesGrades;

        // Output Results
        System.out.println("\n=================================");
        System.out.println("        ACADEMIC REPORT          ");
        System.out.println("=================================");
        System.out.println("Student Name : " + name);
        System.out.println("Department   : " + department);
        System.out.println("University ID: " + uniId);
        System.out.println("---------------------------------");
        System.out.printf("Average Grade: %.2f%%\n", averageGrade);
        System.out.println("Letter Grade : " + letterGrade);
        System.out.printf("Attendance   : %.2f%% (%d/%d classes)\n", 
                          attendancePercentage, sumAttended, sumTotalClasses);
        System.out.println("---------------------------------");
        
        // StringBuffer Class: Building and manipulating status text
        StringBuffer statusBuffer = new StringBuffer("STATUS: ");
        if (isEligible) {
            statusBuffer.append("Eligible for Final Exams");
        } else {
            statusBuffer.append("Ineligible (Check requirements)");
        }
        
        System.out.println(statusBuffer.toString());

        scanner.close();
    }
}
