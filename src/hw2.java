import java.util.ArrayList;
import java.util.Arrays;

public class hw2 {
    public static void main(String[] args) {
        //1. Напишите программу, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
        task1();

    }
    static void task1 () {
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
}
