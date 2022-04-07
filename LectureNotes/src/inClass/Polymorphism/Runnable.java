package inClass.Polymorphism;

public class Runnable {
    public static void main(String[] args) {
        //Upcasting
        //Animal myAnimal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        //myAnimal.animalSound();
        dog.animalSound();
        cat.animalSound();
    }
}
