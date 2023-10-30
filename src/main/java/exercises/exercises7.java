package exercises;

public class exercises7 {

    /**
     * 给定一个数组arr,只能对arr中的一个子数组排序
     * 但是想让arr整体都有序
     * 返回满足这一设定的子数组中，最短的是多长
     */

    public static int minSubArrLength(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int leftMax = arr[0];
        int rightIndex = 0;
        for (int i = 1;i<arr.length;i++){
            if(arr[i] < leftMax){
                rightIndex = i;
                continue;
            }
            leftMax = arr[i];
        }

        int leftIndex = 0;
        int rightMin = arr[arr.length-1];
        for (int j = arr.length-2;j>=0;j++){
            if(arr[j] < rightMin){
                rightMin = arr[j];
                continue;
            }
            leftIndex = j;
        }

        return rightIndex-leftIndex;
    }
}
