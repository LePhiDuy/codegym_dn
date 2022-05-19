package _7_abstract_class_interface.exercise.e1;

public class MainTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("yellow", true, 3.5);
        shapes[1] = new Rectangle(3.5, 3.7);
        shapes[2] = new Square(3.5);
        System.out.println("Area of Circle before resize: " + ((Circle)shapes[0]).getArea());
        ((Circle) shapes[0]).resize(5);
        System.out.println("Area of Circle after resize: " + ((Circle)shapes[0]).getArea());
    }
}
