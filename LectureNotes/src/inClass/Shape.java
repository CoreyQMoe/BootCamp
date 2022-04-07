package inClass;

public class Shape {
    //Global or Class variables
    private double width;
    private double height;
    private String name;

    public Shape() {
    }

    public Shape(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printMessage() {
        System.out.println("Print message called");
    }

    public String toString() {
        return "To String called";
    }

    public double getPerimeter() {
        return 2*(this.height + this.width);
    }

    public double getArea() {
        return (this.height * this.width);
    }

    public void method(int ...y) {

    }
}
