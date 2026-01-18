import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Statistics {
    // Поля для хранения накопленных данных
    private long totalVisits = 0;           // Всего посещений (не ботов)
    private long errorCount = 0;             // Количество ошибочных ответов (4xx, 5xx)
    private Set<String> uniqueIps = new HashSet<>(); // Уникальные IP реальных пользователей
    private LocalDateTime firstTimestamp = null;  // Первая запись лога
    private LocalDateTime lastTimestamp = null;   // Последняя запись лога

    /**
     * Добавляет запись лога для анализа
     * @param ip IP-адрес клиента
     * @param timestamp Время запроса
     * @param userAgent Описание клиента (User-Agent)
     * @param responseCode Код ответа сервера
     */
    public void addEntry(String ip, LocalDateTime timestamp, String userAgent, int responseCode) {
        // Обновляем временные границы
        if (firstTimestamp == null || timestamp.isBefore(firstTimestamp)) {
            firstTimestamp = timestamp;
        }
        if (lastTimestamp == null || timestamp.isAfter(lastTimestamp)) {
            lastTimestamp = timestamp;
        }

        // Проверяем, не бот ли это
        if (userAgent != null && userAgent.toLowerCase().contains("bot")) {
            return; // Пропускаем ботов
        }

        // Учитываем посещение реального пользователя
        totalVisits++;
        uniqueIps.add(ip);

        // Проверяем код ответа на ошибку (4xx или 5xx)
        if (responseCode >= 400 && responseCode < 600) {
            errorCount++;
        }
    }

    /**
     * Рассчитывает среднее количество посещений сайта за час (только для реальных пользователей)
     * @return Среднее количество посещений в час
     */
    public double getAverageVisitsPerHour() {
        if (firstTimestamp == null || lastTimestamp == null) {
            return 0.0;
        }

        long hours = java.time.Duration.between(firstTimestamp, lastTimestamp).toHours();
        if (hours == 0) {
            hours = 1; // Чтобы избежать деления на 0
        }

        return (double) totalVisits / hours;
    }

    /**
     * Рассчитывает среднее количество ошибочных запросов в час
     * @return Среднее количество ошибок в час
     */
    public double getAverageErrorsPerHour() {
        if (firstTimestamp == null || lastTimestamp == null) {
            return 0.0;
        }

        long hours = java.time.Duration.between(firstTimestamp, lastTimestamp).toHours();
        if (hours == 0) {
            hours = 1; // Чтобы избежать деления на 0
        }

        return (double) errorCount / hours;
    }

    /**
     * Рассчитывает среднюю посещаемость одним пользователем (сколько раз в среднем заходит один пользователь)
     * @return Средняя посещаемость на одного пользователя
     */
    public double getAverageVisitsPerUser() {
        if (uniqueIps.isEmpty()) {
            return 0.0;
        }

        return (double) totalVisits / uniqueIps.size();
    }
}