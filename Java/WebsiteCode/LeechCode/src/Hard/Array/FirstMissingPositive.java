package Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/first-missing-positive/">41.First Missing Positive</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an unsorted integer array <code>nums</code>. Return the <em>smallest positive integer</em> that is <em>not present</em> in <code>nums</code>.</p>

<p>You must implement an algorithm that runs in <code>O(n)</code> time and uses <code>O(1)</code> auxiliary space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,0]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The numbers in the range [1,2] are all in the array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,4,-1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 1 is in the array but 2 is missing.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [7,8,9,11,12]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The smallest positive integer 1 is missing.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>
</div>
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,0},
            {3,4,-1,1},
            {7,8,9,11,12}
        };

        for (int[] nums : tests) {
            System.out.println(new FirstMissingPositive_Solution().firstMissingPositive(nums));
        }
    }
}

// 3 ms 55.3 MB
class FirstMissingPositive_Solution {
    public int firstMissingPositive(int[] nums) {
        int[] contain = new int[100_001];
        
        for (int num : nums) {
            if (num < 100001 && num > 0) {contain[num]++;}
        }

        for (int i = 1; i < contain.length; i++) {
            if (contain[i] == 0) {
                return i;
            }
        }

        return 100001;
    }
}
