package BetterCodeAnswer.Medium.LinkedList;

import BetterCodeAnswer.Medium.LinkedList.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/remove-zero-sum-consecutive-nodes-from-linked-list/">1171.Remove Zero Sum Consecutive Nodes from Linked List</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>head</code> of a linked list, we repeatedly delete consecutive sequences of nodes that sum to <code>0</code> until there are no such sequences.</p>

<p>After doing so, return the head of the final linked list.&nbsp; You may return any such answer.</p>

<p>&nbsp;</p>
<p>(Note that in the examples below, all sequences are serializations of <code>ListNode</code> objects.)</p>

<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> head = [1,2,-3,3,1]
<strong>Output:</strong> [3,1]
<strong>Note:</strong> The answer [1,2,1] would also be accepted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [1,2,3,-3,4]
<strong>Output:</strong> [1,2,4]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = [1,2,3,-3,-2]
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The given linked list will contain between <code>1</code> and <code>1000</code> nodes.</li>
	<li>Each node in the linked list has <code>-1000 &lt;= node.val &lt;= 1000</code>.</li>
</ul>
</div>
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3,4,5},
            {1,2,-3,3,1},
            {1,2,3,-3,4},
            {1,2,3,-3,-2},
            {1,2,4,-3,1},
            {1,2,3,-6,-3,1}
        }; 

        for (int[] test : tests) {
            ListNode headA = ListNode.addNode(test, 0);
            ListNode ans = new RemoveZeroSumConsecutiveNodesFromLinkedList_Solution().removeZeroSumSublists(headA);
            System.out.println(ans == null? null : ans.toString());
        }
    }    
}

// 1 ms 42.7 MB
class RemoveZeroSumConsecutiveNodesFromLinkedList_Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)return head;
        ListNode prev = null;
        ListNode cur = head;
        int  running_sum=0;
        while(cur!=null)
        {
            running_sum += cur.val;
            if(running_sum==0)
            {
                if(prev == null)
                    head = cur.next;
                else
                    prev.next = cur.next;
                return removeZeroSumSublists(head);
            }
            cur = cur.next;
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}