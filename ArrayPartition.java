import java.util.Arrays;

/**
 * Created by lzp on 2018/4/25.
 * 数组划分：
 * 给定一个2n整数的数组，你的任务是将这些整数分成n对整数，例如（a 1，b 1），（a 2，b 2），...，（a n，b n）所有我从1到n 的min（a i，b i）之和尽可能大。

 输入： [1,4,3,2]

 输出： 4
 说明： n是2，并且最大和的对数是4 = min（1,2）+ min（3,4）。
 注意：
 n是一个正整数，在[1，10000]范围内。
 数组中的所有整数都在[-10000，10000]范围内。
 */
public class ArrayPartition {
    public static void main(String[] args) {
        int[] nums = {1,4,5,2};
        Solution s = new Solution();
        System.out.println(s.arrayPairSum(nums));
    }
}
//思路：对数组进行排序，取13579,然后求和得出结果
//可以用其他的数组排序方式（快排等）保证在未知数组大小的时候排序的效率，这里直接用Array.sort实现（未考虑效率）。
class Solution{
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i <nums.length ; i+=2) {
            result+=nums[i];
        }
        return result;
    }
}
