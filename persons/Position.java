package persons;

public enum Position {

    LECTURER(25000, 35000),
    ASSISTANT_PROFESSOR(35000, 50000),
    ASSOCIATE_PROFESSOR(50000, 100000),
    FULL_PROFESSOR(100000, Integer.MAX_VALUE);

    public final int minSalary;
    public final int maxSalary;

    Position(int minSalary, int maxSalary) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

}
