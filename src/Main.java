import java.util.*;

public class Main {
    public static void main(String[] args) {

        String choose = "";
        String text;
        String[] delList;
        Scanner scanner = new Scanner(System.in);
        Deals task = new Deals();

        while (!choose.equals("0")) {
            System.out.print("\nВыберите операцию:\n" +
                    "\n" +
                    "0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дела по номеру\n" +
                    "4. Удалить дела по названию\n" +
                    "Ваш выбор: ");
            choose = scanner.nextLine();
            switch (choose){
                case "0":
                    System.out.println("Программа завершена");
                    break;
                case "1":
                    System.out.print("Введите название задачи: ");
                    text = scanner.nextLine();
                    if (task.addDeal(text)){
                        System.out.println("Добавлено!");
                    } else System.out.println("Такая задача уже есть!");
                    break;
                case "3":
                    System.out.print("Введите номера дел для удаления (номера через запятую): ");
                    text = scanner.nextLine();
                    delList = text.split(",");

                    if (task.deleteDealByIndex(delList)) {
                        System.out.println("Удалено!");
                    } else System.out.println("Такой задачи нет!");
                    break;
                case "4":
                    System.out.print("Введите слово для удаления (слова в названиях дел через запятую): ");
                    text = scanner.nextLine();
                    delList = text.split(",");

                    if (task.deleteDealByName(delList)){
                        System.out.println("Удалено!");
                    } else System.out.println("Таких задач нет!");
                    break;
                default:
                    if (!choose.equals("2")) System.out.println("Неправильный ввод!");
            }
            if (!choose.equals("0")) {
                System.out.print("\nВаш список дел:\n");
                System.out.println(task.getDeals());
            }
        }
    }
}
