package inClass.Polymorphism;

public class Dog  extends Animal{
    @Override
    protected void animalSound() {
        System.out.println("The dog says woof");
    }
}
