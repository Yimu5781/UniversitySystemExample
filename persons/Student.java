package persons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import courses.Course;
import courses.Course.Status;
import jdk.jfr.Category;

import javax.swing.*;

public class Student extends Person  {
    
    //constants
    public static final int MAX_GRADE = 100;
    public static final int MIN_YEAR = 1;

    //fields
    private Map<Course, Integer> grades;
    private int yearOfStudy;
    private final Category category;

    public enum Category{

        UG(40,4,60),
        PG(50,2,40);

        public final int GRADE_TO_PASS;
        public final int LENGTH_OF_STUDY;
        public final int REQUIRED_CREDITS;


        Category(int GRADE_TO_PASS, int LENGTH_OF_STUDY, int REQUIRED_CREDITS){
            this.GRADE_TO_PASS=GRADE_TO_PASS;
            this.LENGTH_OF_STUDY=LENGTH_OF_STUDY;
            this.REQUIRED_CREDITS=REQUIRED_CREDITS;
        }

    }
    
    //constructor
    public Student(String name, Gender gender,
            Category category, Map<Course, Integer> grades, int yearOfStudy) {
        // initialises fields from Person
        super(name, gender);
        // initialise Student-specific fields
        this.category = category;
        checkGrades(grades);
        this.grades = grades;
        checkYear(category, yearOfStudy);
        this.yearOfStudy = yearOfStudy;
    }

    public Student(String name, Gender gender,
                   Category category, Map<Course, Integer> grades) {
        this(name, gender, category, grades, MIN_YEAR);
    }

    
    private static void checkGrades(Map<Course, Integer> grades) {
        for (Course c: grades.keySet()) {
            if (!Course.getAllCourses().contains(c)){
                throw new IllegalArgumentException("course " + c.code() + " not offered by the University");
            }
        }
        for (int grade : grades.values()){
            checkGrade(grade);
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
    
    private static void checkYear(Category category, int yearOfStudy) {
        if (yearOfStudy < MIN_YEAR || yearOfStudy > category.LENGTH_OF_STUDY) {
            throw new IllegalArgumentException("year of study should be between"
                    + MIN_YEAR + " and " + category.LENGTH_OF_STUDY);
        }
    }

    
    //getters
    public Map<Course, Integer> getGrades(){
        return new HashMap<>(grades);
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }
    public int calculateAverageGrade(){
        int gradeSum=0;
        int totalWeight=0;
        for(Map.Entry<Course, Integer> e: grades.entrySet()){
            Course course=e.getKey();
            int grade=e.getValue();
            gradeSum += course.weight()*grade;
            totalWeight += course.weight();
        }
        return (int) Math.round((double) gradeSum+totalWeight);
    }

    //to display Student data
    @Override
    public String toString() {
        return "Student{" +"name=" + getName() + ", gender=" + getGender()
                + ", courses=" + grades
                + ", yearOfStudy=" + yearOfStudy + '}';
    }
    
    //useful methods
    @Override
    public void endOfYear() {
        int acquiredCredits = 0;
        for(Map.Entry<Course, Integer> e : grades.entrySet()){
            Course course= e.getKey();
            int grade = e.getValue();
            acquiredCredits += (grade >= category.GRADE_TO_PASS) ? course.weight() : 0;
        }
        if(acquiredCredits < category.REQUIRED_CREDITS){
            System.out.println("Sorry! You have to re-take the year.");
        }
        else if (yearOfStudy == category.LENGTH_OF_STUDY) {
            System.out.println("Congratulations! You have graduated!");
        }
        else {
            System.out.println("Yay! You're moving on to the next year.");
            grades.clear(); //remove all sets for new AY
            yearOfStudy++;
        }
    }
    
    public void changeCourse(Course oldCourse, Course newCourse, int newGrade) {
        if (oldCourse.status() != Status.OPTIONAL || newCourse.status() != Status.OPTIONAL) {
            throw new IllegalArgumentException("can only substitute optional courses");
        }
        if (!grades.containsKey(oldCourse)) {
            throw new IllegalArgumentException("course not found in list of courses");
        }
        grades.remove(oldCourse);
        grades.put(newCourse, newGrade);
    }

    public void assignGrade(int grade, Course course) {
        if (!grades.containsKey(course)) {
            throw new IllegalArgumentException("course not found in list of courses");
        }
        grades.replace(course, grade);
    }
    
}
