import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    private static final int MAX_GRADE = 100;
    private static final int GRADE_TO_PASS = 40;
    private static final int LENGTH_OF_STUDY = 4;

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
    public void endOfYear() {
        if (averageGrade < GRADE_TO_PASS) {
            System.out.println("Sorry! You have to re-take the year.");
        }
        else if (yearOfStudy == LENGTH_OF_STUDY) {
            System.out.println("Congratulations! You have graduated!");
        }
        else {
            System.out.println("Yay! You're moving on to the next year.");
            yearOfStudy++;
        }
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

    private static void checkCourses(ArrayList<Course> courses) {
        for (Course c : courses) {
            if (!Course.getAllCourses().contains(c)) {
                throw new IllegalArgumentException("course " + c.getCode() + " not offered by the University");
            }
        }
    }

    public void changeCourse(Course oldCourse, Course newCourse) {
        if (oldCourse.getStatus() != Course.Status.compulsory || newCourse.getStatus() != Course.Status.optional) {
            throw new IllegalArgumentException("can only substitute optional courses");
        }
        int index = courses.indexOf(oldCourse);
        if (index == -1) {
            throw new IllegalArgumentException("course not found in list of courses");
        }
        courses.set(index, newCourse);
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
