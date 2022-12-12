import java.util.ArrayList;
import java.util.Arrays;

public class hw2 {
    public static void main(String[] args) {
        //1. Напишите программу, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
        task1();
        //2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга.
        task2();

    }
    static void task1 () {
        System.out.println("Задача 1");
        String stringFirst = "строка тут";
        String stringSecond = "Вторая строка тут";
        System.out.println("Ищем наименьшее окно в строке '" + stringSecond + "', содержащее все символы строки '" + stringFirst + "'.");
        String[] arrayFirst = stringFirst.split("");
        ArrayList<String> aListFirst = new ArrayList<String>();
        for(int i=0; i < arrayFirst.length; i++){
            if( !aListFirst.contains(arrayFirst[i]) ){
                aListFirst.add(arrayFirst[i]);
            }
        }
        String[] arrayFirstUnique = aListFirst.toArray( new String[aListFirst.size()] );
        System.out.println("Символы строки '" + stringFirst + "' следующие: " + Arrays.toString(arrayFirstUnique));

        String result = stringSecond;
        String rightReduce = null;
        String leftReduce = null;
        for(int i=0; i < stringSecond.length(); i++){
            rightReduce = result.substring(0, result.length()-i);
            boolean allLettersCheck = true;
            for (int j =0; j < arrayFirstUnique.length; j++) {
                if(rightReduce.contains(arrayFirstUnique[j])) {
                } else {
                    allLettersCheck = false;
                    break;
                }
            }
            if(allLettersCheck == false) {
                result = result.substring(0, result.length()-i + 1);
                break;
            }
        }
        for(int i=0; i < stringSecond.length(); i++){
            leftReduce = result.substring(0+i);
            boolean allLettersCheck = true;
            for (int j =0; j < arrayFirstUnique.length; j++) {
                if(leftReduce.contains(arrayFirstUnique[j])) {
                } else {
                    allLettersCheck = false;
                    break;
                }
            }
            if(allLettersCheck == false) {
                result = result.substring(0+i-1);
                break;
            }
        }
        System.out.println("Наименьшее окно в строке '" + stringSecond + "' следующее: '" + result + "'.");
    }
    static void task2 () {
        System.out.println("\nЗадача 2");
        StringBuilder stringForward = new StringBuilder("как ротор ни крути");
        String stringBackward = "итурк ин ротор как";
        String reverseString = new String(stringForward.reverse().toString());
        String result = new String(reverseString.equals(stringBackward) ? "является" : "не является");
        System.out.println("'" + stringForward.reverse() + "' " + result + " вращением '" + stringBackward + "'");
    }
}
