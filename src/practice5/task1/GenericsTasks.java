package practice5.task1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Решения задания №1: операции с ArrayList и поиск максимальных элементов.
 */
public final class GenericsTasks {
    private GenericsTasks() {
        // Utility class.
    }

    /**
     * Возвращает новый ArrayList без дубликатов.
     * Порядок первого появления элементов сохраняется.
     * Для проверки используется List.contains(), как требует задание.
     */
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> source) {
        Objects.requireNonNull(source, "Исходный список не должен быть null");

        ArrayList<T> result = new ArrayList<T>();
        for (T element : source) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Линейный поиск элемента в массиве.
     * Возвращает индекс первого вхождения или -1, если элемент не найден.
     */
    public static <T> int linearSearch(T[] array, T target) {
        Objects.requireNonNull(array, "Массив не должен быть null");

        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возвращает наибольший элемент одномерного массива.
     * Тип элементов должен реализовывать Comparable.
     */
    public static <T extends Comparable<? super T>> T findLargest(T[] array) {
        Objects.requireNonNull(array, "Массив не должен быть null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        T largest = Objects.requireNonNull(array[0], "Элемент массива не должен быть null");
        for (int i = 1; i < array.length; i++) {
            T current = Objects.requireNonNull(
                    array[i], "Элемент массива не должен быть null");
            if (current.compareTo(largest) > 0) {
                largest = current;
            }
        }
        return largest;
    }

    /**
     * Возвращает наибольший элемент двумерного (в том числе ступенчатого) массива.
     * Пустые строки пропускаются. Если элементов нет, выбрасывается исключение.
     */
    public static <T extends Comparable<? super T>> T findLargest(T[][] array) {
        Objects.requireNonNull(array, "Массив не должен быть null");

        T largest = null;
        for (T[] row : array) {
            if (row == null) {
                continue;
            }
            for (T current : row) {
                Objects.requireNonNull(current, "Элемент массива не должен быть null");
                if (largest == null || current.compareTo(largest) > 0) {
                    largest = current;
                }
            }
        }

        if (largest == null) {
            throw new IllegalArgumentException(
                    "Двумерный массив не содержит ни одного элемента");
        }
        return largest;
    }
}
