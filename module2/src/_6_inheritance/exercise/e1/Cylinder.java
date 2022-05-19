package _6_inheritance.exercise.e1;

public class Cylinder extends Circle{
    private double height;
    public Cylinder() {

    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public Cylinder(double height) {
        this.height = height;
    }

    public double getV() {
        return super.getArea() * height;
    }

    public String toString() {
        return "A cylinder with height = " + height + ", which is a subclass of " + super.toString();
    }
}
