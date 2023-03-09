package Homework2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Task3 {
    public static void main(String[] args) throws Exception {
        String[] sourceData = readFromFile("Task3_data.txt");
        for (int i = 0; i < sourceData.length; i++) {
            System.out.println(isPrintFile(sourceData[i]));
        }

    }

    public static StringBuilder isPrintFile(String str) {
        String clearString = str.replace("{", "").replace("}", "")
                .replace("\"", "").replace("[", "")
                .replace("]", "");
        StringBuilder result = new StringBuilder();
        String[] dataArray = clearString.split(",");
        String[] pattern = {"Студент ", " получил ", " по предмету "};
        for (int i = 0; i < dataArray.length; i++) {
            String[] dataSplit = dataArray[i].split(":");
            result.append(pattern[i]).append(dataSplit[1]);
        }
        return result;
    }

    public static String[] readFromFile(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String str;
        int size = 0;
        while ((str = br.readLine()) != null) {
            size++;
        }
        String[] dataArray = new String[size];

        int index = 0;
        BufferedReader br1 = new BufferedReader(new FileReader(path));
        while ((str = br1.readLine()) != null) {
            dataArray[index] = str;
            index++;
        }
        br.close();
        br1.close();
        return dataArray;
    }
}
