package BetterCodeAnswer.Hard.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-atoms/">726. Number of Atoms</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>formula</code> representing a chemical formula, return <em>the count of each atom</em>.</p>
 * 
 * <p>The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.</p>
 * 
 * <p>One or more digits representing that element's count may follow if the count is greater than <code>1</code>. If the count is <code>1</code>, no digits will follow.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"H2O"</code> and <code>"H2O2"</code> are possible, but <code>"H1O2"</code> is impossible.</li>
 * </ul>
 * 
 * <p>Two formulas are concatenated together to produce another formula.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"H2O2He3Mg4"</code> is also a formula.</li>
 * </ul>
 * 
 * <p>A formula placed in parentheses, and a count (optionally added) is also a formula.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"(H2O2)"</code> and <code>"(H2O2)3"</code> are formulas.</li>
 * </ul>
 * 
 * <p>Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than <code>1</code>), followed by the second name (in sorted order), followed by its count (if that count is more than <code>1</code>), and so on.</p>
 * 
 * <p>The test cases are generated so that all the values in the output fit in a <strong>32-bit</strong> integer.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> formula = "H2O"
 * <strong>Output:</strong> "H2O"
 * <strong>Explanation:</strong> The count of elements are {'H': 2, 'O': 1}.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> formula = "Mg(OH)2"
 * <strong>Output:</strong> "H2MgO2"
 * <strong>Explanation:</strong> The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> formula = "K4(ON(SO3)2)2"
 * <strong>Output:</strong> "K4N2O14S4"
 * <strong>Explanation:</strong> The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= formula.length &lt;= 1000</code></li>
 * 	<li><code>formula</code> consists of English letters, digits, <code>'('</code>, and <code>')'</code>.</li>
 * 	<li><code>formula</code> is always valid.</li>
 * </ul>
 * </div>
 */
public class NumberOfAtoms {
    public static void main(String[] args) {
        String[] tests  = {
            "Be32",
            "K4(ON(SO3)2)2Ga4",
            "H2O",
            "Mg(OH)2"
        };

        for (String formula : tests) {
            System.out.println(new NumberOfAtoms_Solution().countOfAtoms(formula));
        }
    }
}

// 11 ms 42.3 MB
class NumberOfAtoms_Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        int[] stack = new int[1000];
        int top = 0, multiplier = 1, freq = 0;
        char[] c = formula.toCharArray();
        for(int i = c.length - 1; i >= 0; i--) {
            if(c[i] >= 'a' && c[i] <= 'z') {
                int end = i--;
                while(i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--;
                String key = new String(c, i, end - i + 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if(c[i] >= 'A' && c[i] <= 'Z') {
                String key = new String(c, i, 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if(c[i] >= '0' && c[i] <= '9') {
                freq = c[i] - '0';
                int p = 10;
                while(i-1 >= 0 && c[i-1] >= '0' && c[i-1] <= '9') {
                    freq += p * (c[--i] - '0');
                    p *= 10;
                }
            } else if(c[i] == ')') {
                stack[top++] = multiplier;
                multiplier *= Math.max(freq, 1);
                freq = 0;
            } else {
                multiplier = stack[--top];
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for(String key: keys) {
            sb.append(key);
            int f = map.get(key);
            if(f > 1) sb.append(f);
        }
        return sb.toString();
    }
}