public class Sauce {
    public enum HeatLevel {
        ОЧЕНЬ_ОСТРЫЙ,
        ОСТРЫЙ,
        НЕ_ОСТРЫЙ
    }

    private final String name;
    private final HeatLevel heatLevel;

    /**
     * Конструктор соуса
     * @param name название соуса (не может быть null или пустым)
     * @param heatLevel уровень остроты (должен быть из допустимых значений)
     */
    public Sauce(String name, HeatLevel heatLevel) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название соуса не может быть пустым или null");
        }
        if (heatLevel == null) {
            throw new IllegalArgumentException("Уровень остроты не может быть null");
        }

        this.name = name.trim();
        this.heatLevel = heatLevel;
    }

    /**
     * Возвращает текстовое представление соуса
     * @return строка вида "Соус НАЗВАНИЕ: ОСТРОТА"
     */
    @Override
    public String toString() {
        return "Соус " + name + ": " + heatLevel.name().replace("_", " ").toLowerCase();
    }

    public String getName() {
        return name;
    }

    public HeatLevel getHeatLevel() {
        return heatLevel;
    }

    public static void main(String[] args) {
        Sauce sauce1 = new Sauce("Табаско", Sauce.HeatLevel.ОЧЕНЬ_ОСТРЫЙ);
        Sauce sauce2 = new Sauce("Томатный", Sauce.HeatLevel.НЕ_ОСТРЫЙ);

        System.out.println(sauce1); // Соус Табаско: очень острый
        System.out.println(sauce2); // Соус Томатный: не острый
    }
}