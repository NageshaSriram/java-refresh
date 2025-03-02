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

        // maxSumSubArray
        int[] arrayOne = {1,12,-5,-6,50,3};
        double res3 = maxSumSubArray(arrayOne, 4);
        System.out.println(res3);

        // Leetcode #3: Longest Substring Without Repeating Characters
        int res4 = longestSubStr("ckilbkd");
        System.out.println("Longest sub string is: " + res4);

        
    }

    // Input: "abcabcbb"
    // I tried this one, it won't work
    private static int longestSubStr(String s) {
        int left = 0, max = 0;
        Set<Character> set =  new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, set.size());
        }
        return max;
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

    // Maximum Average Subarray
    public static double maxSumSubArray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0.0; // Edge case

        // Step 1: Compute the sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            windowSum = windowSum - arr[i - k] + arr[i]; // Slide window
            maxSum = Math.max(maxSum, windowSum);
        }

        // Step 3: Return the maximum average
        return (double) maxSum / k;
    }
}
