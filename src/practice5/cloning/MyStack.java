package practice5.cloning;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Стек на основе композиции: MyStack содержит ArrayList.
 * clone() глубоко копирует поддерживаемые элементы списка.
 */
public class MyStack<E> implements Cloneable {
    private ArrayList<E> list;

    public MyStack() {
        list = new ArrayList<E>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public E peek() {
        ensureNotEmpty();
        return list.get(list.size() - 1);
    }

    public E pop() {
        ensureNotEmpty();
        return list.remove(list.size() - 1);
    }

    public void push(E element) {
        list.add(element);
    }

    /** Возвращает глубокую копию стека, не меняя исходный стек. */
    @Override
    public MyStack<E> clone() {
        MyStack<E> copy = new MyStack<E>();
        for (E element : list) {
            @SuppressWarnings("unchecked")
            E clonedElement = (E) DeepCopyUtils.copy(element);
            copy.list.add(clonedElement);
        }
        return copy;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
    }

    @Override
    public String toString() {
        return "Стек (снизу вверх): " + list;
    }
}
