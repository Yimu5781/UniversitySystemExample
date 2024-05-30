package university;

import courses.Course;
import persons.*;
import persons.Person.Gender;
import courses.Course.Status;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;
import persons.Academic;
import persons.Academic.Position;

public class Controller {

    public static void main(String[] args) {
        Course cpt401 = new Course("CPT401", "Research Methods", Status.COMPULSORY, 5);
        Course cpt409 = new Course("CPT409", "Research Project Management", Status.COMPULSORY, 5);
        Course cpt403 = new Course("CPT403", "Object Oriented Programming", Status.OPTIONAL, 5);
        Course cpt405 = new Course("CPT409", "Interactive Systems", Status.COMPULSORY, 5);
//        ArrayList<Course> herCourses = new ArrayList<>(
//                List.of(
//                        cpt401, cpt409, cpt403, cpt405
//                )
//        );
////        Person her = new Student(LocalDate.of(2021, Month.SEPTEMBER, 1), "Sisi Liu", Gender.FEMALE, herCourses, 60, 3);
////        Person me = new Academic(LocalDate.now(), "Thomas Selig", Gender.MALE, Position.ASSISTANT_PROFESSOR,
////                "Computing");
//        UniversityDatabase db = new UniversityDatabase();
////        db.add(her);
////        db.add(me);
//        db.add(new Academic(LocalDate.of(2021,Month.SEPTEMBER, 1),"Thomas", Gender.MALE, Position.ASSISTANT_PROFESSOR,"CPT", 40000));
//        db.add(new Student(LocalDate.now() , "Erica", Gender.FEMALE,herCourses,70,1));
//        db.add(new Academic(LocalDate.of(2020,Month.SEPTEMBER, 1), "Sisi", Gender.FEMALE,Position.ASSISTANT_PROFESSOR,"SAT",35000));
//        db.view();
////        db.updateAtEndOfYear();
////        db.view();
//        List<Person> people = new ArrayList<>();
//        people.add(new Academic(LocalDate.of(2021,Month.SEPTEMBER, 1),"Thomas", Gender.MALE, Position.ASSISTANT_PROFESSOR,"CPT", 40000));
//        people.add(new Student(LocalDate.now() , "Erica", Gender.FEMALE,herCourses,70,1));
//        people.add(new Academic(LocalDate.of(2020,Month.SEPTEMBER, 1), "Sisi", Gender.FEMALE,Position.ASSISTANT_PROFESSOR,"SAT",35000));
//        System.out.println("First = " + Collections.min(people));
//        System.out.println("Last = " + Collections.max(people));
        Map<Course, Integer> herGrades=new HashMap<>();
        herGrades.put(cpt401, 60);
        herGrades.put(cpt409, 70);
        herGrades.put(cpt403, 67);
        herGrades.put(cpt405, 73);
        LocalDate herJoinDate = LocalDate.of(2021, Month.SEPTEMBER, 1);
        Student her = new Student("Sisi Liu", Gender.FEMALE, Student.Category.PG, herGrades);
        UniversityDatabase db = new UniversityDatabase();
        db.add(herJoinDate, her);
        Person me = new Academic("Thomas Selig",Gender.MALE,Position.ASSISTANT_PROFESSOR,"SAT",35000);
        db.add(LocalDate.of(2019, Month.DECEMBER, 2), me);
        db.view();
    }
    
}
