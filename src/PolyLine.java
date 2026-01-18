class PolyLine implements Cloneable {
    Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }

    public double length() {
        if (points == null || points.length < 2) {
            return 0.0;
        }

        double sum = 0.0;
        for (int i = 1; i < points.length; i++) {
            double len1 = points[i].x - points[i - 1].x;
            double len2 = points[i].y - points[i - 1].y;
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на null
        if (obj == null) {
            return false;
        }

        // 2. Проверка на идентичность объектов
        if (this == obj) {
            return true;
        }

        // 3. Проверка типа
        if (!(obj instanceof PolyLine)) {
            return false;
        }

        PolyLine other = (PolyLine) obj;

        // 4. Проверка на null обоих массивов
        if (this.points == null && other.points == null) {
            return true;
        }
        if (this.points == null || other.points == null) {
            return false;
        }

        // 5. Проверка длины массивов
        if (this.points.length != other.points.length) {
            return false;
        }

        // 6. Поэлементное сравнение точек
        for (int i = 0; i < this.points.length; i++) {
            if (this.points[i] == null) {
                if (other.points[i] != null) {
                    return false;
                }
            } else {
                if (!this.points[i].equals(other.points[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        if (points == null) {
            return 0;
        }
        int result = 1;
        for (Point point : points) {
            result = 31 * result + (point == null ? 0 : point.hashCode());
        }
        return result;
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 0);

        PolyLine poly1 = new PolyLine(p1, p2, p3);
        PolyLine poly2 = new PolyLine(p1, p2, p3);

        System.out.println("poly1.equals(poly2): " + poly1.equals(poly2)); // true

        Point p4 = new Point(3, 3);
        PolyLine poly3 = new PolyLine(p1, p4);

        System.out.println("poly1.equals(poly3): " + poly1.equals(poly3)); // false

        System.out.println("Длина poly1: " + poly1.length());
    }
}