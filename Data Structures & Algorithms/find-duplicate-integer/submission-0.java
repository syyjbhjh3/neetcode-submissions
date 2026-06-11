class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> dupl = new HashMap<>();

        for (int num : nums) {
            dupl.put(num, dupl.getOrDefault(num, 0) + 1);    
        }

        for (int num : nums) {
            if (dupl.get(num) > 1) return num;
        }
        return 0;
    }
}
