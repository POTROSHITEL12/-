import java.util.Scanner;

class StepTracker {
    Converter converter = new Converter();
    MonthData monthData = new MonthData();
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    int goalByStepsPerDay = 10000;
    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int nm = scanner.nextInt();// ввод и проверка номера месяца
        if (nm <= 0 || nm > 12) {
            System.out.println("Номер месяца введен неверно");
            return;
        }

        {
            System.out.println("Введите день от 1 до 30 (включительно)");
            int nd = scanner.nextInt();
            if (nd <= 0 || nd > 30) {
                System.out.println("Номер дня введен неверно");
                return; // ввод и проверка дня
            }
                System.out.println("Введите количество шагов");
                int ns = scanner.nextInt(); // ввод и проверка количества шагов
            if (ns <= 0) {
                System.out.println("Введено отрицательное значение шага");
                return;
                // Получение соответствующего объекта MonthData из массива
            }
                MonthData monthData = monthToData[nm - 1];
                // Сохранение полученных данных
                monthData.days[nd - 1] = ns;
            }
        }

        void changeStepGoal() {
            System.out.println("Введите цель по количеству шагов в день: ");
            int goalSteps = scanner.nextInt();
            if (goalSteps <= 0) {
                System.out.println("Введена некоректная цель,цель не можетбыть меньше или равняться 0");
            } else {
                goalByStepsPerDay = goalSteps;
                System.out.println("Цель успешно сохранена,так держать!");
            }
        }


    void printStatistic() {
        System.out.println("Введите число месяца");
        //Scanner scanner = new Scanner(System.in);
        int nm = scanner.nextInt();
        if (nm <= 0 || nm > 12) {
            System.out.println("Номер месяца введен неверно");
        } else {
            System.out.println("Вот статистика за " + nm + " месяц:");
        }
         monthData = monthToData[nm - 1];
        // получение соответствующего месяца

            int sumSteps = monthData.sumStepsFromMonth();// получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth();// вывод общей статистики по дням
        int maxSteps = monthData.maxSteps();// вывод суммы шагов за месяц
        System.out.println("Максимально пройденное количество шагов за месяц составило " + maxSteps);// вывод максимального пройденного количества шагов за месяц
            // вывод среднего пройденного количества шагов за месяц
        int sum = converter.convertToKm(sumSteps);
        System.out.println("За этот месяц вы прошли " + sum + " километров");// вывод пройденной за месяц дистанции в км
        int answer = converter.convertStepsToKilocalories(sumSteps);
        System.out.println("За этот месяц вы сожгли " + answer + " килокалорий");// вывод количества сожжённых килокалорий за месяц
        int finalSeries = monthData.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия шагов за месяц " + finalSeries);// вывод лучшей серии
            System.out.println(); //дополнительный перенос строки
        }
    }
