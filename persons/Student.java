package persons;

import java.time.LocalDate;
import java.util.ArrayList;
import university.Course;
import university.Course.Status;

public class Student extends Person {
    
    //constants
    public static final int MAX_GRADE = 100;
    public static final int GRADE_TO_PASS = 40;
    public static final int LENGTH_OF_STUDY = 4;
    
    //fields
    private ArrayList<Course> courses;
    private int averageGrade;
    private int yearOfStudy;
    
    //constructor
    public Student(LocalDate enrolmentDate, String name, Gender gender, 
            ArrayList<Course> courses, int averageGrade, int yearOfStudy) {
        // initialises fields from Person
        super(enrolmentDate, name, gender);
        // initialise Student-specific fields
        checkCourses(courses);
        this.courses = courses;
        checkGrade(averageGrade);
        this.averageGrade = averageGrade;
        checkYear(yearOfStudy);
        this.yearOfStudy = yearOfStudy;
    }
    
    public Student(LocalDate enrolmentDate, String name, Gender gender, ArrayList<Course> courses, int averageGrade) {
        this(enrolmentDate, name, gender, courses, averageGrade, 1);
    }

    private static void checkCourses(ArrayList<Course> courses) {
        for (Course c : courses) {
            if (!Course.getAllCourses().contains(c)) {
                throw new IllegalArgumentException("course " + c.code() + " not offered by the University");
            }
        }
    }
    
    private static void checkGrade(int grade) {
        if (grade < 0) {
            throw new IllegalArgumentException("grade can't be negative");
        }
        if (grade > MAX_GRADE) {
            throw new IllegalArgumentException("grade can't be greater than " + MAX_GRADE);
        }
    }
    
    private static void checkYear(int yearOfStudy) {
        int minYear = 1;
        if (yearOfStudy < minYear || yearOfStudy > LENGTH_OF_STUDY) {
            throw new IllegalArgumentException("year of study should be between"
                    + minYear + " and " + LENGTH_OF_STUDY);
        }
    }
    
    //getters    
    public ArrayList<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public int getAverageGrade() {
        return averageGrade;
    }
    
    public int getYearOfStudy() {
        return yearOfStudy;
    }
    
    public ArrayList<String> getCourseCodes() {
        ArrayList<String> codes = new ArrayList<>();
        for (Course c : courses) {
            codes.add(c.code());
        }
        return codes;
    }

    //to display Student data
    @Override
    public String toString() {
        return "Student{" + "id=" + getId() + ", name=" + getName() + ", gender=" + getGender() 
                + ", courses=" + getCourseCodes() + ", averageGrade=" + averageGrade 
                + ", yearOfStudy=" + yearOfStudy + '}';
    }
    
    //useful methods
    public void calculateAverageGrade(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        int newAverageGrade = Math.round((float)sum/grades.length);
        averageGrade = newAverageGrade;
    }
    
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
    
    public void changeCourse(Course oldCourse, Course newCourse) {
        if (oldCourse.status() != Status.OPTIONAL || newCourse.status() != Status.OPTIONAL) {
            throw new IllegalArgumentException("can only substitute optional courses");
        }
        int index = courses.indexOf(oldCourse);
        if (index == -1) {
            throw new IllegalArgumentException("course not found in list of courses");
        }
        courses.set(index, newCourse);
    }
    
}
