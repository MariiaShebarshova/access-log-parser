public class Sum {
    public static void main(String[] args) {
        double sum = 0.0;

        // Проходим по всем аргументам командной строки
        for (String arg : args) {
            try {
                // Преобразуем строку в число и добавляем к сумме
                double number = Double.parseDouble(arg);
                sum += number;
            } catch (NumberFormatException e) {
                // Если преобразование не удалось, считаем значение за 0
                // (просто пропускаем ошибку)
            }
        }

        // Выводим результат в консоль
        System.out.println((long) sum); // Приводим к long для целочисленного вывода
    }
}