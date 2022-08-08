import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 08.08.2022
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<String> shoppingList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            int value = 0;
            System.out.println("Выберите операцию: \n1. Добавить\n2. Показать\n3. Удалить");
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value > 3 || value < 1) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод операции. Попробуйте еще раз.");
            }
            switch (value) {
                case 1 -> add();
                case 2 -> preview();
                case 3 -> remove();
            }
        }
    }

    public static void add() {
        System.out.println("Какую покупку вы хотите добавить?");
        shoppingList.add(scanner.nextLine());
        System.out.println("Итого в списке покупок: " + shoppingList.size());
    }

    public static void remove() {
        if (shoppingList.isEmpty()) {
            System.out.println("Список покупок пуст!");
            return;
        }
        preview();
        System.out.println("Какую покупку хотите удалить? Введите номер или название.");
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            if (value > 0 && value < shoppingList.size()) {
                System.out.println(shoppingList.get(value - 1) + " удален из списка");
                shoppingList.remove(value - 1);
            } else {
                System.out.println("Не корректный ввод операции. Попробуйте еще раз.");
            }

        }
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (shoppingList.contains(line)) {
                System.out.println(shoppingList.get(shoppingList.indexOf(line)) + " удален из списка");
                shoppingList.remove(line);
            } else {
                System.out.println("Не корректный ввод операции. Попробуйте еще раз.");
            }
        }
    }

    public static void preview() {
        int count = 1;
        for (String line : shoppingList) {
            System.out.println(count + ". " + line);
            count++;
        }
    }
}
