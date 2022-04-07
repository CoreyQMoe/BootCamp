package inClass.LmabdaandConcurrency;
@FunctionalInterface
public interface HumanInterface {

    void eat(String a);

    default void sleep() {
        System.out.println("Default method");
    }

    static void communication() {
        System.out.println("Static method");
    }
}
