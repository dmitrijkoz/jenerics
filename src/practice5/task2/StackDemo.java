package practice5.task2;
import java.util.Scanner;
public final class StackDemo {
    private StackDemo() {
    }
    public static void demonstrateArrayStack() {
        System.out.println("\n2.1. GenericStack на динамическом массиве");
        GenericStack<Integer> stack = new GenericStack<Integer>(2);
        System.out.println("Начальная вместимость: " + stack.getCapacity());
        for (int value = 10; value <= 50; value += 10) {
            stack.push(value);
            System.out.println("Добавлено " + value
                    + "; размер = " + stack.getSize()
                    + "; вместимость = " + stack.getCapacity());
        }
        System.out.println(stack);
        System.out.println("Верхний элемент (peek): " + stack.peek());
        System.out.println("Удалённый элемент (pop): " + stack.pop());
        System.out.println("После pop: " + stack);
    }
    public static void runArrayListInheritanceClient(Scanner scanner) {
        System.out.println("\n2.2. Стек, наследующий ArrayList");
        ArrayListStack<String> stack = new ArrayListStack<String>();
        readFiveStrings(scanner, stack::push);
        System.out.println("Строки в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    public static void readFiveStrings(Scanner scanner,
                                      java.util.function.Consumer<String> consumer) {
        for (int i = 1; i <= 5; i++) {
            System.out.print("Введите строку " + i + " из 5: ");
            consumer.accept(scanner.nextLine());
        }
    }
}