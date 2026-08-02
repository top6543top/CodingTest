class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        for(int i=0;i<mats.length;i++){
            int size = mats[i];
            int parkYsize = park.length;
            int parkXsize = park[0].length;
            
            for(int j=0;j<parkYsize;j++){
                for(int k=0;k<parkXsize;k++){
                    if(j+size>parkYsize || k+size>parkXsize || !park[j][k].equals("-1")){
                        continue;
                    }
                    
                    int flag=0;
                    
                    outer:
                    for(int l=0;l<size;l++){
                        for(int m=0;m<size;m++){
                            int ny=j+l;
                            int nx=k+m;
                            if(!park[ny][nx].equals("-1")){
                                flag=1;
                                break outer;
                            }
                        }
                    }
                    
                    if(flag==0){
                        answer=Math.max(answer,size);
                    }
                    
                }
            }
            
        }
        
        if(answer == 0) answer = -1;
        
        return answer;
    }
}