import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Main {
   static String[] measures = new String [] {"B", "KB", "MB", "GB", "TB", "PB", "EB"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое положительное число не превышающее 2^63 ");
        String byteInput = sc.nextLine();
        printBytes(byteInput);

    }
    private static void printBytes(String byteInput){
        String pattern = "(^\\s*$)|(\\D+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(byteInput);
        if ( !m.find() && ( new BigDecimal(byteInput).compareTo(new BigDecimal(Long.MAX_VALUE)) <= 0 ) ) {
            float value = Long.parseLong(byteInput);
            for (int i = 0; i <= measures.length; i++) {
                if ((value < 1024) && (value >= 0)) {
                    String result = String.format("%.1f", value).replace(",", ".");
                    System.out.println(result + " " + measures[i]);
                    break;
                }
                value /= 1024;
            }
        }
        else {
            System.out.println("Ошибка входных данных, введите верные входные данные");
        }
    }
}
