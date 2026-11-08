package practice5.task1;
import java.util.ArrayList;
import java.util.Arrays;
public final class GenericsDemo {
    private GenericsDemo() {
    }
    public static void runAll() {
        demonstrateRemoveDuplicates();
        demonstrateLinearSearch();
        demonstrateLargestCircle();
        demonstrateLargestInTwoDimensionalArray();
    }
    public static void demonstrateRemoveDuplicates() {
        System.out.println("\n1.1. Удаление дубликатов из ArrayList");
        ArrayList<String> source = new ArrayList<String>(Arrays.asList(
                "Java", "C++", "Java", "Python", "C++", "Kotlin"));
        System.out.println("Исходный список: " + source);
        System.out.println("Без дубликатов:  "
                + GenericsTasks.removeDuplicates(source));
    }
    public static void demonstrateLinearSearch() {
        System.out.println("\n1.2. Линейный поиск");
        Integer[] numbers = {12, 7, 25, 4, 18, 25};
        int target = 18;
        int index = GenericsTasks.linearSearch(numbers, target);
        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.println("Искомый элемент: " + target);
        System.out.println("Индекс первого вхождения: " + index);
        System.out.println("Поиск отсутствующего элемента 99: "
                + GenericsTasks.linearSearch(numbers, 99));
    }
    public static void demonstrateLargestCircle() {
        System.out.println("\n1.3. Поиск круга с наибольшим радиусом");
        Circle[] circles = {
                new Circle(2.5),
                new Circle(5.0),
                new Circle(1.75),
                new Circle(4.2)
        };
        System.out.println("Круги: " + Arrays.toString(circles));
        System.out.println("Наибольший круг: "
                + GenericsTasks.findLargest(circles));
    }
    public static void demonstrateLargestInTwoDimensionalArray() {
        System.out.println("\n1.4. Поиск максимума в двумерном массиве");
        Integer[][] matrix = {
                {3, 17, 8},
                {21, 5},
                {11, 42, 9, 14}
        };
        System.out.println("Двумерный массив: " + Arrays.deepToString(matrix));
        System.out.println("Наибольший элемент: "
                + GenericsTasks.findLargest(matrix));
    }
}