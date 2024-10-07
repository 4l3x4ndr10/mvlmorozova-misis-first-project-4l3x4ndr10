import java.util.Scanner;

public class Engine {
    public static void runGame(Game game, String playerName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.getDescription());

        for (int i = 0; i < 3; i++) {  // Игровой цикл из 3 вопросов
            String question = game.generateQuestion();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (game.isCorrectAnswer(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + game.getCorrectAnswer() + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
