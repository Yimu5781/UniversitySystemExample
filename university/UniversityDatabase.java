package university;


import persons.Person;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.*;

public class UniversityDatabase {

    private final Map<Integer, Person> people;
    private final Map<Integer, Integer> numberOfPeoplePerYear;

    public UniversityDatabase() {
        this.people = new TreeMap<>();
        this.numberOfPeoplePerYear = new HashMap<>();
    }

    public Map<Integer, Person> getPeople(){
        return new TreeMap<>(people);
    }

    private static int getYearDigits(LocalDate date) {
        int year = date.getYear(); //2023
        return year%100;
    }

    private static String makeEnrolmentNumber(int number) {
        int digits = String.valueOf(number).length();
        int length = 6;
        return "0".repeat(length - digits) + number;
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
    
    public Person add(LocalDate joinDate, Person p) {
        if (people.containsValue(p)) {
            throw new IllegalArgumentException("Person "+ p +" already in database.");
        }
        int joinYear = getYearDigits(joinDate);
        int numberOfPeople= (numberOfPeoplePerYear.containsKey(joinYear)) ?
                numberOfPeoplePerYear.get(joinYear) + 1 :
                1;
        int id = Integer.parseInt(getYearDigits(joinDate)+makeEnrolmentNumber(numberOfPeople));
        numberOfPeoplePerYear.put(joinYear, numberOfPeople);
        return people.put(id, p);
    }

    private int findPersonKey(Person p){
        for (int id : people.keySet()){
            if (people.get(id).equals(p)){
                return id;
            }
        }
        throw new IllegalArgumentException("Person "+p+" cannot be found in database.");
    }

    public boolean remove(Person p) {
        return people.remove(findPersonKey(p), p);
    }
    
    public void updateAtEndOfYear() {
        for (Person p : people.values()) {
            p.endOfYear();
        }
    }


    //for displaying the database
    public void view() {
        System.out.println("Displaying University Database:");
        for(Map.Entry<Integer, Person> e : people.entrySet()){
            System.out.println("ID="+e.getKey()+", "+e.getValue());
        }
    }
    
}