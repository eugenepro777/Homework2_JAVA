package Homework2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Task1 {

    /*
    * Дана строка sql-запроса "select * from students where ".
    * Сформируйте часть WHERE этого запроса, используя StringBuilder.
    * Данные для фильтрации приведены ниже в виде json строки.
    * Если значение null, то параметр не должен попадать в запрос.
    * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    * */
    public static void main(String[] args) throws Exception{
        String[] list = readFromFile("request.txt");
        System.out.println(list[0]);
        StringBuilder select = isSplitter(list[0]);
        System.out.println(select);
    }

    public static StringBuilder isSplitter(String str) {
        String clearStr = str.replace("{", "").replace("}", "")
                .replace("\"", "");
        System.out.println(clearStr);
        StringBuilder result = new StringBuilder("SELECT * FROM STUDENTS WHERE ");
        String[] newStr = clearStr.split(", ");
        for (int i = 0; i < newStr.length; i++) {
            String[] newData = newStr[i].split(":");
            if (!newData[1].equals("null")) {
                if (i != 0) {
                    result.append(", ").append(newData[0])
                            .append(" = ").append(newData[1]);

                } else {
                    result.append(newData[0]).append(" = ")
                            .append(newData[1]);
                }
            }
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
        br.close();
        String[] dataArray = new String[size];

        int index = 0;
        BufferedReader br1 = new BufferedReader(new FileReader(path));
        while ((str = br1.readLine()) != null) {
            dataArray[index] = str;
            index++;
        }
        br1.close();
        return dataArray;
    }
}
