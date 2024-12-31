package week5.salma.id.ac.umn;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    public double getArea() {
        return 2.0 * Math.PI * getRadius() * height;
    }

    public String toString() {
        return "Circle[height=" + height + "," + super.toString() + "]";
    }
}
