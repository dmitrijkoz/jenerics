package practice5.cloning;

import java.util.Date;

/**
 * Дом из теоретического примера.
 * Сравнение выполняется по площади, clone() создаёт глубокую копию Date.
 */
public class House implements Cloneable, Comparable<House>, DeepCopyable<House> {
    private int id;
    private double area;
    private Date whenBuilt;

    public House(int id, double area) {
        if (area < 0 || Double.isNaN(area) || Double.isInfinite(area)) {
            throw new IllegalArgumentException("Площадь должна быть конечной и неотрицательной");
        }
        this.id = id;
        this.area = area;
        this.whenBuilt = new Date();
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    /** Возвращает фактическую ссылку Date для демонстрации клонирования. */
    public Date getWhenBuilt() {
        return whenBuilt;
    }

    @Override
    public int compareTo(House other) {
        if (other == null) {
            throw new NullPointerException("Сравниваемый дом не должен быть null");
        }
        return Double.compare(this.area, other.area);
    }

    /** Поверхностная копия: ссылка whenBuilt остаётся общей. */
    public House shallowClone() {
        try {
            return (House) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError("House реализует Cloneable", ex);
        }
    }

    /** Глубокая копия: создаётся отдельный объект Date. */
    @Override
    public House clone() {
        House copy = shallowClone();
        copy.whenBuilt = (Date) this.whenBuilt.clone();
        return copy;
    }

    @Override
    public House deepCopy() {
        return clone();
    }

    @Override
    public String toString() {
        return "House{id=" + id + ", area=" + area
                + ", whenBuilt=" + whenBuilt + "}";
    }
}
