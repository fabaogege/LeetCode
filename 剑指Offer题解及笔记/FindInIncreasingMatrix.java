package exercise;

/**
 * 题目：在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。　　
 */

import java.util.Random;

/**
 * 思路：由于二维数组的行和列都是递增的  所以从右上角的数字(或者左下角)进行对比
 * 如果目标数等于该数字，则查找结束
 * 如果目标数大于该数，则排除该数所在行
 * 如果目标数小于该数，则排除该数所在列
 * 这样每次都能减少一行或者一列。缩小查找范围，直至找到或者为空。
 */
public class FindInIncreasingMatrix {
    public static void main(String[] args) {
        //  1   2   8   9
        //  2   4   9   12
        //  4   7   10  13
        //  6   8   11  15
        // 要查找的数在数组中
        int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        int target = new Random().nextInt(20)+1;
        System.out.println(target);
        Solution s = new Solution();
        System.out.print(s.findInIncreasingMatrix(matrix,target));
    }
}
class Solution{
    public boolean findInIncreasingMatrix(int[][] matrix,int target){
        boolean isFind = false;
        if(matrix!=null&&matrix.length>0&&matrix[0].length>0){
            int row = 0;
            int colunm =matrix[0].length-1;
            while (row<matrix.length&&colunm>=0){
                if(matrix[row][colunm]==target){
                    isFind=true;
                    break;
                }else if(matrix[row][colunm]>target){
                    colunm--;
                }else{
                    row++;
                }
            }
        }
        return isFind;
    }
}