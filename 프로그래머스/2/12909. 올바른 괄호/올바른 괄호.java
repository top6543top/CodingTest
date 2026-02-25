class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int result=0;
        
        if(s.length() == 1){
            return false;
        }
        
        for(int i=0;i<s.length();i++){
            if(result<0){
                answer = false;
                break;
            }
            
            if(s.charAt(i) == '('){
                result++;
            } else {
                result--;
            }
        }
        
        if(result>0) answer=false;

        return answer;
    }
}