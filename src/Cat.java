import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cat {
    private static String breed = "Persian"; // порода
    public String name;
    private int age;
    private List<String> friendsName = new ArrayList<>();

    public Cat(String name, int age, List<String> friendsName) {
        this.name = name;
        this.age = age;
        this.friendsName = friendsName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendsName=" + friendsName +
                '}';
    }

    // Универсальный метод для обнуления ссылочных полей объекта
    public static void nullifyObject(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return;
        }

        Class<?> clazz = obj.getClass();

        // Получаем все поля класса (включая приватные)
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            // Пропускаем примитивные типы и статические поля
            if (field.getType().isPrimitive() || field.isSynthetic()) {
                continue;
            }

            // Разрешаем доступ к приватным полям
            field.setAccessible(true);

            // Присваиваем null
            field.set(obj, null);
        }
    }
}