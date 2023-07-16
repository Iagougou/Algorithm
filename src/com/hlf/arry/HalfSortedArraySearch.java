package com.hlf.arry;

/**
 * 部分有序数组查询（小红书）
 */
public class HalfSortedArraySearch {

    /**
     * 关键思想循环，如果不位于有序数组，又重新进行中间节点的判断逻辑
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int  target){
        int left = 0;
        int right = nums.length -1;
        int mid = left +(right-left)/2;
        while (left<=right){
            if (nums[mid]==target){
                return mid;
            }
            //前半段有序  34567[8]012
            if (nums[mid]>nums[left]){
                if (target<nums[mid]&&target>nums[left]){
                    right = mid -1;
                }else {
                    left = mid +1;
                }

                //后半段有序 7801[2]345
            }else {
                if (target>nums[mid]&& target<nums[right]){
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }
        }
        return  -1;
    }

}
