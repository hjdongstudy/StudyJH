package com.hjdong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1FindSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(twoSum(new int[] {-3,4,3,90}, 0)));
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] != target) {
					continue;
				}
				System.out.println(i + " " + j);
				return new int[] { i, j };
			}
		}
		return new int[] { -1, -1 };
	}
	
	
	public static int[] twoSumnew(int[] nums, int target) {
		Map<Integer, Integer> num2index = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			num2index.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (num2index.get(target - nums[i]) != null && num2index.get(target - nums[i]) != i) {
				return new int[] {i, num2index.get(target - nums[i])};
			}
		}
		return new int[] { -1, -1 };
	}

}
