class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> sortMap = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            char[] sortArr = strs[i].toCharArray();
            Arrays.sort(sortArr);

            String sortStr = new String(sortArr);

            if (!sortMap.containsKey(sortStr)) {
                sortMap.put(sortStr, new ArrayList<>());
            }
            
            sortMap.get(sortStr).add(strs[i]);
        }

        return new ArrayList<>(sortMap.values());
    }
}
