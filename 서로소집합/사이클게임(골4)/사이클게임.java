import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n,m;
    static int parents[];
    public static boolean union(int x,int y){
        x=find(x);
        y=find(y);
        if(x==y) return false;

        if(x<y) parents[x]=y;
        else parents[y]=x;
        return true;
    }
    public static int find(int x){
        if(parents[x]==x) return x;
        return parents[x] = find(parents[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken()); // 점의 개수
        m=Integer.parseInt(st.nextToken()); // 관계의 개수

        parents=new int[n];
        for (int i=0;i<n;i++) {
            parents[i]=i;
        }

        int cnt=0,flag=0,result=0;
        for (int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(flag==1) continue;
            cnt++;
            if(!union(a,b)){
                flag=1;
            } 
        }

        if(flag==1){
            System.out.println(cnt);
        } else {
            System.out.println(0);   
        }
        
    }
}
