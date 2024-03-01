package lab1package;

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() {
        System.out.println("Bark bark");
    }
}

class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class Question9_PolymorphismWithInterface {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        animal1.makeSound(); // This will call the makeSound() method of the Dog class
        animal2.makeSound(); // This will call the makeSound() method of the Cat class
    }
}
