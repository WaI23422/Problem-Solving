package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-square-sum-triples/">1925. Count Square Sum Triples</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>square triple</strong> <code>(a,b,c)</code> is a triple where <code>a</code>, <code>b</code>, and <code>c</code> are <strong>integers</strong> and <code>a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup></code>.</p>
 * 
 * <p>Given an integer <code>n</code>, return <em>the number of <strong>square triples</strong> such that </em><code>1 &lt;= a, b, c &lt;= n</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 5
 * <strong>Output:</strong> 2
 * <strong>Explanation</strong>: The square triples are (3,4,5) and (4,3,5).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 10
 * <strong>Output:</strong> 4
 * <strong>Explanation</strong>: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 250</code></li>
 * </ul>
 * </div>
 */
public class CountSquareSumTriples {
    public static void main(String[] args) {
        int[] tests = {
            5,
            10
        };

        for (int n : tests) {
            System.out.println(new CountSquareSumTriples_Solution().countTriples(n));
        }
    }
}

// 0ms 40.06MB
class CountSquareSumTriples_Solution {
    public int countTriples(int n) {
        int r = 0;
        int x = (int)Math.sqrt(n);
        for (int i = 2; i <= x; i++){
            int mSquare = i * i;
            for (int j = 1; j < i; j++){
                if (i % 2 + j % 2 == 1 && gcd(i, j) == 1){
                    int c = mSquare + j * j;
                    if (c <= n){
                        r = r + (n / c);
                    }
                }
            }
        }
        return r * 2;
    }

    private int gcd(int a, int b){
        while (b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}