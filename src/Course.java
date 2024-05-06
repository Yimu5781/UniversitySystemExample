import java.util.ArrayList;

public class Course {

    private static final int MAX_CREDIT = 40;
    public static ArrayList<Course> allCourses;
    static {
        allCourses = new ArrayList<>();
    }

    public enum Status {
        compulsory, optional
    }

    //fields
    private String code;
    private String title;
    private int credit;
    private Status status;

    //constructor
    public Course(String code, String title, int credit, Status status) {
        if(validateCode(code)){
            this.code = code;
        }
        this.title = title;
        if(validateCredit(credit)){
            this.credit = credit;
        }
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
        return allCourses;
    }

    public static void removeCourse(Course course){
        allCourses.remove(course);
    }

    //validation
    private boolean validateCode(String code){
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
        return true;
    }
    private boolean validateCredit(int credit){
        if(credit<0){
            throw new IllegalArgumentException("The credit must be positive!");
        }
        if(credit>40){
            throw new IllegalArgumentException("The credit can't be more than "+ MAX_CREDIT+".");
        }
        return true;
    }
}

