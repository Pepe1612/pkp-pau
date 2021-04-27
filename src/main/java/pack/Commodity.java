package pack;

public class Commodity {

    private String name;
    private String description;
    private int amount;
    private int age;

    public Commodity(String name, int amount, int age) {
        this.name = name;
        this.amount = amount;
        this.age = age;
        this.description = "No description";
    }

    public Commodity(String name, int amount, int age, String description) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "NAME:" + this.name + "  AMOUNT:" + this.amount + "  DESCRIPTION:" + this.description;
    }
}
