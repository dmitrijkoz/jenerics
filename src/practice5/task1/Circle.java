package practice5.task1;
public final class Circle implements Comparable<Circle> {
    private final double radius;
    public Circle(double radius) {
        if (Double.isNaN(radius) || Double.isInfinite(radius) || radius < 0.0) {
            throw new IllegalArgumentException("Радиус должен быть конечным и неотрицательным");
        }
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public int compareTo(Circle other) {
        if (other == null) {
            throw new NullPointerException("Сравниваемый круг не должен быть null");
        }
        return Double.compare(this.radius, other.radius);
    }
    @Override
    public String toString() {
        return String.format("Circle{radius=%.2f, area=%.2f}", radius, getArea());
    }
}