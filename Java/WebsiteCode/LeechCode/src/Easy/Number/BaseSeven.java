package Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/base-7/">504. Base 7</a>
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>num</code>, return <em>a string of its <strong>base 7</strong> representation</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> num = 100
 * <strong>Output:</strong> "202"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> num = -7
 * <strong>Output:</strong> "-10"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>-10<sup>7</sup> &lt;= num &lt;= 10<sup>7</sup></code></li>
 * </ul>
 * </div>
 */
public class BaseSeven {
    public static void main(String[] args) {
        int[] tests = {
            100,
            -7
        };

        for (int num : tests) {
            System.out.println(new BaseSeven_Solution().convertToBase7(num));
        }
    }
}

class BaseSeven_Solution {
    public String convertToBase7(int num) {
        StringBuffer base = new StringBuffer();


        return base.toString();
    }
}