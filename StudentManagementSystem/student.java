import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;
    private double marks;

    public Student(String name, int rollNumber, String grade, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public double getMarks() {
        return marks;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade( String grade) {
        this.grade = grade;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNumber +
                ",Name: " + name +
                ", Grade: " + grade +
                ", Marks: "  + marks;
    }
}