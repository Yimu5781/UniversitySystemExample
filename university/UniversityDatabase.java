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

    @Override
    public String toString() {
        return "UniversityDatabase{" + "people=" + people + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.people);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UniversityDatabase other = (UniversityDatabase) obj;
        return Objects.equals(this.people, other.people);
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
