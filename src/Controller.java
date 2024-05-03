import jdk.jshell.Snippet;

import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void main(String[] args){

        Course CPT401=new Course("CPT401","Research Method",5, Course.Status.compulsory);
        Course CPT405=new Course("CPT405","Interactive Systems",5, Course.Status.optional);
        Course CAN401=new Course("CAN401","Cloud Computer",5, Course.Status.optional);
        Course INT409=new Course("INT409","Spoken Language Processing",5, Course.Status.optional);
        Course SAT405=new Course("SAT405","MRes Dissertation Project",40, Course.Status.compulsory);
        Course CPT409=new Course("CPT409", "Research Project Management",5, Course.Status.compulsory);
        ArrayList<Course> myCourses = new ArrayList<>(
                List.of(CPT401, CPT409, CPT405, SAT405, INT409)
        );
        Student me= new Student("20220001","Thomas Selig", Student.Gender.MALE, myCourses, 50, 1);
        System.out.println(me.toString());
        System.out.println(me);
//        int[] year1Grades= {50,50,60,60,40};
//        me.calculateAverageGrade(year1Grades);
//        System.out.println(me.toString());
//        me.endOfYear(me);
//        System.out.println(me.toString());
//        ArrayList<String> herCourses = new ArrayList<>(
//                List.of("CPT401", "CPT402", "INT404", "CPT405")
//        );
//        Student her = new Student("20220002","Boyu Yang", Student.Gender.FEMALE, herCourses, 80);
//        System.out.println(her.toString());

    }
}
