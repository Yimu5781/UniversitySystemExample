import java.util.ArrayList;
import java.util.Objects;

public class Course {

    private static final int MAX_CREDIT = 40;

    //course database
    protected static ArrayList<Course> allCourses = new ArrayList<>();

    public enum Status {
        compulsory, optional
    }

    //fields
    private final String code;
    private String title;
    private int credit;
    private Status status;

    //constructor
    public Course(String code, String title, int credit, Status status) {
        validateCode(code);
        this.code = code;
        this.title = title;
        validateCredit(credit);
        this.credit = credit;
        this.status = status;
        allCourses.add(this);
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                ", status=" + status +
                '}';
    }

    //getter
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public Status getStatus() {
        return status;
    }

    public static ArrayList<Course> getAllCourses() {
        return new ArrayList<>(allCourses);
    }

    public boolean removeCourse(){
        return allCourses.remove(this);
    }

    //validation
    private static void validateCode(String code){
        if (code.length() != 6) {
            throw new IllegalArgumentException("The code must be six characters long.");
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isUpperCase(code.charAt(i))) {
                throw new IllegalArgumentException("The first three characters of the code must be uppercase letters.");
            }
        }
        for (int a = 3; a < 6; a++) {
            if (!Character.isDigit(code.charAt(a))) {
                throw new IllegalArgumentException("The last three characters of the code must be digits.");
            }
        }
    }
    private void validateCredit(int credit){
        if(credit<0){
            throw new IllegalArgumentException("The credit must be positive!");
        }
        if(credit>40){
            throw new IllegalArgumentException("The credit can't be more than "+ MAX_CREDIT+".");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credit == course.credit && Objects.equals(code, course.code) && Objects.equals(title, course.title) && status == course.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title, credit, status);
    }
}

