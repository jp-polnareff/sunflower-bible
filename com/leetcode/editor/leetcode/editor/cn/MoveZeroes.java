package com.leetcode.editor.leetcode.editor.cn;  //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 👍 1360 👎 0


public class MoveZeroes {
    public static void main(String[] args) {

        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int l = 0;
            int r = 0;
            while (r < nums.length) {
                if (nums[r] != 0) {
                    swap(l, r, nums);
                    l++;
                }
                r++;
            }
        }

        private void swap(int l, int r, int[] nums) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}