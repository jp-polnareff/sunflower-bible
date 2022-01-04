package com.leetcode.editor.leetcode.editor.cn;//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 👍 973 👎 0


public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
        System.out.println(solution.maximalSquare(new char[][]{
//                new char[]{'0', '1', '1', '0', '0', '1', '0', '1', '0', '1'},
//                new char[]{'0', '0', '1', '0', '1', '0', '1', '0', '1', '0'},
//                new char[]{'1', '0', '0', '0', '0', '1', '0', '1', '1', '0'},
//                new char[]{'0', '1', '1', '1', '1', '1', '1', '0', '1', '0'},
//                new char[]{'0', '0', '1', '1', '1', '1', '1', '1', '1', '0'},
//                new char[]{'1', '1', '0', '1', '0', '1', '1', '1', '1', '0'},
//                new char[]{'0', '0', '0', '1', '1', '0', '0', '0', '1', '0'},
//                new char[]{'1', '1', '0', '1', '1', '0', '0', '1', '1', '1'},
//                new char[]{'0', '1', '0', '1', '1', '0', '1', '0', '1', '1'}

                new char[]{'1', '1', '0', '1'},
                new char[]{'1', '1', '0', '1'},
                new char[]{'1', '1', '1', '1'}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxLength = 0;

        public int maximalSquare(char[][] matrix) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col] == '1') {
                        calculateMax(row, col, matrix);
                    }
                }
            }
            return maxLength * maxLength;
        }

        private void calculateMax(int row, int col, char[][] matrix) {
            // 正方形最大可能边长
            maxLength = Math.max(maxLength, 1);
            int k = Math.min(matrix.length - row, matrix[0].length - col);
            for (int i = 1; i < k; i++) {
                boolean flag = true;
                if (matrix[row + i][col + i] == '0') {
                    break;
                }

                for (int j = 0; j < i; j++) {
                    if (matrix[row + i][col + j] == '0' || matrix[row + j][col + i] == '0') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    maxLength = Math.max(maxLength, i + 1);
                } else {
                    break;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}