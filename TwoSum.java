import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*	两数之和
 * 	给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

	你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums ={2,7,3,6};
		int target = 9;
		Solution s = new Solution();
		int[] result = s.twoSum(nums,target);
		int[] result2 = s.twoSum2(nums,target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	} 
}
/*	遍历
 * 时间复杂度：O(n2)
 * 空间复杂度:O(1)
 * */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0] =i;
                    result[1] = j;
                    return result;
                }
            } 
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /*
     * hash 查询
     *	时间复杂度：O(n)
     *	空间复杂度:O(n)
     * */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

