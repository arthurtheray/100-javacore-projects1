package testings;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        String str = "1+2+3";
//        System.out.println(Arrays.toString(str.split("\\+")));
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            private int count = 0;
//            @Override
//            public void run() {
//                if (count == 3)  {
//                    cancel();
//                    return;
//                }
//                System.out.println("timer runs");
//                System.out.println(scheduledExecutionTime());
//                count++;
//            }
//        };
//        timer.schedule(timerTask, 2000, 2000);
        char[] chars = {'a', 'b', 'c'};
        System.out.println(String.valueOf(chars));
        System.out.println(8 % 7);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }



}
