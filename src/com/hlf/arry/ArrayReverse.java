package com.hlf.arry;

import java.util.Arrays;

/**
 * @author hlf
 * @Classname 数组反转
 * @Description
 * @Date 2023/4/27 10:27 上午
 */
public class ArrayReverse {

    public static int[] arrayReverse(int[] nums ,int star,int end){

        while (star<end){
            int temp = nums[end];
            nums[end--]=nums[star];
            nums[star++]= temp;
        }
        return nums;

    }

    public static int[] arrayReverse(int[] nums ,int k){
        k = k% nums.length;
        int end = nums.length-1;
        //先全部反转
        //1234567->7654321
        arrayReverse(nums,0,end);
        //再对前k-1反转从nums[0]->nums[2]
        //765->567
        arrayReverse(nums,0,k-1);
        //对k后反转
        //num[3]->num[end] 4321->1234
        arrayReverse(nums,k,end);
        return  nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arrayReverse(nums,1)));
    }

}
