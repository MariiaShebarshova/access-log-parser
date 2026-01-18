//public class Square {
//    private Point topLeft;
//    private int sideLength;
//
//    // Конструктор с координатами x и y левого верхнего угла и размером стороны
//    public Square(int x, int y, int sideLength) {
//        this.topLeft = new Point(x, y);
//        setSideLength(sideLength);
//    }
//
//    // Конструктор с использованием объекта Point и размером стороны
//    public Square(Point topLeft, int sideLength) {
//        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
//        setSideLength(sideLength);
//    }
//
//    public int getX() {
//        return topLeft.getX();
//    }
//
//    public void setX(int x) {
//        topLeft.setX(x);
//    }
//
//    public int getY() {
//        return topLeft.getY();
//    }
//
//    public void setY(int y) {
//        topLeft.setY(y);
//    }
//
//    public int getSideLength() {
//        return sideLength;
//    }
//
//    public void setSideLength(int sideLength) {
//        if (sideLength <= 0) {
//            throw new IllegalArgumentException("Длина стороны должна быть положительной.");
//        }
//        this.sideLength = sideLength;
//    }
//
//    // Метод для получения точки левого верхнего угла
//    public Point getTopLeft() {
//        return new Point(topLeft.getX(), topLeft.getY());
//    }
//
//    // Метод для установки точки левого верхнего угла
//    public void setTopLeft(Point topLeft) {
//        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
//    }
//
//    @Override
//    public String toString() {
//        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
//    }
//
//    public static void main(String[] args) {
//        // Создаем квадраты
//        Square square1 = new Square(1, 2, 5);
//        Square square2 = new Square(new Point(3, 4), 10);
//
//        // Выводим информацию о квадратах
//        System.out.println(square1);
//        System.out.println(square2);
//
//        // Изменяем состояние квадратов
//        square1.setX(10);
//        square1.setY(20);
//        square1.setSideLength(7);
//
//        square2.setTopLeft(new Point(15, 25));
//        square2.setSideLength(15);
//
//        // Выводим информацию о квадратах после изменения
//        System.out.println(square1);
//        System.out.println(square2);
//    }
//}