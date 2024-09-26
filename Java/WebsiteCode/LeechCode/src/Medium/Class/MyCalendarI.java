package Medium.Class;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyCalendarI {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"MyCalendar", "book", "book", "book"},
                {}, {10, 20}, {15, 25}, {20, 30}
            },
        };

        for (Object[][] test : tests) {
            String[] actions = Arrays.copyOf(test[0], test[0].length, String[].class);
            MyCalendar calendar = new MyCalendar();
            Object[] res = new Object[test[0].length]; 

            for (int i = 0; i < test[0].length; i++) {
                switch (actions[i]) {
                    case "book":
                        res[i] = calendar.book((int) test[i+1][0], (int) test[i+1][1]);        
                        break;
                    default:
                        res[i] = null;
                        break;
                }
            }

            System.out.println(Arrays.toString(res));
        }
    }
}

class MyCalendar {
    // boolean[] days = new boolean[1_000_000_000];
    SortedMap<Integer,Integer> days = new TreeMap<>();

    public MyCalendar() {}
    
    // Memory Limit Exceeded:
    // public boolean book(int start, int end) {
    //     for (int i = start; i < end; i++) {
    //         if (days[i] == true) {return false;}
    //     }
        
    //     Arrays.fill(days, start, end, true);

    //     return true;
    // }

    // 348ms 45.71MB
    public boolean book(int start, int end) {
        if (days.containsKey(start)) {return false;}

        for (Integer day : days.keySet()) {
            if (
                day < start && days.get(day) > start ||
                day > start && end > day
            ) {return false;}
        }

        days.put(start, end);

        return true;
    }
}