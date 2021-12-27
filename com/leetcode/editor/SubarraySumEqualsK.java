package com.leetcode.editor;//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1228 👎 0


import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {

        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            Map<Integer, Integer> map = new HashMap<>();
            int pre = 0;
            int count = 0;
            map.put(0, 1);
            for (final int num : nums) {
                pre += num;
                if (map.containsKey(pre - k)) {
                    count += map.get(pre - k);
                } else {
                    map.put(pre - k, map.getOrDefault(pre - k, 0) + 1);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}