package _6_inheritance.exercise.e2;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(5, 3);
        Point3D point3D = new Point3D(5, 2, -5);
        System.out.println(point2D.toString());
        System.out.println(point3D.toString());
        float[] arr = point2D.getXY();
        System.out.println(arr[1]);
    }
}
