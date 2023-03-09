package Homework2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {

    /*
     *  Калькулятор
     *  + добавить логирование.
     * */
    public static void main(String[] args) throws IOException {
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double numFirst = scanIn.nextDouble();
        System.out.print("Введите второе число: ");
        double numSecond = scanIn.nextDouble();
        System.out.print("Задайте действие: ");
        scanIn.nextLine();
        String operation = scanIn.nextLine();
        scanIn.close();

        calculus(numFirst,
                numSecond,
                operation);

    }
    public static double pow(double value, double pow) {
        if (pow == 1) {
            return value;
        } else {
            return value * pow(value, pow - 1);
        }
    }

    public static void calculus(double number1, double number2, String str) throws IOException{
        Logger logger = Logger.getLogger(Task4.class.getName());
        FileHandler fh = new FileHandler("calculate_log.txt", true);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
        double result;
        switch (str) {
            case "+" -> {
                logger.info("addition".formatted(str));
                result = number1 + number2;
                logger.info("first number: %s".formatted(String.valueOf(number1)));
                logger.info("second number: %s".formatted(String.valueOf(number2)));
                logger.info("the_result_of_addition = %s".formatted(String.valueOf(result)));
                System.out.printf("Результат = %.2f\n", result);
            }
            case "-" -> {
                logger.info("subtraction".formatted(str));
                result = number1 - number2;
                logger.info("first number: %s".formatted(String.valueOf(number1)));
                logger.info("second number: %s".formatted(String.valueOf(number2)));
                logger.info("the_result_of_subtraction = %s".formatted(String.valueOf(result)));
                System.out.printf("Результат = %.2f\n", result);
            }
            case "*" -> {
                logger.info("multiplication".formatted(str));
                result = number1 * number2;
                logger.info("first number: %s".formatted(String.valueOf(number1)));
                logger.info("second number: %s".formatted(String.valueOf(number2)));
                logger.info("the_result_of_multiplication = %s".formatted(String.valueOf(result)));
                System.out.printf("Результат = %.2f\n", result);
            }
            case "**" -> {
                logger.info("exponentiation".formatted(str));
                result = pow(number1, number2);
                logger.info("first number: %s".formatted(String.valueOf(number1)));
                logger.info("second number: %s".formatted(String.valueOf(number2)));
                logger.info("the_result_of_exponentiation = %s".formatted(String.valueOf(result)));
                System.out.printf("Результат = %.2f\n", result);
            }
            case "/" -> {
                if (number2 == 0) {
                    System.out.println("Деление на ноль!");
                    logger.warning("division by zero");
                }
                else {
                    logger.info("division".formatted(str));
                    result = number1 / number2;
                    logger.info("first number: %s".formatted(String.valueOf(number1)));
                    logger.info("second number: %s".formatted(String.valueOf(number2)));
                    logger.info("the_result_of_division = %s".formatted(String.valueOf(result)));
                    System.out.printf("Результат = %.2f\n", result);
                }
            }
            default -> {
                System.out.println("Ошибка при вводе");
                logger.warning("input error");
            }
        }
    }

}
