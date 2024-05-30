package persons;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person implements Comparable<Person> {
    
    public enum Gender {
        FEMALE, MALE, NON_BINARY, PREFER_NOT_TO_SAY
    }
    
    //static class variable for ID generation
    private static int numberOfPeople = 0;
    
    //fields
    private final String name;
    private final Gender gender;

    public Person(String name, Gender gender) {
//        numberOfPeople++;
//        this.id = Integer.parseInt(getYearDigits(joinDate) + makeEnrolmentNumber(numberOfPeople));
        this.name = name;
        this.gender = gender;
    }

    @Override
    public int compareTo(Person other){
//        if(this.name.compareTo(other.name)>0){
//            return this.name.compareTo(other.name);
//        }
        return this.name.compareTo(other.name);
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

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public static int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", gender=" + gender + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && gender == person.gender;
    }

    public abstract void endOfYear();
    
}

