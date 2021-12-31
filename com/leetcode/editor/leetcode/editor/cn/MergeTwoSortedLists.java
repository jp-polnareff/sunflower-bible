package com.leetcode.editor.leetcode.editor.cn;//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2088 👎 0


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution2 solution = new MergeTwoSortedLists().new Solution2();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1, new ListNode(4, new ListNode(4)));
        ListNode listNode = solution.mergeTwoLists(l1, l2);

        System.out.println(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode prehead = new ListNode(-1);

            ListNode prev = prehead;

            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    prev.next = list1;
                    prev = prev.next;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    prev = prev.next;
                    list2 = list2.next;
                }
            }
            prev.next = list1 == null ? list2 : list1;
            return prehead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}