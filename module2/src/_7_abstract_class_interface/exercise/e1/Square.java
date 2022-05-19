package _7_abstract_class_interface.exercise.e1;

public class Square extends Rectangle implements Resizeable{
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

    @Override
    public void resize(double percent) {
        super.resize(percent);
    }

    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
