import java.util.Scanner;

class StepTracker {
    // Сканнер для ввода данных с консоли
    Scanner scanner;
    // Массив для хранения данных о шагах за каждый месяц
    MonthData[] monthToData = new MonthData[12];
    // Объект класса Converter для конвертации данных
    Converter converter = new Converter();
    // Целевое количество шагов в день
    int goalByStepsPerDay = 10_000;

    // Конструктор класса StepTracker
    StepTracker(Scanner scan) {
        // Инициализация сканера
        scanner = scan;

        // Инициализация данных для каждого месяца
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    // Метод для добавления нового количества шагов за день
    void addNewNumberStepsPerDay() {
        int monthNumber;
        int dayNumber;
        int stepsCount;

        // Запрашиваем номер месяца и проверяем его корректность
        while (true) {
            System.out.println("Введите номер месяца (от 1 до 12):");
            monthNumber = scanner.nextInt();
            if (monthNumber >= 1 && monthNumber <= 12) {
                break;
            } else {
                System.out.println("Ошибка: введите номер месяца (от 1 до 12)!");
            }
        }

        // Запрашиваем день и проверяем его корректность
        while (true) {
            System.out.println("Введите день от 1 до 30 (включительно):");
            dayNumber = scanner.nextInt();
            if (dayNumber >= 1 && dayNumber <= 30) {
                break;
            } else {
                System.out.println("Ошибка: введите номер дня (от 1 до 30)!");
            }
        }

        // Запрашиваем количество шагов и проверяем его корректность
        while (true) {
            System.out.println("Введите количество шагов:");
            stepsCount = scanner.nextInt();
            if (stepsCount > 0) {
                break;
            } else {
                System.out.println("Ошибка: количество шагов должно быть положительным числом!");
            }
        }

        // Получаем соответствующий объект MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1];
        // Сохраняем полученные данные
        monthData.days[dayNumber - 1] = stepsCount;
        System.out.println("Количество шагов сохранено!");
    }

    // Метод для изменения целевого количества шагов в день
    void changeStepGoal() {
        int newGoalSteps;

        // Запрашиваем новое целевое количество шагов и проверяем его корректность
        while (true) {
            System.out.println("Введите новую цель по количеству шагов за день:");
            newGoalSteps = scanner.nextInt();

            if (newGoalSteps <= 0) {
                System.out.println("Ошибка: количество шагов должно быть положительным числом!");
            } else {
                break;
            }
        }

        // Изменяем цель шагов на день
        goalByStepsPerDay = newGoalSteps;
        System.out.println("Цель шагов на день изменена на " + newGoalSteps + "!");
    }

    // Метод для вывода статистики за выбранный месяц
    void printStatistic() {
        int monthNumber;

        // Запрашиваем номер месяца и проверяем его корректность
        while (true) {
            System.out.println("Введите номер месяца (от 1 до 12):");
            monthNumber = scanner.nextInt();

            if (monthNumber >= 1 && monthNumber <= 12) {
                break;
            } else {
                System.out.println("Ошибка: введите номер месяца (от 1 до 12)!");
            }
        }

        // Получаем данные за выбранный месяц
        MonthData monthData = monthToData[monthNumber - 1];
        // Сумма шагов за месяц
        int sumSteps = monthData.sumStepsFromMonth();
        // Максимальное количество шагов в месяце
        int maxSteps = monthData.maxSteps();
        // Среднее количество шагов за день
        double averageSteps = (double) sumSteps / monthData.days.length;
        // Пройденная дистанция в километрах
        double distance = converter.convertToKm(sumSteps);
        // Сожженные калории
        int caloriesBurned = converter.convertStepsToKilocalories(sumSteps);
        // Лучшая серия дней, в которых цель по шагам была достигнута
        int bestSeries = monthData.bestSeries(goalByStepsPerDay);

        // Выводим результаты
        System.out.println("Количество шагов по дням:");
        monthData.printDaysAndStepsFromMonth();
        // Дополнительный перенос строки
        System.out.println();
        System.out.println("Общее количество шагов за месяц: " + sumSteps + ".");
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps + ".");
        System.out.println("Среднее количество шагов за месяц: " + averageSteps + ".");
        System.out.println("Пройденная дистанция: " + distance + " км.");
        System.out.println("Количество сожженных килокалорий: " + caloriesBurned + ".");
        System.out.println("Лучшая серия: " + bestSeries + " дней.");
        // Дополнительный перенос строки
        System.out.println();
    }
}
