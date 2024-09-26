package BetterCodeAnswer.Medium.Class;

import java.util.Arrays;
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

    class Node {
        int start;
        int end;
        Node left,right;

        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public MyCalendar() {}
    
    // 12ms 45.61MB
    public boolean book(int start, int end) {
        if(root == null){
            root = new Node(start,end);
            return true;
        }
        Node curr = root;
        while(curr != null){
            if(end <= curr.start){
                if(curr.left == null){
                    curr.left = new Node(start,end);
                    return true;
                }
                curr = curr.left;
            }
            else if(start >= curr.end){
                if(curr.right == null){
                    curr.right = new Node(start,end);
                    return true;
                }
                curr = curr.right;
            }
            else return false;
        }
        return false;
    }
}

// 17ms 45.53MB
class MyCalendar1 {
    // using TreeMap : end -> start

    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar1() {
        map.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean book(int start, int end) {
        // get an (higher)entry that ends just after current
        var e = map.higherEntry(start);
        // if start time of higher entry is less than end time of current
        // since current has to start before higher enry,
        // so if above condition is true, it means the current event will end before higher entry
        // event will start, so we can schedule it
        if(end <= e.getValue()){
            map.put(end, start);
            return true;
        }
        return false;
    }
}