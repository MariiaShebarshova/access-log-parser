class Line implements Cloneable {
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
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
        if (!(obj instanceof Line)) {
            return false;
        }

        // 4. Приведение типа и сравнение полей
        Line other = (Line) obj;

        // Сравнение точек: учитываем, что Point уже имеет корректный equals
        return (this.start != null ? this.start.equals(other.start) : other.start == null) &&
                (this.end != null ? this.end.equals(other.end) : other.end == null);
    }

    @Override
    public Line clone() {
        try {
            Line cloned = (Line) super.clone();

            // Глубокое копирование: создаём новые экземпляры Point
            if (this.start != null) {
                cloned.start = this.start.clone();
            }
            if (this.end != null) {
                cloned.end = this.end.clone();
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Клонирование не поддерживается", e);
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);

        Line line1 = new Line(p1, p2);
        Line line2 = line1.clone();

        System.out.println("line1.equals(line2): " + line1.equals(line2)); // true

        // Изменяем оригинал — проверяем, что клон не затронут
        line1.start.x = 10;
        System.out.println("line2.start.x после изменения line1: " + line2.start.x); // 0
    }
}