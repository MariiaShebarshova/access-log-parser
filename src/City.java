import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> paths;

    // Конструктор с названием города
    public City(String name) {
        this.name = name;
        this.paths = new HashMap<>();
    }

    // Конструктор с названием города и набором путей
    public City(String name, Map<City, Integer> paths) {
        this.name = name;
        this.paths = new HashMap<>(paths);
    }

    // Метод для добавления пути к другому городу
    public void addPath(City city, int cost) {
        paths.put(city, cost);
    }

    // Метод для добавления пути к другому городу
    public void addPath(Path path) {
        paths.put(path.getCity(), path.getCost());
    }

    // Метод для получения названия города
    public String getName() {
        return name;
    }

    // Метод для получения списка путей
    public Map<City, Integer> getPaths() {
        return new HashMap<>(paths);
    }

    // Метод для путешествия по городам
    public City travelBy(int n) {
        City currentCity = this;
        for (int i = 0; i < n && !currentCity.getPaths().isEmpty(); i++) {
            // первый город из списка путей
            currentCity = currentCity.getPaths().keySet().iterator().next();
        }
        return currentCity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " [");
        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            sb.append(entry.getKey().getName()).append(":").append(entry.getValue()).append(", ");
        }
        if (!paths.isEmpty()) {
            sb.setLength(sb.length() - 2); // Убираем последнюю запятую и пробел
        }
        sb.append("]");
        return sb.toString();
    }

    // Внутренний класс для представления пути
    public static class Path {
        private City city;
        private int cost;

        public Path(City city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        public City getCity() {
            return city;
        }

        public int getCost() {
            return cost;
        }
    }

    public static void main(String[] args) {
        // города
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        // пути между городами
        B.addPath(A, 10);
        B.addPath(C, 15);
        B.addPath(D, 20);
        C.addPath(E, 25);
        D.addPath(F, 30);
        E.addPath(A, 35);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);

        // Тестируем метод travelBy
        System.out.println("Travel from B with 1 step: " + B.travelBy(1).getName()); // Должно быть A или C или D
        System.out.println("Travel from B with 2 steps: " + B.travelBy(2).getName()); // Должно быть A или E или F
        System.out.println("Travel from B with 3 steps: " + B.travelBy(3).getName()); // Должно быть A

        // Настройка городов для достижения A при 3 шагах
        B.addPath(A, 10);
        C.addPath(A, 35);
        D.addPath(A, 40);
        F.addPath(A, 45);


        System.out.println("Travel from B with 3 steps: " + B.travelBy(3).getName()); // Должно быть A
    }
}