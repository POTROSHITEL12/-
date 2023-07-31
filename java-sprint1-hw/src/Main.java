import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать!Выберите команду");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();// здесь будет логика команды 1
            } else if (i == 2) {
                stepTracker.changeStepGoal();  // здесь будет логика команды 2
            } else if (i == 3) {
                stepTracker.printStatistic(); // здесь будет логика команды 3
            } else if (i == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    static void printMenu() {
        System.out.println("1-Ввод номера месяца");
        System.out.println("2-Ввод цели");
        System.out.println("3-Печать статистики");
        System.out.println("4-Выход из программы");// Вывод доступных команд
    }
}