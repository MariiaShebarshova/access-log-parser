import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Integer> grades;

    // Конструктор с именем и опциональным набором оценок
    public Student(String name, int... grades) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым.");
        }
        this.name = name;
        this.grades = new ArrayList<>();
        for (int grade : grades) {
            addGrade(grade);
        }
    }

    // Метод для получения имени студента
    public String getName() {
        return name;
    }

    // Метод для получения списка оценок
    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    // Метод для добавления оценки
    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5.");
        }
        grades.add(grade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Имя: ").append(name).append(" [");
        for (int i = 0; i < grades.size(); i++) {
            sb.append(grades.get(i));
            if (i < grades.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Student student1 = new Student("Иван", 4, 5, 3);
        Student student2 = new Student("Мария");

        System.out.println(student1);
        System.out.println(student2);

        student1.addGrade(5);
        student2.addGrade(4);
        student2.addGrade(3);


        System.out.println(student1);
        System.out.println(student2);

        // Попытка добавить некорректную оценку
        try {
            student1.addGrade(6);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Получаем список оценок
        List<Integer> grades1 = student1.getGrades();
        List<Integer> grades2 = student2.getGrades();

        System.out.println("Оценки Ивана: " + grades1);
        System.out.println("Оценки Марии: " + grades2);
    }
}