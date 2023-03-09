package Homework2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    /*
    *   Реализуйте алгоритм сортировки пузырьком числового массива,
    * результат после каждой итерации запишите в лог-файл.
     * */
    public static void main(String[] args) throws IOException{

        int[] array = fillArray();
        System.out.println("Исходный массив:");
        printArray(array);
        int[] sortArray = bubbleSort(array);
        System.out.println("Отсортированный массив:");
        printArray(sortArray);

    }

    public static int[] fillArray() {
        System.out.print("Введите количество элементов: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = new int[size];
        int iter;
        for (int i = 0; i < size; i++) {
            iter = i + 1;
            System.out.print("Задайте "+ iter + " элемент массива: ");
            Scanner scanner = new Scanner(System.in);
            array[i] = scanner.nextInt();
        }
        scan.close();
        return array;
    }
    public static int[] bubbleSort(int[] arr) throws IOException {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("iter_log.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.addHandler(fh);
        int iter;
        for (int i = 0; i < arr.length - 1; i++) {
            iter = i + 1;
            String msg = " iteration";
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                logger.info(Arrays.toString(arr));
            }
            logger.info(iter + msg);
        }
        return arr;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
