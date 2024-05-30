package courses;

import java.util.ArrayList;

public record Course(String code, String title, Status status, int weight) {
    
    public enum Status { COMPULSORY, OPTIONAL }
    
    //course database
    private static ArrayList<Course> allCourses = new ArrayList<>();
    
    //constructor
    public Course {
        checkCode(code);
        allCourses.add(this);
    }
    
    private static void checkCode(String code) {
        if (code.length() != 6) {
            invalidCode();
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isUpperCase(code.charAt(i))) {
                invalidCode();
            }
        }
        for (int i = 3; i < 6; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                invalidCode();
            }
        }
    }
    
    private static void invalidCode() {
        throw new IllegalArgumentException("invalid course code");
    }

    public static ArrayList<Course> getAllCourses() {
        return new ArrayList<>(allCourses);
    }
    
    public boolean remove() {
        return allCourses.remove(this);
    }
    
    public Course changeStatus() {
        Status newStatus = (status == Status.COMPULSORY) ? Status.OPTIONAL : Status.COMPULSORY;
        return new Course(code, title, newStatus, weight);
    }

    @Override
    public String code() {
        return code;
    }
}
