package com.leetcode.editor.leetcode.editor.cn;//给定一个经过编码的字符串，返回它解码后的字符串。
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 👍 968 👎 0


import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        Solution solution = new DecodeString().new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<String> strStack = new Stack<>();
            // 记录数字的变量
            int digit = 0;
            // 记录连续字符变量
            StringBuilder curr = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 次数计算
                if (Character.isDigit(c)) {
                    digit = digit * 10 + c - '0';
                } else if (c == '[') {
                    // 压站，初始化变量
                    numStack.push(digit);
                    strStack.push(curr.toString());
                    digit = 0;
                    curr = new StringBuilder();
                } else if (c == ']') {
                    // 计算最内层[]中的值
                    Integer count = numStack.pop();
                    StringBuilder tempStr = new StringBuilder(strStack.pop());
                    for (Integer integer = 0; integer < count; integer++) {
                        tempStr = tempStr.append(curr);
                    }
                    curr = tempStr.append(curr);
                } else {
                    curr.append(c);
                }
            }
            return curr.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}