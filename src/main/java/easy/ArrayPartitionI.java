package easy;

import java.util.*;

import static java.lang.Integer.min;

public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i=i+2){
            sum+=nums[i];
        }
        return sum;
    }
}
