public class Department {
    private String name;
    private Employee manager;

    // Конструктор с названием отдела
    public Department(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название отдела не может быть пустым.");
        }
        this.name = name;
    }

    // Геттер для названия отдела
    public String getName() {
        return name;
    }

    // Геттер для начальника отдела
    public Employee getManager() {
        return manager;
    }

    // Сеттер для начальника отдела с проверкой
    public void setManager(Employee manager) {
        if (manager == null) {
            throw new IllegalArgumentException("Начальник отдела не может быть null.");
        }
        if (manager.getDepartment() != this) {
            throw new IllegalArgumentException("Начальник должен работать в этом отделе.");
        }
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Отдел: " + name + ", Начальник: " + (manager != null ? manager.getName() : "Не назначен");
    }
}