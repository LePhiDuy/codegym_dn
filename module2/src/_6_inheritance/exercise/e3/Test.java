package _6_inheritance.exercise.e3;

public class Test {
    public static void main(String[] args) {
        Point point = new Point(3, 2);
        System.out.println(point.toString());

        MovablePoint movablePoint = new MovablePoint(2, 5, 3, 6);
        movablePoint = movablePoint.move();
        System.out.println(movablePoint.getX());
    }


}
