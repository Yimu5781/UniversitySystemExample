package university;

import persons.Person;

import java.util.ArrayList;
import java.util.Objects;

public class UniversityDatabase {
    private ArrayList<Person> people;

    public UniversityDatabase(ArrayList<Person> people) {
        this.people = people;
    }

    public UniversityDatabase() {
        this.people = new ArrayList<>();
    }

    public ArrayList<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public String toString() {
        return "UniversityDatabase{" + "people=" + people + '}';
    }

    public boolean add(Person p) {
        if (people.contains(p)) {
            return false;
        }
        return people.add(p);
    }

    public boolean remove(Person p) {
        return people.remove(p);
    }

    public void updateAtEndOfYear() {
        for (Person p : people) {
            p.endOfYear();
        }
    }

    //for displaying the database
    public void view() {
        System.out.println("Displaying University Database:");
        for (Person p : people) {
            System.out.println(p);
        }
    }

}
