import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    private static final int MAX_GRADE = 100;
    private static final int GRADE_TO_PASS = 40;

    //fields
    private ArrayList<Course> courses;
    private int averageGrade;
    private int yearOfStudy;

    //constructor
    public Student(String name, Gender gender, ArrayList<Course> courses, int averageGrade, int yearOfStudy) {
        super(name, gender);
        if(validateCourse(courses)){
            this.courses = courses;
        }
        if(validateAverageGrade(averageGrade)) {
            this.averageGrade = averageGrade;
        }
        if(validateYear(yearOfStudy)){
            this.yearOfStudy = yearOfStudy;
        }
    }

    //getter
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", courses=" + getCourseCodes(courses) +
                ", averageGrade=" + averageGrade +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }

    //setter
    public Student endOfYear(Student student){
        if (student.yearOfStudy == 4 && student.averageGrade>=40){
            System.out.println("Congratulation to your graduation!");
            return student;
        }
        if(student.averageGrade>=40){
            student.yearOfStudy++;
        }
        return student;
    }

    public void calculateAverageGrade(int[] grades){
        int sum = 0;
        for(int grade:grades){
            sum=sum+grade;
        }
        int average=0;
        average=sum/grades.length;
        this.averageGrade=average;
    }

    public static ArrayList<String> getCourseCodes(ArrayList<Course> courses){
        ArrayList<String> courseID=new ArrayList<>();
        for (Course course : courses) {
            courseID.add(course.getCode());
        }
        return courseID;
    }


    //validate
    private boolean validateAverageGrade(int averageGrade){
        if (averageGrade<0){
            throw new IllegalArgumentException("Grade can't be negative.");
        } else if (averageGrade>MAX_GRADE) {
            throw new IllegalArgumentException("Grade can't be more than "+ MAX_GRADE+".");
        }
        return true;
    }
    private boolean validateYear(int yearOfStudy){
        if(yearOfStudy <1 || yearOfStudy >4){
            throw new IllegalArgumentException("Year of study should between 1 to 4.");
        }else {
            return true;
        }
    }
    private boolean validateCourse(ArrayList<Course> courses){
        for(Course course:courses){
            if (!Course.allCourses.contains(course)) {
                return false;
            }
        }
        return true;
    }
}
