package org.dsa;


import java.util.*;

public class ArraysAndStrings {

    public static void main(String[] args) {
        int[] arr = {3,1,2,4,2,1,3};
        System.out.println(isArrayIsPalindrome(arr));

        // twoSumInSortedArray
        int[] sortedArr = {1,2,3,4,5,6,7,8,9};
        int[] res = twoSumInSortedArray(sortedArr, 5);
        System.out.println(res[0] + " " + res[1]);

        // threeSumInSortedArray
        int[] res1 = threeSumInSortedArray(sortedArr, 11);
        System.out.println(res1[0] + " " + res1[1] + " " + res1[2]);

        // threeSumToZero (Pending)
        int[] nums = {0,0,-2,-2,4,2,2,4,0};
        List<List<Integer>> res2 = threeSumToZero(nums);
        System.out.println("threeSumToZero " +res2);
    }

    public static boolean isArrayIsPalindrome(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int[] twoSumInSortedArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1, sum;

        while(left < right) {
            sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // if no element found
    }

    public static int[] threeSumInSortedArray(int[] arr, int target) {
        int left = 0, right = arr.length -1, rightLeft = right - 1, sum;
        while (left < rightLeft) {
            sum = arr[left] + arr[rightLeft] + arr[right];
            if (sum == target) {
                return new int[]{arr[left], arr[rightLeft], arr[right]};
            } else if(sum < target) {
                left++;
            } else {
                right--;
                rightLeft--;
            }
        }
        return new int[]{-1, -1, -1};
    }

    //{-1, 0, 1, 2, -1, -4};
    // res: [[-1, 0, 1], [-1, -1, 2]]
    public static List<List<Integer>> threeSumToZero(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) i++;
            int left = i+1, right = arr.length -1, sum =0;
            while (left < right) {
                sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    while((left < right) && arr[left] == arr[left-1]) {
                        left++;
                    }
                    while((left < right) && arr[right] == arr[right-1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
