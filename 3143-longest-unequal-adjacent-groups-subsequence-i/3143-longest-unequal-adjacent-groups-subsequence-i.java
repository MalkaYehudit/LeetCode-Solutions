class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(groups[i]==groups[i-1]){
                if(ans.get(ans.size()-1).length()<words[i].length()){
                    ans.remove(ans.size()-1);
                    ans.add(words[i]);
                }
            }
            else{
                    ans.add(words[i]);
            }
        }
        return ans;
    }
}