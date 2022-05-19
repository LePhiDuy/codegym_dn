package _6_inheritance.exercise.e2;

public class Point3D extends Point2D{
    private float z;

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] result = {getX(), getY(), z};
        return result;
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}

