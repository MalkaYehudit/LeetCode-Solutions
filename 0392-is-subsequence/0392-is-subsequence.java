
class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<t.length();i++){
            stack.push(t.charAt(i));
        }
        int place = s.length()-1;
        while(place!=-1){
            if(stack.isEmpty())
                return false;
            if(stack.pop()==s.charAt(place))
                place--;
           
        }
        return true;
    }
}
