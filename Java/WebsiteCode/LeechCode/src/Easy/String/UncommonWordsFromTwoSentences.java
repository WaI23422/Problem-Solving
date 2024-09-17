package Easy.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/uncommon-words-from-two-sentences/">884. Uncommon Words from Two Sentences</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>sentence</strong> is a string of single-space separated words where each word consists only of lowercase letters.</p>
 * 
 * <p>A word is <strong>uncommon</strong> if it appears exactly once in one of the sentences, and <strong>does not appear</strong> in the other sentence.</p>
 * 
 * <p>Given two <strong>sentences</strong> <code>s1</code> and <code>s2</code>, return <em>a list of all the <strong>uncommon words</strong></em>. You may return the answer in <strong>any order</strong>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s1 = "this apple is sweet", s2 = "this apple is sour"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">["sweet","sour"]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The word <code>"sweet"</code> appears only in <code>s1</code>, while the word <code>"sour"</code> appears only in <code>s2</code>.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s1 = "apple apple", s2 = "banana"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">["banana"]</span></p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s1.length, s2.length &lt;= 200</code></li>
 * 	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters and spaces.</li>
 * 	<li><code>s1</code> and <code>s2</code> do not have leading or trailing spaces.</li>
 * 	<li>All the words in <code>s1</code> and <code>s2</code> are separated by a single space.</li>
 * </ul>
 * </div>
 */
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        String[][] tests = {
            {"this apple is sweet","this apple is sour"},
            {"apple apple","banana"}
        };

        for (String[] test : tests) {
            String s1 = test[0],
                   s2 = test[1];

            System.out.println(Arrays.toString(new UncommonWordsFromTwoSentences_Solution().uncommonFromSentences(s1, s2)));
        }
    }
}

// 2ms 41.88MB
class UncommonWordsFromTwoSentences_Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s1_words[] = s1.split("\s"),
               s2_words[] = s2.split("\s");

        List<String> seen_words = new ArrayList<>(),
                     seen_one = new ArrayList<>();

        for (String str : s1_words) {
            if (!seen_words.contains(str)) {
                seen_words.add(str);
                seen_one.add(str);
            } else {
                if (seen_one.contains(str)) {
                    seen_one.remove(str);
                }
            }
        }

        for (String str : s2_words) {
            if (!seen_words.contains(str)) {
                seen_words.add(str);
                seen_one.add(str);
            } else {
                if (seen_one.contains(str)) {
                    seen_one.remove(str);
                }
            }
        }
        
        String[] ans = new String[seen_one.size()];
        int i = 0;
        for (String str : seen_one) {
            ans[i++] = str;
        }

        return ans;
    }
}