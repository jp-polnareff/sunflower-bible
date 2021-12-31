package com.leetcode.editor.leetcode.editor.cn;  //给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 👍 1009 👎 0


import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] L = new int[nums.length];
            L[0] = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                L[i + 1] = nums[i] * L[i];
            }
            int p = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i != nums.length - 1) {
                    p *= nums[i + 1];
                }
                L[i] = L[i] * p;
            }
            return L;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}