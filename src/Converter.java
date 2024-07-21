public class Converter {

    // Количество сантиметров в одном шаге
    int centimetersPerStep = 75;
    // Количество калорий, сжигаемых за один шаг
    int caloriesPerStep = 50;
    // Количество сантиметров в одном километре
    int centimetersPerKilometer = 100_000;
    // Количество калорий в одной килокалории
    int caloriesPerKilocalorie = 1_000;

    // Метод для конвертации шагов в километры
    public int convertToKm(int steps) {
        // Переводим шаги в сантиметры и затем делим на количество сантиметров в километре
        return (steps * centimetersPerStep) / centimetersPerKilometer;
    }

    // Метод для конвертации шагов в килокалории
    public int convertStepsToKilocalories(int steps) {
        // Переводим шаги в калории и затем делим на количество калорий в килокалории
        return (steps * caloriesPerStep) / caloriesPerKilocalorie;
    }
}
