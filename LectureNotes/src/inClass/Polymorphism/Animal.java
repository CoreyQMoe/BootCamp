package inClass.Polymorphism;

public abstract class Animal {
    int a;
    protected abstract void animalSound();

    final void getRest() {
        System.out.println("The animal sleeps");
    }
}
