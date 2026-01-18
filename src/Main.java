import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
        System.out.println("До обнуления: " + cat);

        Cat.nullifyObject(cat);
        System.out.println("После обнуления: " + cat);

        // Пример с другим классом
        Dog dog = new Dog("Rex", 5, Arrays.asList("Bob", "Max"));
        System.out.println("До обнуления: " + dog);

        Cat.nullifyObject(dog);
        System.out.println("После обнуления: " + dog);
    }
}
