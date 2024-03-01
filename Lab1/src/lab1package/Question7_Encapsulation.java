package lab1package;

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
}

public class Question7_Encapsulation {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Danielle");
        person.setAge(-30); // This will not set the age because it is negative
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
