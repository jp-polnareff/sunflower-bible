package com.leetcode.editor;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4251 👎 0


public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

        System.out.println(solution.longestPalindrome("bb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            // 边界判断
            if (chars.length < 2) {
                return String.valueOf(chars[0]);
            }
            boolean[][] dp = new boolean[s.length()][s.length()];
            // 初始化
            for (int i = 0; i < s.length() - 1; i++) {
                dp[i][i] = true;
            }
            int start = 0;
            int maxLength = 1;
            // 构建数组
            for (int i = 0; i <= chars.length - 1; i++) {
                for (int j = 0; j < i; j++) {
                    int length = i - j + 1;
                    if (chars[i] != chars[j]) {
                        dp[j][i] = false;
                    } else if (chars[i] == chars[j]) {
                        if (length == 2) {
                            dp[j][i] = true;
                        } else {
                            dp[j][i] = dp[j + 1][i - 1];
                        }
                        if (dp[j][i] && (i - j + 1) > maxLength) {
                            start = j;
                            maxLength = (i - j + 1);
                        }
                    }
                }
            }
            return s.substring(start, start + maxLength);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}