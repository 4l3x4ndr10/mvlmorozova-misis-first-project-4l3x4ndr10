import java.util.Random;

public class LcmGame implements Game {
    private int num1;
    private int num2;
    private int num3;
    private int correctAnswer;

    @Override
    public String getDescription() {
        return "Find the smallest common multiple of given numbers.";
    }

    @Override
    public String generateQuestion() {
        Random random = new Random();
        num1 = random.nextInt(100) + 1;
        num2 = random.nextInt(100) + 1;
        num3 = random.nextInt(100) + 1;
        correctAnswer = lcm(num1, lcm(num2, num3));
        return num1 + " " + num2 + " " + num3;
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

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
