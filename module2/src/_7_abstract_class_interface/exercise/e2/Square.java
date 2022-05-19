package _7_abstract_class_interface.exercise.e2;

public class Square extends Rectangle implements Colorable{
    public Square(double side) {
        super(side, side);
    }
    public Square() {

    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    public void setWidth(double width) {
        setSide(width);
    }

    public void setLength(double length) {
        setSide(length);
    }

    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    public double getArea() {
        return super.getArea();
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
