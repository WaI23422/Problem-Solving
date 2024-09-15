package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-longest-substring-containing-vowels-in-even-counts/">1371. Find the Longest Substring Containing Vowels in Even Counts</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the string <code>s</code>, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "eleetminicoworoep"
 * <strong>Output:</strong> 13
 * <strong>Explanation: </strong>The longest substring is "leetminicowor" which contains two each of the vowels: <strong>e</strong>, <strong>i</strong> and <strong>o</strong> and zero of the vowels: <strong>a</strong> and <strong>u</strong>.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "leetcodeisgreat"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The longest substring is "leetc" which contains two e's.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "bcbcbc"
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> In this case, the given string "bcbcbc" is the longest because all vowels: <strong>a</strong>, <strong>e</strong>, <strong>i</strong>, <strong>o</strong> and <strong>u</strong> appear zero times.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 5 x 10^5</code></li>
 * 	<li><code>s</code>&nbsp;contains only lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public static void main(String[] args) {
        String[] tests = {
            "id",
            "leetcodeisgreat",
            "eleetminicoworoep"
        };

        for (String s : tests) {
            System.out.println(new FindTheLongestSubstringContainingVowelsInEvenCounts_Solution().findTheLongestSubstring(s));
        }
    }   
}

// 10ms 45.20MB
class FindTheLongestSubstringContainingVowelsInEvenCounts_Solution {

    public int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        int[] mp = new int[32];
        for (int i = 0; i < 32; i++) mp[i] = -1;
        int longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXOR ^= characterMap[s.charAt(i) - 'a'];
            if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - mp[prefixXOR]);
        }
        return longestSubstring;
    }
}