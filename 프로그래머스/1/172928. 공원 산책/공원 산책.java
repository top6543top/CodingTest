class Solution {
    // N : 북쪽 , S : 남쪽 , W : 서쪽 , E : 동쪽
    // 0 : 북쪽 , 1 : 남쪽 , 2 : 서쪽 , 3 : 동쪽
    private final int[] dx = {0,0,-1,1};
    private final int[] dy = {-1,1,0,0};
    private int[] loc;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int parkYSize = park.length;
        int parkXSize = park[0].length();
        loc=new int[2];
        
        for(int i=0;i<parkYSize;i++){
            for(int j=0;j<parkXSize;j++){
                if(park[i].charAt(j) == 'S'){
                    loc[0]=i;
                    loc[1]=j;
                }
            }
        }

        for(int i=0;i < routes.length;i++){
            char NSWE = routes[i].charAt(0);
            int nswe=0;
            int num = routes[i].charAt(2) - '0';
            switch (NSWE){
                case 'N':
                    nswe=0;
                    break;
                case 'S':
                    nswe=1;
                    break;
                case 'W':
                    nswe=2;
                    break;
                case 'E':
                    nswe=3;
                    break;
            }
            
            
            int nx=loc[1]+dx[nswe]*num;
            int ny=loc[0]+dy[nswe]*num;
            
            System.out.println("1 :  "+ny+" "+nx+" "+parkYSize+" "+parkXSize);
            
            if(chkParkOut(ny,nx,parkYSize,parkXSize)) continue;
            if(chkX(ny,nx,nswe,num,park)) continue;
            
            System.out.println("2 :  "+ny+" "+nx);
            
            loc[0]=ny;
            loc[1]=nx;
        }
        
        answer[0]=loc[0];
        answer[1]=loc[1];
        return answer;
    }
    
    public boolean chkParkOut(int y,int x,int parkYSize,int parkXSize){
        return !(y>=0 && y<parkYSize && x>=0 && x<parkXSize);
    }
    
    public boolean chkX(int y, int x, int nswe, int num ,String[] park){
        for(int i=0;i<num;i++){
            int nx=x-dx[nswe]*i;
            int ny=y-dy[nswe]*i;
            if(park[ny].charAt(nx) == 'X') return true;
        }
        
        return false;
    }
}