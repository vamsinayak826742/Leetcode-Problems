/* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged_array=new int[nums1.length+nums2.length];
        int j=0;
        for(int i=0;i<nums1.length;i++)
        {
            merged_array[j++]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++)
        {
            merged_array[j++]=nums2[i];
        }
        Arrays.sort(merged_array);
        double ans=0;
        if(j%2==0)
        {
            double a=merged_array[j/2];
            double b=merged_array[(j/2)-1];
            ans=(a+b)/2;
           // System.out.println(a+" "+b);
        }
        else
        {
            ans=merged_array[j/2];
        }
        
        return ans;
    }
    
}