import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int max_result=0;
        boolean visited[] = new boolean[cards.length];
        ArrayList<Integer> arr=new ArrayList<>();
        
        for(int i=0;i<cards.length;i++){
            int cnt=0;
            if(visited[i]) continue;
            
            visited[i] =true;
            int nxt=cards[i]-1;
            cnt++;
            while(true){
                if(visited[nxt]) break;
                visited[nxt]=true;
                nxt=cards[nxt]-1;
                cnt++;
            }
            arr.add(cnt);
        }
        
        int result=0;
        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                result = Math.max(result, arr.get(i)*arr.get(j));
            }
        }
        
        return result;
    }
}