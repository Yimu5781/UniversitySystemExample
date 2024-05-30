package persons;

import java.time.LocalDate;
import java.util.Objects;

public class Academic extends Person {
    
    public enum Position {
        
        LECTURER(25000, 35000), 
        ASSISTANT_PROFESSOR(35000, 50000), 
        ASSOCIATE_PROFESSOR(50000, 100000), 
        FULL_PROFESSOR(100000, Integer.MAX_VALUE);
        
        private final int minSalary;
        private final int maxSalary;
        
        Position(int minSalary, int maxSalary) {
            this.minSalary = minSalary;
            this.maxSalary = maxSalary;
        }
        
    }
    
    //fields
    private Position position;
    private String department;
    private int salary;
    
    //constant: rate of salary increase
    private static final double RATE = 0.03;
    
    //constructors
    public Academic(String name, Gender gender,
            Position position, String department, int salary) {
        super(name, gender);
        this.position = position;
        this.department = department;
        checkSalary(salary, position);
        this.salary = salary;
    }
    
    public Academic(String name, Gender gender,
            Position position, String department) {
        this(name, gender, position, department, position.minSalary);
    }
    
    private static void checkSalary(int salary, Position position) {
        if (salary < position.minSalary || salary > position.maxSalary) {
            throw new IllegalArgumentException("salary for " + position 
                    + " must be between " + position.minSalary + " and " + position.maxSalary);
        }
    }
    
    //getters
    public Position getPosition() {
        return position;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public int getSalary() {
        return salary;
    }
    
    //to display StaffMember data
    @Override
    public String toString() {
        return "Student{" +  "name=" + getName() + ", gender=" + getGender()
                + ", position=" + position + ", department=" + department + ", salary=" + salary + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + super.hashCode();
        hash = 41 * hash + Objects.hashCode(this.position);
        hash = 41 * hash + Objects.hashCode(this.department);
        hash = 41 * hash + this.salary;
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
        final Academic other = (Academic) obj;
        if (!super.equals(other)) {
            return false;
        }
        if (this.salary != other.salary) {
            return false;
        }
        if (!Objects.equals(this.department, other.department)) {
            return false;
        }
        return this.position == other.position;
    }
    
    //salary increase at end of year
    @Override
    public void endOfYear() {
        salary *= 1 + RATE;
    }
    
    //promotion
    public void promote() {
        Position[] positionArray = Position.values();
        if (position.ordinal() == positionArray.length - 1) return; // full professors can't be promoted further
        position = positionArray[position.ordinal() + 1];
        salary = position.minSalary;
    }
    
}

