class Solution {

    public String encode(List<String> strs) {
        String answer = "";
        String seperate = ":";
        
       if (strs.isEmpty()) return null;

        for (String str : strs) {
            answer += String.valueOf(str.length()) + seperate + str;
        }

        return answer;
    }

    public List<String> decode(String str) {
        List<String> answer = new ArrayList<>();
        String seperate = ":";

        if (str == null) return answer;

        boolean flag = true;

        while(flag) {
            int index = str.indexOf(seperate);
            int len = Integer.parseInt(str.substring(0, index));

            //answer.add(str.substring(index+1, index+len+1));
            answer.add(str.substring(index + 1, index + 1 + len));
            //str = str.substring(len+2, str.length());
            str = str.substring(index + 1 + len);

            if(str.indexOf(seperate) < 0) {
                flag = false;
            }  
        }
        return answer;
    }
}
