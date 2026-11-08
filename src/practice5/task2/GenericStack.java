package practice5.task2;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Обобщённый стек на основе обычного массива.
 * При заполнении массива его вместимость автоматически удваивается.
 */
public class GenericStack<E> {
    private static final int DEFAULT_CAPACITY = 2;

    private Object[] elements;
    private int size;

    public GenericStack() {
        this(DEFAULT_CAPACITY);
    }

    public GenericStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Начальная вместимость не может быть отрицательной");
        }
        elements = new Object[Math.max(1, initialCapacity)];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Добавляет элемент на вершину стека. */
    public void push(E element) {
        ensureCapacity(size + 1);
        elements[size] = element;
        size++;
    }

    /** Возвращает верхний элемент, не удаляя его. */
    @SuppressWarnings("unchecked")
    public E peek() {
        ensureNotEmpty();
        return (E) elements[size - 1];
    }

    /** Возвращает и удаляет верхний элемент. */
    @SuppressWarnings("unchecked")
    public E pop() {
        ensureNotEmpty();
        int topIndex = size - 1;
        E value = (E) elements[topIndex];
        elements[topIndex] = null;
        size--;
        return value;
    }

    public int getCapacity() {
        return elements.length;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity <= elements.length) {
            return;
        }
        int newCapacity = Math.max(requiredCapacity, elements.length * 2);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
    }

    @Override
    public String toString() {
        return "Стек (снизу вверх): "
                + Arrays.toString(Arrays.copyOf(elements, size));
    }
}
