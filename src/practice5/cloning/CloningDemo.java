package practice5.cloning;
import java.util.Scanner;
public final class CloningDemo {
    private CloningDemo() {
    }
    public static void runCompositionClient(Scanner scanner) {
        System.out.println("\nMyStack на основе композиции");
        MyStack<String> stack = new MyStack<String>();
        readFiveStrings(scanner, stack::push);
        System.out.println("Строки в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    public static void runInheritanceClient(Scanner scanner) {
        System.out.println("\nMyStackInherited на основе наследования");
        MyStackInherited<String> stack = new MyStackInherited<String>();
        readFiveStrings(scanner, stack::push);
        System.out.println("Строки в обратном порядке:");
        while (!stack.isEmptyStack()) {
            System.out.println(stack.pop());
        }
    }
    private static void readFiveStrings(Scanner scanner,
                                        java.util.function.Consumer<String> consumer) {
        for (int i = 1; i <= 5; i++) {
            System.out.print("Введите строку " + i + " из 5: ");
            consumer.accept(scanner.nextLine());
        }
    }
    public static void demonstrateDeepCopyOfMyStack() {
        System.out.println("\nГлубокое копирование MyStack");
        MyStack<House> original = new MyStack<House>();
        original.push(new House(1, 1750.50));
        original.push(new House(2, 2300.00));
        MyStack<House> copy = original.clone();
        System.out.println("Исходный стек: " + original);
        System.out.println("Копия стека:   " + copy);
        System.out.println("Стек и копия — разные списки: " + (original != copy));
        System.out.println("Первый House — разные объекты: "
                + (original.peek() != copy.peek()));
        System.out.println("Date у первого House — разные объекты: "
                + (original.peek().getWhenBuilt() != copy.peek().getWhenBuilt()));
        MyStack<String> strings = new MyStack<String>();
        strings.push("Java");
        MyStack<String> stringsCopy = strings.clone();
        System.out.println("Копия стека строк: " + stringsCopy);
    }
    public static void demonstrateHouseCloning() {
        System.out.println("\nПоверхностное и глубокое клонирование House");
        House original = new House(1, 1750.50);
        House shallow = original.shallowClone();
        House deep = original.clone();
        System.out.println("Исходный и shallow — разные House: " + (original != shallow));
        System.out.println("Date у исходного и shallow общая: "
                + (original.getWhenBuilt() == shallow.getWhenBuilt()));
        System.out.println("Исходный и deep — разные House: " + (original != deep));
        System.out.println("Date у исходного и deep разная: "
                + (original.getWhenBuilt() != deep.getWhenBuilt()));
        System.out.println("compareTo для домов с одинаковой площадью: "
                + original.compareTo(deep));
    }
}