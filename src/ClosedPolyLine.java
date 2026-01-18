//import java.util.List;
//
//public class ClosedPolyLine extends PolyLine implements Measurable {
//
//    // Конструктор без параметров
//    public ClosedPolyLine() {
//        super();
//    }
//
//    // Конструктор с начальным набором точек
//    public ClosedPolyLine(List<Point> points) {
//        super(points);
//    }
//
//    // Переопределение метода для расчета длины замкнутой ломаной линии
//    @Override
//    public double getLength() {
//        double totalLength = super.getLength();
//        if (!getPoints().isEmpty()) {
//            Point firstPoint = getPoints().get(0);
//            Point lastPoint = getPoints().get(getPoints().size() - 1);
//            totalLength += distance(firstPoint, lastPoint);
//        }
//        return totalLength;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("Замкнутая ломаная линия: ");
//        for (Point point : getPoints()) {
//            sb.append(point).append(" -> ");
//        }
//        if (!getPoints().isEmpty()) {
//            sb.append(getPoints().get(0)); // Добавляем первую точку в конец для замыкания
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        // Создаем замкнутую ломаную линию
//        ClosedPolyLine closedPolyLine = new ClosedPolyLine();
//        closedPolyLine.addPoint(new Point(1, 2));
//        closedPolyLine.addPoint(new Point(4, 6));
//        closedPolyLine.addPoint(new Point(7, 8));
//
//        // Выводим информацию о замкнутой ломаной линии
//        System.out.println(closedPolyLine);
//        System.out.println("Длина замкнутой ломаной линии: " + closedPolyLine.getLength());
//    }
//}
