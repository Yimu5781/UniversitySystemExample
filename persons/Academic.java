package persons;

import java.time.LocalDate;

public class Academic extends Person {
    
    //fields
    private String department;
    private int salary;
    private Position position;
    
    //constant: rate of salary increase
    private static final double RATE = 0.03;
    
    //constructors
    public Academic(LocalDate employmentDate, String name, Gender gender,
                    String department, int salary, Position position) {
        super(employmentDate, name, gender);
        this.department = department;
        this.salary = salary;
        this.position = position;
    }
    
    //getters
    public String getDepartment() {
        return department;
    }
    
    public int getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }

    //salary increase at end of year
    public void endOfYear() {
        salary *= (1 + RATE);
    }

    public void promote() {
        Position[] positionArray = Position.values();
        if (position.ordinal() == positionArray.length - 1)
            return; // full professors can't be promoted further
        position = positionArray[position.ordinal() + 1];
        salary = position.minSalary;
    }
    
}

