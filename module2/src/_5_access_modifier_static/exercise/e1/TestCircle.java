package _5_access_modifier_static.exercise.e1;

public class TestCircle {
    public static void main(String[] args) {
        Circle obj = new Circle(5);
        System.out.println(obj.getRadius());
        System.out.println(obj.getArea());
    }
}
