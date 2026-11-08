package practice5.task2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Вариант стека, реализованный наследованием от ArrayList.
 * Элементы добавляются и удаляются с конца списка.
 */
public class ArrayListStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;

    public void push(E element) {
        add(element);
    }

    public E peek() {
        ensureNotEmpty();
        return get(size() - 1);
    }

    public E pop() {
        ensureNotEmpty();
        return remove(size() - 1);
    }

    public int getSize() {
        return size();
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
    }
}
