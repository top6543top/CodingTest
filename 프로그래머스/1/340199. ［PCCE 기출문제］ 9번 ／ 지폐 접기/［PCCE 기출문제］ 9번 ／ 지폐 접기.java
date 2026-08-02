import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        // 0이 가로, 1이 세로라고 생각하자
        while(true){
            if((bill[0]<=wallet[0] && bill[1]<=wallet[1]) ||
                    (bill[1]<=wallet[0] && bill[0]<=wallet[1])){
                break;
            }
            
            int[] bill_min=new int[2];
            int[] bill_max=new int[2];
            int[] wallet_min=new int[2];
            int[] wallet_max=new int[2];
            
            if(bill[0]>=bill[1]){
                bill_max[0]=bill[0];
                bill_min[0]=bill[1];
                bill_max[1]=0;
                bill_min[1]=1;
            } else {
                bill_max[0]=bill[1];
                bill_min[0]=bill[0];
                bill_max[1]=1;
                bill_min[1]=0;
            }
            
            if(bill_min[0]>wallet_min[0] || bill_max[0]>wallet_max[0]){
                int bill_half = bill_max[0]/2;
                bill[bill_max[1]]=bill_half;
            }
            
            answer++;
        }
        return answer;
    }
}