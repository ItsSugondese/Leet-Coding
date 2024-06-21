package dsa.hard;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int mergeLength = nums1.length + nums2.length;
        int[] mergedArray = new int[mergeLength];

        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        sort(mergedArray);



        float division = (mergedArray.length + 1)/2f;
        if((mergedArray.length + 1)%2 != 0){
            return ((double) (mergedArray[(int) division - 1] + mergedArray[(((int) division) + 1)-1]) /2);
        }

            return mergedArray[(int) division -1];

    }

    public void sort(int[] in){
        for(int i=0; i<in.length; i++){
            for(int j =i+1; j<in.length; j++) {
                if (in[i] > in[j]) {
                    int temp = in[j];
                    in[j] = in[i];
                    in[i] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray array = new MedianOfTwoSortedArray();
        int[] check = new int[]{3,2,7,6,1};

        System.out.println(array.findMedianSortedArrays(new int[]{2,7,6,16, 33, 22,23}, new int[]{11,4,8,9,21,66,44}));

    }
}
