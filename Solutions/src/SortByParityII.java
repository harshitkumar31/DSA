import java.util.Arrays;

/**
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 *
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * Example 2:
 *
 * Input: nums = [2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 2 * 104
 * nums.length is even.
 * Half of the integers in nums are even.
 * 0 <= nums[i] <= 1000
 */
public class SortByParityII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByParity(new int[]{5, 2, 4, 7})));
    }

    public static int[] sortByParity(int[] nums) {
        int even =0, odd =1;
        while(even < nums.length && odd < nums.length) {
            if(nums[even]%2==0){
                even +=2;
            } else if(nums[odd]%2!=0) {
                odd +=2;
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even+=2;
                odd+=2;
            }
        }

        return nums;
    }
}
