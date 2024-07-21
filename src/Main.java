import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int command = scanner.nextInt();
            // обработка выбранной команды
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 0) {
                System.out.println("Вы вышли из приложения!");
                return;
            } else {
                System.out.println("Такой команды нет. Пожалуйста, введите корректную команду!");
            }
        }

    }

    static void printMenu() {
        // вывод доступных команд
        System.out.println("Выберите действие:");
        System.out.println("1 - Ввести количество шагов за определенный день;");
        System.out.println("2 - Изменить цель по количеству шагов в день:");
        System.out.println("3 - Напечатать статистику за определенный день:");
        System.out.println("0 - Выйти из приложения:");
    }
}
