public class SumCalculator {
    
    public static double sumAll(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        double result1 = sumAll(2, 3.5, 2.3);
        double result2 = sumAll(3.6, 49.12, 3, 3.2);
        double result3 = sumAll(1.3, 1);

        System.out.println("Результат первого сложения: " + result1);
        System.out.println("Результат второго сложения: " + result2);
        System.out.println("Результат третьего сложения: " + result3);
    }
}