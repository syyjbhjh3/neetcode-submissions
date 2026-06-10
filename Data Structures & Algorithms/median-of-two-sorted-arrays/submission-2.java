class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();

        for (int i=0; i<nums1.length; i++) {
            nums.add(nums1[i]);
        }

        for (int i=0; i<nums2.length; i++) {
            nums.add(nums2[i]);
        }
 
        Collections.sort(nums);
        
        if (nums.size()%2==1){
            return (double) nums.get(nums.size()/2); 
        } else {
            int answer = nums.get(nums.size()/2) + nums.get(nums.size()/2-1);
            return (double) answer/2;
        }
    }
}
