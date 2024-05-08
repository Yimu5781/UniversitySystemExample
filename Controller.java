import persons.*;
import university.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    
    public static void main(String[] args){
        Course CPT401=new Course("CPT401","Research Method",Course.Status.COMPULSORY,5);
        Course CPT405=new Course("CPT405","Interactive Systems", Course.Status.OPTIONAL, 5);
        Course CAN401=new Course("CAN401","Cloud Computer",Course.Status.OPTIONAL, 5);
        Course INT409=new Course("INT409","Spoken Language Processing",Course.Status.OPTIONAL, 5);
        Course SAT405=new Course("SAT405","MRes Dissertation Project", Course.Status.COMPULSORY,20);
        Course CPT409=new Course("CPT409", "Research Project Management",Course.Status.OPTIONAL, 5);
        ArrayList<Course> myCourses = new ArrayList<>(
                List.of(CPT401, CPT409, CPT405, SAT405, INT409)
        );
        ArrayList<Course> herCourses = new ArrayList<>(
                List.of(CPT401, CPT405, CAN401, INT409, SAT405, CPT409)
        );

        Person me= new Student(LocalDate.of(2023, 9, 1), "Thomas Selig", Person.Gender. MALE,myCourses, 50, 1);
        Person her = new Student(LocalDate.of(2023,9,1),"Bob Yi", Student.Gender.FEMALE, herCourses, 80, 2);
        Person p1 = new Academic( LocalDate.of(2020,6,1),"Lily White",Person.Gender.FEMALE,"SAT",5000,Position.LECTURER);
        Person p2 = new Academic(LocalDate.of(2015,6,1),"Paul Jackson", Person.Gender.MALE,"EEE",10000,Position.ASSISTANT_PROFESSOR);

        UniversityDatabase db = new UniversityDatabase();
        db.add(her);
        db.add(me);
        db.view();
        db.updateAtEndOfYear();
        db.view();
    }


}
