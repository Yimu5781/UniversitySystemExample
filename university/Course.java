package university;

import java.util.ArrayList;

public record Course(String code,String title,Status status,int weight) {
    public enum Status { COMPULSORY, OPTIONAL }
    static ArrayList<Course> allCourses = new ArrayList<>();
    public Course {
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
        return allCourses;
    }

    public boolean remove() {
        return allCourses.remove(this);
    }
}