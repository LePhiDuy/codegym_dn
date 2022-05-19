package _15_exception_and_debug.exercise;

public class MainTest {
    public static void main(String[] args) {
        try {
            Triangle t = new Triangle(2, -8, 8);
            System.out.println("Hello Triangle");
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
