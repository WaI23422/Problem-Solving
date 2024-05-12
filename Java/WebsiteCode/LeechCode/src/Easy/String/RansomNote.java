package Easy.String;

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

// 1 ms 44.5 MB
class RansomNote_Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {return false;}
        
        int[] numberCharMagazine = new int[26];
        char[] magazineChars = magazine.toCharArray(),
               ransomNoteChars = ransomNote.toCharArray(); 

        for (char c : magazineChars) {
            numberCharMagazine[c-'a']++;
        }

        for (char c : ransomNoteChars) {
            int remain = --numberCharMagazine[c-'a'];

            if (remain < 0) {return false;}
        }

        return true;
    }
}