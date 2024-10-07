public interface Game {
    String getDescription();           // Описание игры
    String generateQuestion();         // Генерация вопроса
    boolean isCorrectAnswer(String answer);  // Проверка правильного ответа
    String getCorrectAnswer();         // Получение правильного ответа
}
