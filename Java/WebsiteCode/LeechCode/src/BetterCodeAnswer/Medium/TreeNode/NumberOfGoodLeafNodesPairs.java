package BetterCodeAnswer.Medium.TreeNode;

import Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-good-leaf-nodes-pairs/">1530. Number of Good Leaf Nodes Pairs</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given the <code>root</code> of a binary tree and an integer <code>distance</code>. A pair of two different <strong>leaf</strong> nodes of a binary tree is said to be good if the length of <strong>the shortest path</strong> between them is less than or equal to <code>distance</code>.</p>
 * 
 * <p>Return <em>the number of good leaf node pairs</em> in the tree.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/07/09/e1.jpg" style="width: 250px; height: 250px;">
 * <pre><strong>Input:</strong> root = [1,2,3,null,4], distance = 3
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/07/09/e2.jpg" style="width: 250px; height: 182px;">
 * <pre><strong>Input:</strong> root = [1,2,3,4,5,6,7], distance = 3
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The only good pair is [2,5].
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the <code>tree</code> is in the range <code>[1, 2<sup>10</sup>].</code></li>
 * 	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
 * 	<li><code>1 &lt;= distance &lt;= 10</code></li>
 * </ul>
 * </div>
 */
public class NumberOfGoodLeafNodesPairs {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {1,2,3,4,5,6,7},
                {3}
            },
            {
                {1,2,3,null,4},
                {3}
            }
        };

        for (Object[][] test : tests) {
            TreeNode root = TreeNode.addNode(test[0], 0);
            int distance = (int) test[1][0];

            System.out.println(new NumberOfGoodLeafNodesPairs_Solution().countPairs(root, distance));
        }
    }
}

// 1ms 44.80MB
class NumberOfGoodLeafNodesPairs_Solution {
    public int countPairs(TreeNode root, int distance) {
          int[] result= new int[1];
          dfs(root,distance,result);
          return result[0];
      }
      private int[] dfs(TreeNode node,int distance, int[] result){
          if(node==null){
              return new int[distance+1];
          }
          if(node.left==null&&node.right==null){
              int[] leafDistance = new int[distance+1];
              leafDistance[1]=1;
              return leafDistance;
          }
  
          int[] left=dfs(node.left,distance,result);
          int[] right= dfs(node.right,distance,result);
  
          //calculate result
          for(int i=1;i<=distance;i++){
              for(int j=1;j<=distance-i;j++){
                  result[0] += left[i]*right[j];
              }
          }
  
          int[] leafDistance = new int[distance+1];
          for(int i=1;i<distance;i++){
              leafDistance[i+1]= left[i]+ right[i];
          }
          return leafDistance;
      }
  }
  

// 2ms 44.69MB
class NumberOfGoodLeafNodesPairs_Solution2 {
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }
    
    int[] dfs(TreeNode root,int distance){
        if(root == null)
            return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1]++;
            return res;
        }
        int[] left = dfs(root.left,distance);
        int[] right = dfs(root.right,distance);
        for(int l=1;l<left.length;l++){
            for(int r = distance-1;r>=0;r--){
                if(l+r <=distance)
                result += left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i=res.length-2;i>=1;i--){
            res[i+1] = left[i]+right[i];
        }
        
        return res;
    }
}