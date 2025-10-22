public class Student {

    private String stuName;
    private String stuId;
    private int stuTotalMarks;
    private String stuBranch;
    private static int maxMarks = 100;

    public Student(String stuName, String stuId, int stuTotalMarks, String stuBranch) {
        this.stuName = stuName;
        this.stuId = stuId;
        this.stuTotalMarks = stuTotalMarks;
        this.stuBranch = stuBranch;
    }

    public String getStuBranch() {
        return stuBranch;
    }

    public void setStuBranch(String stuBranch) {
        this.stuBranch = stuBranch;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public int getStuTotalMarks() {
        return stuTotalMarks;
    }

    public void setStuTotalMarks(int stuTotalMarks) {
        this.stuTotalMarks = stuTotalMarks;
    }

    @Override
    public String toString() {
        return "\tStudent{" +
                "\n\tStudent name='" + stuName + "', \n" +
                "\tStudent id='" + stuId + "', \n" +
                "\tStudent Total Marks=" + stuTotalMarks +"', \n"+
                "\tStudent Branch='" + stuBranch + "', \n" +
                '}';
    }
}
