package inClass.Polymorphism;

public class Cat  extends Animal{
    protected int a = 1;
    @Override
    public void animalSound() {
        System.out.println("The cat says me-wow");
    }


}
