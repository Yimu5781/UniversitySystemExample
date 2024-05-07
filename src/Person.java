import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private static int numberOfPeople = 0;

    public enum Gender {
        FEMALE, MALE, NON_BINARY, PREFER_NOT_TO_SAY
    }

    //fields
    protected String id;
    protected final String name;
    protected final Student.Gender gender;

    //constructor
    public Person(String name, Student.Gender gender) {
        numberOfPeople++;
        this.id = makeEnrolmentNumber();
        validateName(name);
        this.name = name;
        this.gender = gender;
    }

    //getter
    public static int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    protected static String getYear(){
        LocalDate t= LocalDate.now();
        String time=t.toString();
        String[] part=time.split("-");
        return "" + part[0].charAt(2) + part[0].charAt(3);
    }

    protected static String makeEnrolmentNumber(){
        String year=getYear();
        String number=String.format("%04d", getNumberOfPeople());
        return year+number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender);
    }

    //validate
    private void validateName(String name){
        String[] parts = name.split(" ");
        if (parts.length!=2){
            throw new IllegalArgumentException("Name must be 2 parts.");
        }
        String firstName = parts[0];
        String lastName = parts[1];
        if(!(Character.isUpperCase(firstName.charAt(0))&&Character.isUpperCase(lastName.charAt(0)))){
            throw new IllegalArgumentException("The first letter must be upper");
        }
        }
}
