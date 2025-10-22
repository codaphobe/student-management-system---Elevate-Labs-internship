import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StringBuilder options = new StringBuilder();
        options.append("\n\t1. Add Student.\n");
        options.append("\t2. Show all Students.\n");
        options.append("\t3. Find student by id.\n");
        options.append("\t4. Delete student by id.\n");
        options.append("\t5. Update student marks by id.\n");
        options.append("\t6. Exit!!");

        System.out.println("Welcome to the Student management system\n"
                    +"Choose the options below to perform operations in the student records");
        Scanner input = new Scanner(System.in);

        StudentManagement studentOps = new StudentManagement();

        while(true){
            System.out.print("|--------------------------------------------|");
            System.out.println(options);
            System.out.println("|--------------------------------------------|");
            int option = Integer.parseInt(input.nextLine().trim());
            switch (option){

                case 1:
                    System.out.println("Provide the following details to add student to the record: ");
                    System.out.println("Enter student id: ");
                    String stuId = input.nextLine().trim();
                    try{
                        if (studentOps.checkDupId(stuId)){
                            System.out.println("\n!!A Student with same id found!!");
                            throw new IllegalArgumentException("A Student with id "+stuId+" already exists.");
                        }
                    }catch (IllegalArgumentException e){
                        System.err.println(e.getMessage());
                        break;
                    }
                    System.out.println("Enter student name: ");
                    String stuName = input.nextLine().trim();
                    System.out.println("Enter student total acquired marks:");
                    int stuMarks = Integer.parseInt(input.nextLine().trim());
                    System.out.println("Enter student branch:");
                    String stuBranch = input.nextLine().trim();

                    Student student = new Student(stuName,stuId,stuMarks,stuBranch);
                    studentOps.addStudent(student);
                    System.out.println("|--------------------------------------------|");
                    System.out.print(ConsoleColors.ANSI_GREEN);
                    System.out.println("\nStudent successfully added into the record: \n"+student+ConsoleColors.ANSI_RESET);
                    break;

                case 2:
                    studentOps.displayAll();
                    break;

                case 3:
                    System.out.println("Enter Student id: ");
                    String id = input.nextLine().trim();
                    Student student1 = studentOps.findById(id);
                    if (student1==null){
                        System.out.print(ConsoleColors.ANSI_RED);
                        System.out.println("No student found"+ConsoleColors.ANSI_RESET);
                        break;
                    }
                    System.out.println(student1);
                    break;

                case 4:
                    System.out.println("Enter Student id to be deleted:");
                    String sid = input.nextLine().trim();
                    Student deletedStu = studentOps.deleteById(sid);
                    System.out.print(ConsoleColors.ANSI_GREEN);
                    System.out.println("Successfully deleted student: ");
                    System.out.println(ConsoleColors.ANSI_RED+deletedStu+ConsoleColors.ANSI_RESET);
                    break;

                case 5:
                    if (studentOps.getStudentList().isEmpty()){
                        System.out.print(ConsoleColors.ANSI_RED);
                        System.out.println("No Student records found"+ConsoleColors.ANSI_RESET);
                        break;
                    }
                    System.out.println("Provide the following to update student marks");
                    System.out.print("Enter student id: ");
                    String uid = input.nextLine().trim();
                    System.out.print("Enter student new total marks: ");
                    int newMarks = Integer.parseInt(input.nextLine().trim());
                    Student updatedStu = studentOps.updatedStudentMarks(uid,newMarks);
                    System.out.print(ConsoleColors.ANSI_GREEN);
                    System.out.println("Successfully updated student:\n"+updatedStu+ConsoleColors.ANSI_RESET);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Only choose from the above options");
                    break;
            }
        }
    }
}