package BetterCodeAnswer.Easy.String;

public class RansomNote {
    public static void main(String[] args) {
        String[][] tests = {
            {"",""}
        };

        for (String[] test : tests) {
            String ransomNote = test[0],
                   magazine = test[1];

            System.out.println(new RansomNote_Solution().canConstruct(ransomNote, magazine));
        }
    } 
}

// 1 ms 44.3 MB
class RansomNote_Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];

        for(char c : ransomNote.toCharArray()) {
            int mod = c%26;
            int index = magazine.indexOf(c, chars[mod]);

            if(index == -1){
                return false;
            }

            chars[mod] = index+1;
        }

        return true;
    }
}