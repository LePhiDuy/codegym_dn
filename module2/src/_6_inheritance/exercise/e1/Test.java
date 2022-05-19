package _6_inheritance.exercise.e1;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());

        Circle circle1 = new Circle(5, "yellow");
        System.out.println(circle1.toString());

        System.out.println("Area of circle1 = " + circle1.getArea());

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder.toString());

        Cylinder cylinder1 = new Cylinder(5, "red", 3);
        System.out.println(cylinder1.toString());
        System.out.println("V of cylinder1 = " + cylinder1.getV());
    }
}
