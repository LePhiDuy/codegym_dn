package _7_abstract_class_interface.exercise.e2;

public class MainTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Rectangle();
        shapes[1] = new Square();
        for (Shape obj : shapes) {
            System.out.println(obj.getArea());
            if (obj instanceof  Square) {
                ((Square) obj).howToColor();
            }
        }
    }


}
