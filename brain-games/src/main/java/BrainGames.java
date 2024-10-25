import java.util.Scanner;

public class BrainGames {
    public static void main(String[] args) {
        String name = Cli.greet();  // Приветствие и запрос имени пользователя

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a game: 1 - LCM, 2 - Progression, 0 - Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Engine.runGame(new LcmGame(), name);
                    break;
                case 2:
                    Engine.runGame(new ProgressionGame(), name);
                    break;
                case 0:
                    System.out.println("Goodbye, " + name + "!");
                    return;  // Завершение программы
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
