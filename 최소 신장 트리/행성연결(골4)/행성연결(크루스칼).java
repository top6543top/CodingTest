import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        parents=new int[n+1];
        for(int i=1;i<n+1;i++){
            parents[i]=i;
        }
        
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for (int j=0;j<i;j++) {
                String remove=st.nextToken();
            }
            for (int j=i+1;j<=n;j++) {
                pq.offer(new int[]{i,j,Integer.parseInt(st.nextToken())});
            }
        }

        long result=0;
        while(!pq.isEmpty()){
            int tmp[]=pq.poll();
            if(union(tmp[0],tmp[1])){
                result+=(long)tmp[2];
            }
        }
        System.out.println(result);
    }
    public static boolean union(int x,int y){
        x=find(x);
        y=find(y);
        if(x==y) return false;
        if(y>x) parents[y]=x;
        else parents[x]=y;
        return true;
    }
    public static int find(int x){
        if(parents[x]==x) return x;
        return find(parents[x]);
    }
}
