import java.util.Arrays;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class SetMismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
    }
    public static int[] findErrorNums(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            while(nums[i]!= nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            }
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                return new int[]{nums[i], i+1};
            }
        }

        return new int[]{0,0};
    }

}
