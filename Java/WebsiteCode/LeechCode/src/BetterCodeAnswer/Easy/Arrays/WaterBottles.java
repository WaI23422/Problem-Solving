package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/water-bottles/">1518. Water Bottles</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>numBottles</code> water bottles that are initially full of water. You can exchange <code>numExchange</code> empty water bottles from the market with one full water bottle.</p>
 * 
 * <p>The operation of drinking a full water bottle turns it into an empty bottle.</p>
 * 
 * <p>Given the two integers <code>numBottles</code> and <code>numExchange</code>, return <em>the <strong>maximum</strong> number of water bottles you can drink</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/07/01/sample_1_1875.png" style="width: 500px; height: 245px;">
 * <pre><strong>Input:</strong> numBottles = 9, numExchange = 3
 * <strong>Output:</strong> 13
 * <strong>Explanation:</strong> You can exchange 3 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 9 + 3 + 1 = 13.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/07/01/sample_2_1875.png" style="width: 500px; height: 183px;">
 * <pre><strong>Input:</strong> numBottles = 15, numExchange = 4
 * <strong>Output:</strong> 19
 * <strong>Explanation:</strong> You can exchange 4 empty bottles to get 1 full water bottle. 
 * Number of water bottles you can drink: 15 + 3 + 1 = 19.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= numBottles &lt;= 100</code></li>
 * 	<li><code>2 &lt;= numExchange &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class WaterBottles {
    public static void main(String[] args) {
        int[][] tests = {
            {15,8},
            {8,3},
            {9,3},
        };       
        
        for (int[] test : tests) {
            int numBottles = test[0],
                numExchange = test[1];

            System.out.println(new WaterBottles_Solution().numWaterBottles(numBottles, numExchange));
        }
    }
}

// 0 ms 39.9 MB
class WaterBottles_Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while(numBottles>=numExchange) {
            count+=numBottles/numExchange;
            numBottles = (numBottles%numExchange)+(numBottles/numExchange);
        }
        
        return count;
    }
}