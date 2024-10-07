import java.util.Random;

public class ProgressionGame implements Game {
    private int[] progression;
    private int missingIndex;
    private int correctAnswer;

    @Override
    public String getDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    public String generateQuestion() {
        Random random = new Random();
        int length = random.nextInt(6) + 5;  // Прогрессия от 5 до 10 элементов
        int start = random.nextInt(10) + 1;
        int ratio = random.nextInt(5) + 1;

        progression = new int[length];
        progression[0] = start;
        for (int i = 1; i < length; i++) {
            progression[i] = progression[i - 1] * ratio;
        }

        missingIndex = random.nextInt(length);
        correctAnswer = progression[missingIndex];
        progression[missingIndex] = -1;

        StringBuilder question = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (progression[i] == -1) {
                question.append(".. ");
            } else {
                question.append(progression[i]).append(" ");
            }
        }
        return question.toString().trim();
    }

    @Override
    public boolean isCorrectAnswer(String answer) {
        try {
            int userAnswer = Integer.parseInt(answer);
            return userAnswer == correctAnswer;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
}
