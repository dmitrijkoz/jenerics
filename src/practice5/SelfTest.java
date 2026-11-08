package practice5;
import java.util.ArrayList;
import java.util.Arrays;
import practice5.cloning.House;
import practice5.cloning.MyStack;
import practice5.cloning.MyStackInherited;
import practice5.task1.Circle;
import practice5.task1.GenericsTasks;
import practice5.task2.ArrayListStack;
import practice5.task2.GenericStack;
public final class SelfTest {
    private SelfTest() {
    }
    public static void runAll() {
        int passed = 0;
        passed += testRemoveDuplicates();
        passed += testLinearSearch();
        passed += testLargestCircle();
        passed += testLargest2D();
        passed += testDynamicArrayStack();
        passed += testArrayListStack();
        passed += testMyStackComposition();
        passed += testMyStackInheritance();
        passed += testHouseClone();
        System.out.println("\nПроверки завершены: " + passed + "/9 успешно.");
    }
    private static int testRemoveDuplicates() {
        ArrayList<Integer> source = new ArrayList<Integer>(
                Arrays.asList(1, 2, 1, 3, 2));
        ArrayList<Integer> result = GenericsTasks.removeDuplicates(source);
        check(result.equals(Arrays.asList(1, 2, 3)), "removeDuplicates");
        return 1;
    }
    private static int testLinearSearch() {
        Integer[] values = {4, 8, 12, 8};
        check(GenericsTasks.linearSearch(values, 12) == 2, "linearSearch: найден");
        check(GenericsTasks.linearSearch(values, 99) == -1, "linearSearch: не найден");
        return 1;
    }
    private static int testLargestCircle() {
        Circle[] circles = {new Circle(1), new Circle(5), new Circle(3)};
        check(GenericsTasks.findLargest(circles).getRadius() == 5.0,
                "findLargest(Circle[])");
        return 1;
    }
    private static int testLargest2D() {
        Integer[][] values = {{1, 7}, {3}, {2, 9, 4}};
        check(GenericsTasks.findLargest(values) == 9, "findLargest(T[][])");
        return 1;
    }
    private static int testDynamicArrayStack() {
        GenericStack<Integer> stack = new GenericStack<Integer>(1);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        check(stack.getCapacity() == 4, "удвоение вместимости массива");
        check(stack.pop() == 30 && stack.peek() == 20, "LIFO для GenericStack");
        return 1;
    }
    private static int testArrayListStack() {
        ArrayListStack<String> stack = new ArrayListStack<String>();
        stack.push("A");
        stack.push("B");
        check("B".equals(stack.pop()) && "A".equals(stack.peek()),
                "ArrayListStack");
        return 1;
    }
    private static int testMyStackComposition() {
        MyStack<String> stack = new MyStack<String>();
        stack.push("first");
        stack.push("second");
        check("second".equals(stack.pop()) && stack.getSize() == 1,
                "MyStack composition");
        return 1;
    }
    private static int testMyStackInheritance() {
        MyStackInherited<String> stack = new MyStackInherited<String>();
        stack.push("first");
        stack.push("second");
        check("second".equals(stack.pop()) && stack.getSize() == 1,
                "MyStack inheritance");
        return 1;
    }
    private static int testHouseClone() {
        House original = new House(1, 150.0);
        House copy = original.clone();
        check(original != copy, "House clone creates new object");
        check(original.getWhenBuilt() != copy.getWhenBuilt(),
                "House clone copies Date deeply");
        check(original.compareTo(copy) == 0, "House compareTo");
        MyStack<House> stack = new MyStack<House>();
        stack.push(original);
        MyStack<House> stackCopy = stack.clone();
        check(stack.peek() != stackCopy.peek(), "MyStack deep copy of element");
        check(stack.peek().getWhenBuilt() != stackCopy.peek().getWhenBuilt(),
                "MyStack deep copy of nested Date");
        return 1;
    }
    private static void check(boolean condition, String testName) {
        if (!condition) {
            throw new AssertionError("Проверка не пройдена: " + testName);
        }
        System.out.println("[OK] " + testName);
    }
}