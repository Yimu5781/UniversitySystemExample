public class Person {

    public enum Gender {
        FEMALE, MALE, NON_BINARY, PREFER_NOT_TO_SAY
    }

    //fields
    protected final String id;
    protected String name;
    protected final Student.Gender gender;

    //constructor
    public Person(String id, Student.Gender gender, String name) {
        this.id = id;
        this.gender = gender;
        if(validateName(name)){
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    //validate
    private boolean validateName(String name){
        String[] parts = name.split(" ");
        if (parts.length!=2){
            throw new IllegalArgumentException("Name must be 2 parts.");
        }
        String firstName = parts[0];
        String lastName = parts[1];
        if(!(Character.isUpperCase(firstName.charAt(0))&&Character.isUpperCase(lastName.charAt(0)))){
            throw new IllegalArgumentException("The first letter must be upper");
        }
        return true;
        }
}
