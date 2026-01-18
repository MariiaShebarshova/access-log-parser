public class Employee {
    private String name;
    private Department department;

    // Конструктор с именем и отделом
    public Employee(String name, Department department) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя сотрудника не может быть пустым.");
        }
        this.name = name;
        setDepartment(department);
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Геттер для отдела
    public Department getDepartment() {
        return department;
    }

    // Сеттер для отдела с проверкой на начальника
    public void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Отдел не может быть null.");
        }
        this.department = department;
        if (department.getManager() == this) {
            department.setManager(this);
        }
    }

    @Override
    public String toString() {
        if (department.getManager() == this) {
            return name + " начальник отдела " + department.getName();
        } else {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getManager().getName();
        }
    }

    public static void main(String[] args) {
        // Создаем отделы
        Department department1 = new Department("Отдел Продаж");
        Department department2 = new Department("Отдел Разработки");

        // Создаем сотрудников
        Employee manager1 = new Employee("Иван", department1);
        Employee employee1 = new Employee("Мария", department1);
        Employee employee2 = new Employee("Петр", department1);

        Employee manager2 = new Employee("Анна", department2);
        Employee employee3 = new Employee("Сергей", department2);
        Employee employee4 = new Employee("Ольга", department2);

        // Устанавливаем начальников отделов
        department1.setManager(manager1);
        department2.setManager(manager2);

        // Выводим информацию о сотрудниках
        System.out.println(manager1);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(manager2);
        System.out.println(employee3);
        System.out.println(employee4);

        // Попытка изменить отдел начальника
        try {
            manager1.setDepartment(department2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Изменяем отдел сотрудника
        employee1.setDepartment(department2);

        // Выводим информацию о сотрудниках после изменения
        System.out.println(manager1);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(manager2);
        System.out.println(employee3);
        System.out.println(employee4);
    }
}
