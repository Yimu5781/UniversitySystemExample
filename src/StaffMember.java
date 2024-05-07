public class StaffMember extends Person{

    private static final double RATE = 0.1;

    //fields
    private String department;
    private double salary;

    public StaffMember(String name, Gender gender, String department, double salary) {
        super(name, gender);
        this.department = department;
        this.salary = salary;
    }

    public void endOfYear(){
        this.salary *= (1 + RATE);
    }

    @Override
    public String toString() {
        return "StaffMember{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    //getter
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
