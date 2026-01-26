class Solution {
    public long calculateScore(String s) {
        HashMap<Integer,Stack<Integer>> map = new HashMap<>();
        for(int i=0;i<26;i++) map.put(i,new Stack<>());
        long ans = 0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-97; 
            if(map.containsKey(25-c)){
                if(map.get(25-c).size() != 0){
                    ans += (i - map.get(25-c).pop());
                }
                else{
                    map.get(c).push(i);
                }
            }
            else{
                map.get(c).push(i);
            }
        }
        return ans;
    }
}