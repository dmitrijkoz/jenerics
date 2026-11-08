package practice5.cloning;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public class MyStackInherited<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;
    public boolean isEmptyStack() {
        return isEmpty();
    }
    public int getSize() {
        return size();
    }
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
    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Стек пуст");
        }
    }
}