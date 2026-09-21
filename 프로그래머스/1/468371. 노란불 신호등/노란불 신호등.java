class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int cntSignals = signals.length;
        int[][] timeSignals = new int[cntSignals][10000000];
        
        int[] cnt = new int[cntSignals]; // 각 칸이 어디까지 왔는지
        int[] yellowCnt = new int[cntSignals]; // 각 신호등의 Yellow의 길이
        int[] greenRedCnt = new int[cntSignals]; // 빨강 + 초록의 길이
        
        for(int i=0;i<cntSignals;i++){
            yellowCnt[i]=signals[i][1];
            greenRedCnt[i]=signals[i][0]+signals[i][2];
        }
        
        for(int i=0;i<cntSignals;i++){
            cnt[i] = signals[i][0];
        }
        
        for(int i=0;i<cntSignals;i++){
            while(cnt[i]<10000000){
                for(int j=0;j<yellowCnt[i];j++){
                    if(cnt[i]>=10000000) break;
                     timeSignals[i][cnt[i]++]=1;
                }
                cnt[i]+=greenRedCnt[i];
            }
        }
        
        for(int i=0;i<cntSignals;i++){
            for(int j=0;j<20;j++){
                System.out.print(timeSignals[i][j]);
            }
            System.out.println();
        }
        
        // 전부 1인걸 구한기만 하면된다
        
        for(int i=0;i<10000000;i++){
            int flag=0;
            for(int j=1;j<cntSignals;j++){
                if(timeSignals[j][i]==1 && timeSignals[j][i]==timeSignals[j-1][i]) flag=1;
                else {flag=0; break;}
            }
            
            if(flag==1){
                return i+1;
            }
        }
        
        return -1;
    }
}
