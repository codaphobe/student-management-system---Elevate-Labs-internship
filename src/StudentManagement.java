import java.util.ArrayList;
import java.util.List;

public class StudentManagement {


    private final List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public boolean checkDupId(String id){
        if (studentList.isEmpty()){
            return false;
        }
        return studentList.stream()
                .anyMatch(stu -> stu.getStuId().equalsIgnoreCase(id));
    }

    public void addStudent(Student stu){
        studentList.add(stu);
    }

    public void displayAll(){
        if(studentList.isEmpty()){
            System.out.println("No Student record found");
            return;
        }
        studentList.forEach(System.out::println);
    }

    public Student findById(String id){
        return studentList.stream().filter(stu -> stu.getStuId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public Student deleteById(String id){
        Student del = studentList.stream().filter(stu -> stu.getStuId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if (del==null){
            System.out.println("No Student found by the id: "+id);
            return del;
        }
        boolean removed = studentList.remove(del);
        return del;
    }

    public Student updatedStudentMarks(String id, int newMarks){
        Student stu = studentList.stream()
                        .filter(s -> s.getStuId().equalsIgnoreCase(id))
                        .findFirst()
                        .map(s -> {
                            s.setStuTotalMarks(newMarks);
                            return s;
                        })
                        .orElseGet(() -> {
                            System.out.println("Student not found");
                            return null;
                        });
        return stu;
    }
}
