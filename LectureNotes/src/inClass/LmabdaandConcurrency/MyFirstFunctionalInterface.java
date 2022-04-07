package inClass.LmabdaandConcurrency;
@FunctionalInterface
public interface MyFirstFunctionalInterface
{
//    public void firstWork();
    public int incrementByFive(int a);
    //------------ default method One------------
    public default void doSomeMoreWork1(){
        //Method body
        System.out.println("default method one executed");
    }
    //------------ default method two------------
    public  default void doSomeMoreWork2(){
        //Method body
        System.out.println("default method two executed");
    }
}

