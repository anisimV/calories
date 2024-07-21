class MonthData {

    // Массив для хранения количества шагов за каждый день месяца
    int[] days = new int[30];

    // Метод для вывода количества шагов за каждый день месяца
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            // вывод элементов массива в нужном формате
            System.out.println("День " + (i + 1) + ": " + days[i] + " шагов");
        }
    }

    // Метод для подсчета общего количества шагов за месяц
    int sumStepsFromMonth() {
        int sumSteps = 0; // Переменная для хранения суммы шагов
        for (int i = 0; i < days.length; i++) {
            // подсчёт суммы элементов массива days[]
            sumSteps += days[i];
        }
        return sumSteps; // Возвращаем общую сумму шагов
    }

    // Метод для нахождения максимального количества шагов за один день в месяце
    int maxSteps() {
        int maxSteps = 0; // Переменная для хранения максимального количества шагов
        for (int i = 0; i < days.length; i++) {
            // поиск максимального элемента
            if (days[i] > maxSteps) {
                maxSteps = days[i]; // Обновляем максимальное значение, если нашли большее
            }
        }
        return maxSteps; // Возвращаем максимальное количество шагов
    }

    // Метод для нахождения самой длинной серии дней, в которых количество шагов было не менее заданной цели
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0; // Переменная для хранения текущей серии
        int finalSeries = 0; // Переменная для хранения максимальной серии

        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии
            if (days[i] >= goalByStepsPerDay) {
                // увеличиваем текущую серию
                currentSeries++;
            } else {
                // сбрасываем текущую серию, если цель не достигнута
                currentSeries = 0;
            }

            if (currentSeries > finalSeries) {
                // обновляем максимальную серию, если текущая больше
                finalSeries = currentSeries;
            }
        }
        return finalSeries; // Возвращаем максимальную серию
    }
}
