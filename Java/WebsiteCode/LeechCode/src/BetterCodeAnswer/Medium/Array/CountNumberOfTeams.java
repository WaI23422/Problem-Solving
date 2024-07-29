package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-number-of-teams/">1395. Count Number of Teams</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> soldiers standing in a line. Each soldier is assigned a <strong>unique</strong> <code>rating</code> value.</p>
 * 
 * <p>You have to form a team of 3 soldiers amongst them under the following rules:</p>
 * 
 * <ul>
 * 	<li>Choose 3 soldiers with index (<code>i</code>, <code>j</code>, <code>k</code>) with rating (<code>rating[i]</code>, <code>rating[j]</code>, <code>rating[k]</code>).</li>
 * 	<li>A team is valid if: (<code>rating[i] &lt; rating[j] &lt; rating[k]</code>) or (<code>rating[i] &gt; rating[j] &gt; rating[k]</code>) where (<code>0 &lt;= i &lt; j &lt; k &lt; n</code>).</li>
 * </ul>
 * 
 * <p>Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> rating = [2,5,3,4,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> rating = [2,1,3]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> We can't form any team given the conditions.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> rating = [1,2,3,4]
 * <strong>Output:</strong> 4
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == rating.length</code></li>
 * 	<li><code>3 &lt;= n &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= rating[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li>All the integers in <code>rating</code> are <strong>unique</strong>.</li>
 * </ul>
 * </div>
 */
public class CountNumberOfTeams {
    public static void main(String[] args) {
        int[][] tests = {
            {2,5,3,4,1}
        };

        for (int[] rating : tests) {
            System.out.println(new CountNumberOfTeams_Solution().numTeams(rating));
        }
    }
}

// 5ms 44.78MB
class CountNumberOfTeams_Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        if (n < 3) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : rating) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int[] leftTree = new int[max - min + 2];
        int[] rightTree = new int[max - min + 2];
        
        for (int num : rating) {
            update(rightTree, num - min, 1);
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            update(rightTree, rating[i] - min, -1);
            
            int lessLeft = query(leftTree, rating[i] - min - 1);
            int greaterLeft = i - lessLeft;
            
            int lessRight = query(rightTree, rating[i] - min - 1);
            int greaterRight = (n - i - 1) - lessRight;
            
            count += lessLeft * greaterRight + greaterLeft * lessRight;
            
            update(leftTree, rating[i] - min, 1);
        }
        
        return count;
    }

    private void update(int[] tree, int index, int value) {
        index++;
        while (index < tree.length) {
            tree[index] += value;
            index += index & (-index);
        }
    }

    private int query(int[] tree, int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }
}

// 33ms 42.27MB
class CountNumberOfTeams_Solution2 {
    public int numTeams(int[] rating) {
        int n = rating.length, l;
        int pre[] = new int[n], post[] = new int[n];
        for(int i = 1; i < n; i++){
            l = 0;
            for(int j = 0; j < i; j++) if(rating[i] > rating[j]) l++;
            pre[i] = l;
        }

        for(int i = n - 2; i >= 0; i--){
            l = 0;
            for(int j = i + 1; j < n; j++) if(rating[i] > rating[j]) l++;
            post[i] = l;
        }

        l = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < n-1; j++){
                if(j < i && rating[j] < rating[i]) l += pre[j];
                else if(j > i && rating[j] < rating[i]) l += post[j];
            }
        }

        return l;
    }
}