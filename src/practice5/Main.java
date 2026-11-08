package practice5;

import java.util.Scanner;
import practice5.cloning.CloningDemo;
import practice5.task1.GenericsDemo;
import practice5.task2.StackDemo;

/** Главное меню практической работы №5. */
public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Выберите пункт: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        GenericsDemo.demonstrateRemoveDuplicates();
                        break;
                    case 2:
                        GenericsDemo.demonstrateLinearSearch();
                        break;
                    case 3:
                        GenericsDemo.demonstrateLargestCircle();
                        break;
                    case 4:
                        GenericsDemo.demonstrateLargestInTwoDimensionalArray();
                        break;
                    case 5:
                        StackDemo.demonstrateArrayStack();
                        break;
                    case 6:
                        StackDemo.runArrayListInheritanceClient(scanner);
                        break;
                    case 7:
                        CloningDemo.runCompositionClient(scanner);
                        break;
                    case 8:
                        CloningDemo.runInheritanceClient(scanner);
                        break;
                    case 9:
                        CloningDemo.demonstrateDeepCopyOfMyStack();
                        break;
                    case 10:
                        CloningDemo.demonstrateHouseCloning();
                        break;
                    case 11:
                        SelfTest.runAll();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Работа программы завершена.");
                        break;
                    default:
                        System.out.println("Нет такого пункта меню. Выберите число от 0 до 11.");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Введите целое число из меню.");
            } catch (RuntimeException ex) {
                System.out.println("Ошибка выполнения: " + ex.getMessage());
            }

            if (running) {
                System.out.println("\nНажмите Enter, чтобы вернуться в меню...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("============================================");
        System.out.println("     ПРАКТИЧЕСКАЯ РАБОТА №5 — JAVA");
        System.out.println("============================================");
        System.out.println("1  — Удаление дубликатов из ArrayList");
        System.out.println("2  — Линейный поиск в массиве");
        System.out.println("3  — Максимальный Circle через Comparable");
        System.out.println("4  — Максимум в двумерном массиве");
        System.out.println("5  — GenericStack на динамическом массиве");
        System.out.println("6  — Стек, наследующий ArrayList (5 строк)");
        System.out.println("7  — MyStack на композиции (5 строк)");
        System.out.println("8  — MyStack на наследовании (5 строк)");
        System.out.println("9  — Глубокая копия списка MyStack");
        System.out.println("10 — Поверхностное и глубокое клонирование House");
        System.out.println("11 — Автоматическая проверка всех решений");
        System.out.println("0  — Выход");
    }
}
