package exercise;

/*
 题目： 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。 
 * */
//思路：由于数组其实一个递增的（当然也有可能会出现连续相同的数），所以考虑用2分的方式，能达到O(logn)。
public class MinNumberInRotateArray {
	public int minNumberInRotateArray(int[] array) {
		// 判断不为空且有值
		if (array == null) {
			throw new IllegalArgumentException("数组为空");
		}
		if (array.length <= 0) {
			return 0;
		}
		// 定义2个指针
		int low = 0;
		int hight = array.length - 1;
		int mid=low + (hight - low) / 2;
		while (array[low] >= array[hight]) {
			//只有2个值的情况
			if (hight - low == 1) {
				mid = hight;
				break;
			}
			mid = low + (hight - low) / 2;
			// 有可能3个数是一样的，这样就死循环了。
			if (array[low] == array[mid] && array[low] == array[hight]) {
				return minInOrder(array, low, hight);
			}
			if (array[low] <= array[mid]) {
				low = mid;
			} else if (array[mid] <= array[hight]) {
				hight = mid;
			}
		}
		return array[mid];
	}

	private int minInOrder(int[] arr, int low, int hight) {
		int result = arr[low];
		for (int i = low + 1; i <= hight; i++) {
			if (result > arr[i]) {
				result = arr[i];
			}
		}
		return result;
	}
}
