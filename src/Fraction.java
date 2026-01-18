public class Fraction extends Number {
    private int num;
    private int denum;

    public Fraction(int num, int denum) {
        if (denum == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.num = num;
        this.denum = denum;
    }

    // Метод для получения целочисленного значения дроби
    @Override
    public int intValue() {
        return (int) (num / (double) denum);
    }

    // Метод для получения значения дроби в виде long
    @Override
    public long longValue() {
        return (long) (num / (double) denum);
    }

    // Метод для получения значения дроби в виде float
    @Override
    public float floatValue() {
        return (float) num / denum;
    }

    // Метод для получения значения дроби в виде double
    @Override
    public double doubleValue() {
        return (double) num / denum;
    }

    // Переопределение метода toString для удобства вывода
    @Override
    public String toString() {
        return num + "/" + denum;
    }

    // Геттеры для числителя и знаменателя
    public int getNum() {
        return num;
    }

    public int getDenum() {
        return denum;
    }

    // Метод для упрощения дроби (необязательно, но полезно)
    public Fraction simplify() {
        int gcd = gcd(num, denum);
        return new Fraction(num / gcd, denum / gcd);
    }

    // Вспомогательный метод для нахождения наибольшего общего делителя
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}