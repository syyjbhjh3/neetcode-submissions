class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sortS = new String(sArr);
        String sortT = new String(tArr);

        return sortS.equals(sortT);
    }
}
