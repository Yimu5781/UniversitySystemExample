package persons;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {

    public abstract void endOfYear();

    public enum Gender {
        FEMALE, MALE, NON_BINARY, PREFER_NOT_TO_SAY
    }
    
    //static class variable for ID generation
    private static int numberOfPeople = 0;
    
    //fields
    private final int id;
    private final String name;
    private final Gender gender;

    public Person(LocalDate joinDate, String name, Gender gender) {
        numberOfPeople++;
        this.id = Integer.parseInt(getYearDigits(joinDate) + makeEnrolmentNumber(numberOfPeople));
        this.name = name;
        this.gender = gender;
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

    public int getId() {
        return id;
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
        return "Person{" + "id=" + id + ", name=" + name + ", gender=" + gender + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.gender);
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
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return this.gender == other.gender;
    }
    
}
