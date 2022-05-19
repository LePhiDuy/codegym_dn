package _4_class_and_object.exercise.e1;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return (-this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(getDiscriminant())) / (2 * this.a);
    }

    public double getRoot12() {
        return -this.b / (2 * this.a);
    }

    public void getRoot() {
        if (getDiscriminant() > 0) {
            System.out.println("The equation has two roots " + getRoot1() + " and " + getRoot2());
        } else if (getDiscriminant() == 0) {
            System.out.println("The equation has one root " + getRoot12());
        } else {
            System.out.println("The euqation has no real root");
        }
    }

    public static void main(String[] args) {
        QuadraticEquation qua = new QuadraticEquation(1, 2, 1);
        qua.getRoot();
    }
}
