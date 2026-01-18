class Point implements Cloneable {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на null
        if (obj == null) {
            return false;
        }

        // 2. Проверка на идентичность объектов (один и тот же экземпляр)
        if (this == obj) {
            return true;
        }

        // 3. Проверка типа: obj должен быть экземпляром Point
        if (!(obj instanceof Point)) {
            return false;
        }

        // 4. Приведение типа и сравнение координат
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Клонирование не поддерживается", e);
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 4);

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        Point p4 = p1.clone();
        System.out.println("Клонированная точка: (" + p4.x + ", " + p4.y + ")"); // (1, 2)
        System.out.println("p1.equals(p4): " + p1.equals(p4)); // true
    }
}