package BetterCodeAnswer.Medium.TreeNode;

import BetterCodeAnswer.Medium.TreeNode.Class.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-difference-between-node-and-ancestor/">1026.Maximum Difference Between Node and Ancestor</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>root</code> of a binary tree, find the maximum value <code>v</code> for which there exist <strong>different</strong> nodes <code>a</code> and <code>b</code> where <code>v = |a.val - b.val|</code> and <code>a</code> is an ancestor of <code>b</code>.</p>

<p>A node <code>a</code> is an ancestor of <code>b</code> if either: any child of <code>a</code> is equal to <code>b</code>&nbsp;or any child of <code>a</code> is an ancestor of <code>b</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree.jpg" style="width: 400px; height: 390px;">
<pre><strong>Input:</strong> root = [8,3,10,1,6,null,14,null,null,4,7,13]
<strong>Output:</strong> 7
<strong>Explanation: </strong>We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/09/tmp-tree-1.jpg" style="width: 250px; height: 349px;">
<pre><strong>Input:</strong> root = [1,null,2,null,0,3]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[2, 5000]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        Object[][] tests = {
            {8,3,10,1,6,null,14,null,null,4,7,13},
            {1,null,2,null,0,3},
        };

        for (Object[] arr : tests) {
            TreeNode root1 = TreeNode.addNode(arr,0);

            System.out.println(new MaximumDifferenceBetweenNodeAndAncestor_Solution().maxAncestorDiff(root1));
        }
    }
}

// 0 ms 42.7 MB
class MaximumDifferenceBetweenNodeAndAncestor_Solution {
    public int maxAncestorDiff(TreeNode root) {
        int[] m = {0};
        dfs(root, m);
        return m[0];
    }

    private int[] dfs(TreeNode root, int[] m) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = dfs(root.left, m);
        int[] right = dfs(root.right, m);

        int minVal = Math.min(root.val, Math.min(left[0], right[0]));
        int maxVal = Math.max(root.val, Math.max(left[1], right[1]));

        m[0] = Math.max(m[0], Math.max(Math.abs(minVal - root.val), Math.abs(maxVal - root.val)));

        return new int[]{minVal, maxVal};
    }
}

