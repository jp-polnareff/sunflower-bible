package com.leetcode.editor.leetcode.editor.cn;  //给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1214 👎 0


public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        solution.isPalindrome(new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1)))));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 获取需要反转的链表
            ListNode midNode = getMidNode(head);

            // 获取反转的链表
            ListNode reverseNode = reverseNode(midNode);

            while(head != null && reverseNode != null) {
                if(head.val != reverseNode.val){
                    return false;
                }
                head = head.next;
                reverseNode = reverseNode.next;
            }
            return true;
        }

        ListNode reverseNode(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }

        ListNode getMidNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null) {
                if (fast.next.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                } else {
                    fast = fast.next;
                }
            }
            ListNode resultNode = slow.next;
            slow.next = null;
            return resultNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}